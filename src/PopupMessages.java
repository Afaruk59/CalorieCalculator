import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class PopupMessages {

	public static void infoMessage(String message, String title) {
		
		try {
			Effects.playMessageSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void errorMessage(String message, String title) {
		
		try {
			Effects.playErrorSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static int confirmMessage(String message, String title) {
		
		try {
			Effects.playMessageSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
			e1.printStackTrace();
		}
		
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	}
}