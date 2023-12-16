import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen {
	
	/**
	 * 
	 * @author Afaruk59
	 */
		
	public static void welcomeFrame() throws InterruptedException, IOException {
				
		JFrame frame= new JFrame("Welcome to ACC " + Main.version);
		frame.setSize(750, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel fotoPanel = new JPanel();
		fotoPanel.setBounds(10, 11, 714, 405);
		fotoPanel.setLayout(new BoxLayout(fotoPanel, BoxLayout.X_AXIS));
		contentPane.add(fotoPanel);
		
		File file1 = new File("resources\\img\\tutorial_1.png");
		File file2 = new File("resources\\img\\tutorial_2.png");
		File file3 = new File("resources\\img\\tutorial_3.png");
		File file4 = new File("resources\\img\\tutorial_a.png");
		File file5 = new File("resources\\img\\tutorial_b.png");
		File file6 = new File("resources\\img\\tutorial_c.png");
		
		if(file1.exists() == false || file2.exists() == false || file3.exists() == false || file4.exists() == false || file5.exists() == false || file6.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "tutorial_x.png files not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		
		ImageIcon img1 = new ImageIcon("resources\\img\\tutorial_1.png");
		Image scaledImage1 = img1.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imgLab1 = new JLabel(scaledIcon1);
        fotoPanel.add(imgLab1);
        imgLab1.setVisible(false);
        
		ImageIcon img2 = new ImageIcon("resources\\img\\tutorial_2.png");
		Image scaledImage2 = img2.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel imgLab2 = new JLabel(scaledIcon2);
        fotoPanel.add(imgLab2);
        imgLab2.setVisible(false);
        
		ImageIcon img3 = new ImageIcon("resources\\img\\tutorial_3.png");
		Image scaledImage3 = img3.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        JLabel imgLab3 = new JLabel(scaledIcon3);
        fotoPanel.add(imgLab3);
        imgLab3.setVisible(false);
        
		ImageIcon img4 = new ImageIcon("resources\\img\\tutorial_a.png");
		Image scaledImage4 = img4.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
        JLabel imgLab4 = new JLabel(scaledIcon4);
        fotoPanel.add(imgLab4);
        imgLab4.setVisible(false);
        
		ImageIcon img5 = new ImageIcon("resources\\img\\tutorial_b.png");
		Image scaledImage5 = img5.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(scaledImage5);
        JLabel imgLab5 = new JLabel(scaledIcon5);
        fotoPanel.add(imgLab5);
        imgLab5.setVisible(false);
        
		ImageIcon img6 = new ImageIcon("resources\\img\\tutorial_c.png");
		Image scaledImage6 = img6.getImage().getScaledInstance(714, 405, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
        JLabel imgLab6 = new JLabel(scaledIcon6);
        fotoPanel.add(imgLab6);
        imgLab6.setVisible(false);
        
        if(Data.profile.getProperty("Theme").equals("0") == true) {
			imgLab4.setVisible(true);
        }else if(Data.profile.getProperty("Theme").equals("1") == true){
        	imgLab1.setVisible(true);
        }else if(Data.profile.getProperty("Theme").equals("2") == true) {
        	
    		LocalDateTime currentDate = LocalDateTime.now();
    		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    		String clock = currentDate.format(timeFormat);
    				
    		if(clock.compareTo("06:00") >= 0 && clock.compareTo("18:00") < 0) {
    			imgLab4.setVisible(true);
    		}else {
    			imgLab1.setVisible(true);
    		}
        }
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(614, 427, 110, 23);
		contentPane.add(nextButton);
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(imgLab1.isVisible() == true) {
				     imgLab1.setVisible(false);      
				     imgLab2.setVisible(true);
				}
				else if(imgLab2.isVisible() == true) {
				     imgLab2.setVisible(false);      
				     imgLab3.setVisible(true);
				}
				else if(imgLab3.isVisible() == true) {
				     imgLab3.setVisible(false);      
				     imgLab1.setVisible(true);
				}
				else if(imgLab4.isVisible() == true) {
				     imgLab4.setVisible(false);      
				     imgLab5.setVisible(true);
				}
				else if(imgLab5.isVisible() == true) {
				     imgLab5.setVisible(false);      
				     imgLab6.setVisible(true);
				}
				else if(imgLab6.isVisible() == true) {
				     imgLab6.setVisible(false);      
				     imgLab4.setVisible(true);
				}
			}
		});
		
		JButton skipButton = new JButton("Skip");
		skipButton.setBounds(10, 427, 110, 23);
		contentPane.add(skipButton);
		skipButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		
		Thread.sleep(1200);
		frame.setVisible(true);
	}
}
