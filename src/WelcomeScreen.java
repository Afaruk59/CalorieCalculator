import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen {
	
	/**
	 * 
	 * @author Afaruk59
	 */
		
	public void welcomeFrame() throws InterruptedException, IOException {
				
		JFrame frame= new JFrame("Welcome to ACC v3.1.1");
		frame.setBounds(620, 300, 750, 500);
		frame.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel fotoPanel = new JPanel();
		fotoPanel.setBounds(10, 11, 714, 405);
		fotoPanel.setLayout(new BoxLayout(fotoPanel, BoxLayout.X_AXIS));
		contentPane.add(fotoPanel);
		
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
        }else {
        	imgLab1.setVisible(true);
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
