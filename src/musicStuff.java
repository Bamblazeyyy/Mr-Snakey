import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	
	public void playMusic (String musicLocation) {
		
		try {
			File musicPath = new File(musicLocation);
			
			if (musicPath.exists()) {
		
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
				
		}	else {
			System.out.print("Cannot find the file");
		}
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
