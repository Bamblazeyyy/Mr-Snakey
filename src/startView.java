import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class startView implements ActionListener{
 

 JFrame frame = new JFrame();
 JButton myButton = new JButton("START");
 
 startView(){
  
	myButton.setBounds(300,500,300,85);
	myButton.setFocusable(false);
	myButton.setBackground(new Color(152, 133,88));
	myButton.setForeground(Color.white);
	myButton.addActionListener(this);
	myButton.setFont(new Font("BORSOK",Font.BOLD,30));
    
    frame.add(myButton);
	frame.setSize(915, 700);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container c = frame.getContentPane();  
	JLabel label = new JLabel();
	label.setIcon(new ImageIcon("snakelabel.png"));
	Dimension size = label.getPreferredSize();
	label.setBounds(25, 75, 850, 575);
	c.add(label);
	frame.setVisible(true);
	
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==myButton) {
   frame.dispose();
   SnakeFrame frame = new SnakeFrame();
  }
 }
}
