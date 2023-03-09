import java.awt.*;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		
	    startView startview = new  startView();
	    
		String filePath = "snakeySound.wav";
		musicStuff musicGame = new musicStuff();
		musicGame.playMusic(filePath); 
		
		
	}

}
