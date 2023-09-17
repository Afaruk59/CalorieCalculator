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
	static String[] tableTitles = {"", "", "", "", ""};
	
	public void turkish() throws IOException {
		
		tableTitles[0] = "İSİM";
		tableTitles[1] = "PROTEİN";
		tableTitles[2] = "KARB";
		tableTitles[3] = "YAĞ";
		tableTitles[4] = "KALORİ";
		
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
		
		tableTitles[0] = "NAME";
		tableTitles[1] = "PROTEIN";
		tableTitles[2] = "CARB";
		tableTitles[3] = "FAT";
		tableTitles[4] = "CALORIE";
		
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