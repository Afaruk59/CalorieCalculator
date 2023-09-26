import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Effects {

	public static void playErrorSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		File file = new File("resources\\sound\\error.wav");
		
		if(file.exists() == false) {
			JOptionPane.showMessageDialog(null, "error.wav not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		Clip sound = AudioSystem.getClip();
		sound.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -15.0f;
        volumeControl.setValue(newVolume);
        
        Thread trd = new Thread(new Runnable() {

			@Override
			public void run() {

				sound.start();
		        
		        while (!sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }

		        while (sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }
		        
		        sound.close();
			}
        });
        trd.start();
	}
	
	public static void playMessageSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		File file = new File("resources\\sound\\message.wav");
		
		if(file.exists() == false) {
			JOptionPane.showMessageDialog(null, "message.wav not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		Clip sound = AudioSystem.getClip();
		sound.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -15.0f;
        volumeControl.setValue(newVolume);
        
        Thread trd = new Thread(new Runnable() {

			@Override
			public void run() {

				sound.start();
		        
		        while (!sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }

		        while (sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }
		        
		        sound.close();
			}
        });
        trd.start();
	}
	
	public static void playButtonSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		File file = new File("resources\\sound\\button.wav");
		
		if(file.exists() == false) {
			JOptionPane.showMessageDialog(null, "button.wav not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		Clip sound = AudioSystem.getClip();
		sound.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -17.0f;
        volumeControl.setValue(newVolume);
        
        Thread trd = new Thread(new Runnable() {

			@Override
			public void run() {

				sound.start();
		        
		        while (!sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }

		        while (sound.isRunning()) {
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }
		        
		        sound.close();
			}
        });
        trd.start();
	}
}