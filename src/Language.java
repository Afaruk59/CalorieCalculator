import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Language {
	
	/**
	 * 
	 * @author Afaruk59
	 */
		
	static Properties lang = new Properties();
	static String[] foodTableTitles = {"", "", "", "", ""};
	
	public void turkish() throws IOException {
		
		File file = new File("resources//lang//tr.acc");
		if(file.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "tr.acc not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//tr.acc");
			lang.load(input);
			input.close();
			
			for(int i=0; i<5; i++) {
				foodTableTitles[i] = lang.getProperty("tableTitles_" + Integer.toString(i+1));
			}
		}
	}
	
	public void english() throws IOException {
		
		File file = new File("resources//lang//eng.acc");
		if(file.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "eng.acc not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//eng.acc");
			lang.load(input);
			input.close();
			
			for(int i=0; i<5; i++) {
				foodTableTitles[i] = lang.getProperty("tableTitles_" + Integer.toString(i+1));
			}
		}
	}
}