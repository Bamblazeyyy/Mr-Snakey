import java.awt.Color;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	
	SnakeFrame(){
		
		
		JFrame frame = new JFrame();
		SnakePlay play = new SnakePlay();
		
		frame.setBounds(10,10,915,700);
		frame.setBackground(new Color(152, 133, 88));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(play);	
		frame.setVisible(true);
	}
	
}