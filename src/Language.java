import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Language {
	
	/**
	 * 
	 * @author Afaruk59
	 */
		
	static Properties lang = new Properties();
	String[] tableTitlesEng = {"NAME","PROTEIN","CARB","FAT","CALORIE"};
	
	public void turkish() throws IOException {
		
		File file = new File("resources//lang//tr.acc");
		if(file.exists() == false) {
			JOptionPane.showMessageDialog(null, "tr.acc not found", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//tr.acc");
			lang.load(input);
			input.close();
		}
	}
	
	public void english() throws IOException {
		
		File file = new File("resources//lang//eng.acc");
		if(file.exists() == false) {
			JOptionPane.showMessageDialog(null, "eng.acc not found", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else {
			FileInputStream input = new FileInputStream("resources//lang//eng.acc");
			lang.load(input);
			input.close();
		}
	}
}