import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	static String[] tableTitles = {"", "", "", "", ""};
	
	public void turkish() throws IOException {
		
		File file = new File("resources//lang//tr.acc");
		if(file.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "tr.acc not found", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//tr.acc");
			lang.load(input);
			input.close();
			
			tableTitles[0] = lang.getProperty("tableTitles_1");
			tableTitles[1] = lang.getProperty("tableTitles_2");
			tableTitles[2] = lang.getProperty("tableTitles_3");
			tableTitles[3] = lang.getProperty("tableTitles_4");
			tableTitles[4] = lang.getProperty("tableTitles_5");
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
			JOptionPane.showMessageDialog(null, "eng.acc not found", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//eng.acc");
			lang.load(input);
			input.close();
			
			tableTitles[0] = lang.getProperty("tableTitles_1");
			tableTitles[1] = lang.getProperty("tableTitles_2");
			tableTitles[2] = lang.getProperty("tableTitles_3");
			tableTitles[3] = lang.getProperty("tableTitles_4");
			tableTitles[4] = lang.getProperty("tableTitles_5");
		}
	}
}