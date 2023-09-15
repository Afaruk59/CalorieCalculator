import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ambients {
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	static Clip music_1;
	static Clip music_2;
	static Clip music_3;
	static String clock;
	
	public void musicStarter() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
				
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
		clock = currentDate.format(timeFormat);
				
		if(clock.compareTo("06:00") >= 0 && clock.compareTo("18:00") < 0) {
			
			Thread t3 = new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						playAmbient1();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t3.start();
		}
		else {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						playAmbient2();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						playAmbient3();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException
							| InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t.start();
			t2.start();
		}
	}
	
	public void music1Stopper() {
		music_1.close();
	}
	
	public void music2Stopper() {
		music_2.close();
	}
	
	public void music3Stopper() {
		music_3.close();
	}

	public void playAmbient1() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		String path = "resources\\sound\\ambient1.wav";
		File file = new File(path);
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		music_1 = AudioSystem.getClip();
		music_1.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) music_1.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -40.0f;
        volumeControl.setValue(newVolume);
        
        music_1.start();
        
        while (!music_1.isRunning()) {
            Thread.sleep(10);
        }
        
        while(!(newVolume == -10.0f)) {
        	
            newVolume += 1.0f;
            volumeControl.setValue(newVolume);
            
            Thread.sleep(1000);
        }

        while (music_1.isRunning()) {
            Thread.sleep(10);
        }
        
        music_1.close();
        
        playAmbient1();
	}
	
	public void playAmbient2() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		String path = "resources\\sound\\ambient2.wav";
		File file = new File(path);
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		music_2 = AudioSystem.getClip();
		music_2.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) music_2.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -40.0f;
        volumeControl.setValue(newVolume);
        
        music_2.start();
        
        while (!music_2.isRunning()) {
            Thread.sleep(10);
        }
        
        while(!(newVolume == -10.0f)) {
        	
            newVolume += 1.0f;
            volumeControl.setValue(newVolume);
            
            Thread.sleep(1000);
        }

        while (music_2.isRunning()) {
            Thread.sleep(10);
        }
        
        music_2.close();
        
        playAmbient2();
	}
	
	public void playAmbient3() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		String path = "resources\\sound\\ambient3.wav";
		File file = new File(path);
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		
		music_3 = AudioSystem.getClip();
		music_3.open(audioInputStream);
           
        FloatControl volumeControl = (FloatControl) music_3.getControl(FloatControl.Type.MASTER_GAIN);
        float newVolume = -40.0f;
        volumeControl.setValue(newVolume);
        
        music_3.start();
        
        while (!music_3.isRunning()) {
            Thread.sleep(10);
        }
        
        while(!(newVolume == -12.0f)) {
        	
            newVolume += 1.0f;
            volumeControl.setValue(newVolume);
            
            Thread.sleep(1000);
        }

        while (music_3.isRunning()) {
            Thread.sleep(10);
        }
        
        music_3.close();
        
        playAmbient3();
	}
}
