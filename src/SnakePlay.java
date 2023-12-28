import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePlay extends JPanel implements KeyListener, ActionListener {
	
	// x and y collisions
	private int[] snakexlength = new int [750];
	private int[] snakeylength = new int[750];
	
	// detect to what part of snake is moving
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;

	// snake faces and food
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon snakeimage;
	private ImageIcon burgerimage;
	
	// default length of snake
	private int lengthofsnake=3;
	
	//default position of picking up burger
	int[] burgerxpos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
			600,625,650,675,700,725,750,775,800,825,850};

	int[] burgerypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
			600,625};

	
	//Random position of burger
	private Random random = new Random();
	private int xpos = random.nextInt(33);
	private int ypos = random.nextInt(22);

    // manage the speed of snake in the panel
	private Timer timer;
	private int delay = 110;
	private int moves = 0;
	private int scores=0;
	private ImageIcon titleImage;

public SnakePlay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g) {
		// Default position of the snake
		if(moves == 0){
			snakexlength[0] = 100;
			snakexlength[1] = 75;
			snakexlength[2] = 50;

			snakeylength[0] = 100;
			snakeylength[1] = 100;
			snakeylength[2] = 100;
		}
		//border of title image
		g.setColor(Color.white);
		g.drawRect(24,10,851,55);

		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);

		/// draw border for title of SnakePlay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		// draw background for SnakePlay
		g.setColor (Color.black);
		g.fillRect(25, 75, 850, 575);

		//draw the scores and snake's length
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana",Font.PLAIN,17));
		g.drawString("Highest Scores : "+ scores, 50, 45);
		g.drawString("Snake Length : "+ lengthofsnake,743, 45);

		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

		//Detect the direction of snake where 'a' identifies the first index of the snake
		for(int a = 0; a< lengthofsnake; a++) {
			
			if(a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && left){
				leftmouth=new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && up){
				upmouth=new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && down) {
				downmouth=new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			// draw body of snake
			if(a!=0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g,snakexlength[a], snakeylength[a]);
			}
		}
		//check if burger collided with the head of snake
		burgerimage = new ImageIcon("food.png");

		if(burgerxpos[xpos]==snakexlength[0] && burgerypos[ypos]==snakeylength[0]) {
			lengthofsnake++;
			scores++;
			xpos = random.nextInt(33);
			ypos = random.nextInt(22); 	}

		burgerimage.paintIcon(this, g, burgerxpos[xpos], burgerypos[ypos]);

		for(int b=1; b<lengthofsnake; b++) {
			if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0]) {
				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.WHITE);
				g.setFont(new Font("Comic Sans MS Bold" ,Font.BOLD,53));
				g.drawString("Game Over!", 290, 340);

				g.setFont(new Font("arial",Font.BOLD,25));
				g.drawString("Space to RESTART", 340, 400);
				
				g.setFont(new Font("arial",Font.BOLD,23));
				g.drawString("Score : "+ scores, 400, 440);
			}
		}

		g.dispose();
	}
	// Movements of snake base on its body & check which variable is true
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(right) {
			for(int i = lengthofsnake-1; i>=0; i--) {
				snakeylength[i+1] = snakeylength[i];
			}
			for(int i = lengthofsnake; i>=0; i--) {
				if(i==0) {
					snakexlength[i] = snakexlength[i] + 25;
				}
				else {
					snakexlength[i] = snakexlength[i-1];
				}
				// Collision of snake to right border 
				if(snakexlength[i] > 825) {
					snakexlength[i] = 25;
				}
			}

			repaint();
		}
		
		if(left) {
			for(int i=lengthofsnake-1; i>=0; i--) {
				snakeylength[i+1]=snakeylength[i];
			}
			for(int i=lengthofsnake; i >= 0;i--) {
				if(i==0) {
					snakexlength[i] = snakexlength[i]-25;
				}
				else {
					snakexlength[i] = snakexlength[i-1];
				}
				// Collision of snake to left border 
				if(snakexlength[i] < 25) {
					snakexlength[i] = 825;
				}
			}

			repaint();
		}

		if(up) {
			for(int i=lengthofsnake-1; i>=0; i--) {
				snakexlength[i+1] = snakexlength[i];
			}
			for(int i=lengthofsnake; i >=0; i--) {
				if(i==0) {
					snakeylength[i] = snakeylength[i]-25;
				}
				else {
					snakeylength[i] = snakeylength[i-1];
				}
				// Collision of snake to up border 
				if(snakeylength[i] < 75) {
					snakeylength[i] = 600;
				}
			}
			repaint();
		}
		
		if(down) {
			for(int i=lengthofsnake-1; i>=0; i--) {
				snakexlength[i+1] = snakexlength[i];
			}
			for(int i=lengthofsnake; i>=0; i--) {
				if(i==0) {
					snakeylength[i] = snakeylength[i]+25;
				}
				else {
					snakeylength[i] = snakeylength[i-1];
				}
				// Collision of snake to down border 
				if(snakeylength[i] > 600) {
					snakeylength[i] = 75;
				}
			}
			repaint();
		}
	}

	//Implements movement of snake based on arrow keys
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			moves++;
			right = true;
			
			if(!left) {
				right = true; }
			else {
				right = false;
				left = true; }
			up = false;
			down = false; }
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			
			if(!right) {
				left = true; }
			else {
				left = false;
				right = true;  }
			up = false;
			down = false; }
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true; 
			
			if(!down) {
				up = true; }
			else {
				up = false;
				down = true;}
			left = false;
			right = false; }
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			
			if(!up) {
				down = true;}
			else {
				down = false;
				up = true; }
			left = false;
			right = false;}

		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			scores = 0;
			moves = 0;
			lengthofsnake=3;
			repaint(); }
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
}
