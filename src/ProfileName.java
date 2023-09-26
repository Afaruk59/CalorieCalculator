import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProfileName extends gUI{
	
	/**
	 * 
	 * @author Afaruk59
	 */

	public static void coffeeAnimation() {
				
		JPanel coffeePanel = new JPanel();
		coffeePanel.setLayout(new BoxLayout(coffeePanel, BoxLayout.X_AXIS));
		coffeePanel.setBounds(1101,6,25,25);
		mainFrame.add(coffeePanel);
				
		File file1 = new File("resources\\img\\acc1.png");
		File file2 = new File("resources\\img\\acc2.png");
		File file3 = new File("resources\\img\\acc3.png");
		File file4 = new File("resources\\img\\acc4.png");
		
		if(file1.exists() == false || file2.exists() == false || file3.exists() == false || file4.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "accx.png files not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon img1 = new ImageIcon("resources\\img\\acc1.png");
		Image scaledImage1 = img1.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imgLab1 = new JLabel(scaledIcon1);
        coffeePanel.add(imgLab1);
        imgLab1.setVisible(false);

		ImageIcon img2 = new ImageIcon("resources\\img\\acc2.png");
		Image scaledImage2 = img2.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel imgLab2 = new JLabel(scaledIcon2);
        coffeePanel.add(imgLab2);
        imgLab2.setVisible(false);
        
		ImageIcon img3 = new ImageIcon("resources\\img\\acc3.png");
		Image scaledImage3 = img3.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        JLabel imgLab3 = new JLabel(scaledIcon3);
        coffeePanel.add(imgLab3);
        imgLab3.setVisible(false);
        
		ImageIcon img4 = new ImageIcon("resources\\img\\acc4.png");
		Image scaledImage4 = img4.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
        JLabel imgLab4 = new JLabel(scaledIcon4);
        coffeePanel.add(imgLab4);
        imgLab4.setVisible(false);
        
        Thread trd = new Thread(new Runnable() {

			@Override
			public void run() {

		        while(true) {
		        	try {
			    		if(Data.profile.getProperty("Theme").equals("1") == true) {
							imgLab3.setVisible(true);
							Thread.sleep(1000);
							imgLab3.setVisible(false);
							imgLab4.setVisible(true);
							Thread.sleep(1000);
							imgLab4.setVisible(false);
			    		}
			    		else if(Data.profile.getProperty("Theme").equals("0") == true) {
							imgLab1.setVisible(true);
							Thread.sleep(1000);
							imgLab1.setVisible(false);
							imgLab2.setVisible(true);
							Thread.sleep(1000);
							imgLab2.setVisible(false);
						}
		        	} catch (InterruptedException e) {
							e.printStackTrace();
					}
		        }
			}
        });
        trd.start();
	}
	
	public static void profileName() throws InterruptedException {
				
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		profilePanel.setBounds(890,3,200,40);
		mainFrame.add(profilePanel);
		
		File file1 = new File("resources\\img\\user.png");
		if(file1.exists() == false) {
			try {
				Effects.playErrorSound();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "user.png not found.\nYou can download from github.", "The File is Missing", JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon img1 = new ImageIcon("resources\\img\\user.png");
		Image scaledImage1 = img1.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imgLab1 = new JLabel(scaledIcon1);
        profilePanel.add(imgLab1);
		
		JLabel name = new JLabel(User.userName);
		Font font = new Font("Arial", Font.BOLD, 15);
		name.setFont(font);
		profilePanel.add(name);
	}
}
