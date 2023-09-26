import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

public class Startup {

	public static void showWindow() {
		
	    JWindow window = new JWindow();
	    
	    File file = new File("resources\\img\\logo.png");
		if(file.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "logo.png not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}

	    ImageIcon imageIcon = new ImageIcon("resources\\img\\logo.png");

	    JLabel label = new JLabel(imageIcon);
	    window.getContentPane().add(label, BorderLayout.CENTER);

	    window.pack();
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    window.setVisible(false);
	}
}