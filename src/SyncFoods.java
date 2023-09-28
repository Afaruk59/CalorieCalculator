import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class SyncFoods extends gUI{

	@SuppressWarnings("deprecation")
	public static void syncEng() {
		
        String engPath = "https://drive.google.com/uc?export=download&id=1-oL9FFNSDg_LxcqJk5jlyIzitWV85WqK";
        String savePath1 = "resources\\";
        


        try {
            URL url = new URL(engPath);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            InputStream inputStream = connection.getInputStream();
            
            String fileName = "defFoodsEng.acc";
            String filePath = savePath1 + fileName;
            
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
            JOptionPane.showMessageDialog(null, "Synchronization Failed.\nPlease retry.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}

	@SuppressWarnings("deprecation")
	public static void syncTr() {
		
    String trPath = "https://drive.google.com/uc?export=download&id=1Opo_KZzBmb13dkC7d1mNm2nqYri5-gAp";
    String savePath = "resources\\";

        try {
            URL url = new URL(trPath);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            InputStream inputStream = connection.getInputStream();
            
            String fileName = "defFoodsTr.acc";
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
            JOptionPane.showMessageDialog(null, "Synchronization Failed.\nPlease retry.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
}