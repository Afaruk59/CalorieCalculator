import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class VersionCheck {

	@SuppressWarnings("deprecation")
	public void verCheck() throws IOException {

		Properties ver = new Properties();
		
		File verini = new File("resources\\ver.ini");
		if(verini.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "ver.ini not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		FileInputStream input = new FileInputStream("resources\\ver.ini");
		ver.load(input);
		input.close();
		
		int currentVer = Integer.parseInt(ver.getProperty("ver"));
		
        String urlStr = "https://drive.google.com/uc?export=download&id=1kTOnHQOKdflHNzO8ngvoFtBMulWLUp3I";
        String savePath = "";

        try {
            URL url = new URL(urlStr);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            InputStream inputStream = connection.getInputStream();
            
            String fileName = "ver.ini";
            String filePath = savePath + fileName;
            
            OutputStream outputStream = new FileOutputStream(filePath);
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            inputStream.close();
            outputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
            JOptionPane.showMessageDialog(null, "Checking Failed.\nPlease retry.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
		Properties ver2 = new Properties();
		
		FileInputStream input2 = new FileInputStream("ver.ini");
		ver2.load(input2);
		input2.close();
		
		int newVer = Integer.parseInt(ver2.getProperty("ver"));
		
		File file = new File("ver.ini");
		file.delete();
		
		if(currentVer != newVer) {			
			try {
				Effects.playMessageSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			int result = JOptionPane.showConfirmDialog(null, "Download the new version? ", "Confirmation", JOptionPane.YES_NO_OPTION);
			
			if(result == JOptionPane.YES_OPTION) {

		        try {

		        	download("https://drive.google.com/uc?export=download&id=1o_QIPh1XS34c1p3eq6v1r0WQMT9DKoVt", "resources\\jar\\", "ACC.jar");
		        	download("https://drive.google.com/uc?export=download&id=1Uj4uM2n4MQsVkhx4e2hftm_SbW1n6O3w", "resources\\lang\\", "eng.acc");
		        	download("https://drive.google.com/uc?export=download&id=1hijy1zK37pkOcHLAOrVrsMt4tYaSXULA", "resources\\lang\\", "tr.acc");
					try {
						Effects.playMessageSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
		            JOptionPane.showMessageDialog(null, "The new version successfully downloaded.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
		            
					ver.setProperty("ver", Integer.toString(newVer));
					FileOutputStream output = new FileOutputStream("resources\\ver.ini");
					ver.store(output, "PROFILE#");
					output.close();
					
		            System.exit(0);
		        } catch (IOException e) {
		            e.printStackTrace();
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
		            JOptionPane.showMessageDialog(null, "Download Failed.\nPlease retry.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		}
		else {
			try {
				Effects.playMessageSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "The program is up to date.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void download(String urlStr, String savePath, String name) throws IOException {
        
        URL url = new URL(urlStr);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        InputStream inputStream = connection.getInputStream();
        
        String fileName = name;
        String filePath = savePath + fileName;
        
        OutputStream outputStream = new FileOutputStream(filePath);
        
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        
        inputStream.close();
        outputStream.close();
	}
}