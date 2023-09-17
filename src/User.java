import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class User{
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	JFrame frame = new JFrame("User Selection");
	JPanel contentPane = new JPanel();
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	JComboBox<String> userBox = new JComboBox<String>();
	JButton selectButton = new JButton("Select");
	JButton newUserButton = new JButton("New User");
	JTextField newUserName = new JTextField();
	
	Font titleFont = new Font("Arial", Font.BOLD, 20);

	TitledBorder title_1= new TitledBorder("Create a User");
	TitledBorder title_2= new TitledBorder("Select a User");
	
	static String userName;
	volatile boolean isAvailable = false;
	boolean isSelected = false;
	static String[] users = new String[100];
	
	public void userScreen() throws UnsupportedLookAndFeelException, IOException {
		
		Data d = new Data();
		
		readProfiles();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(620, 300, 680, 465);
		frame.setResizable(false);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		frame.add(contentPane);
		
		contentPane.add(panelUp);
		panelUp.setLayout(null);
		panelUp.setBorder(title_2);
		title_2.setTitleFont(titleFont);
		
		contentPane.add(panelDown);
		panelDown.setLayout(null);
		panelDown.setBorder(title_1);
		title_1.setTitleFont(titleFont);
		title_1.setTitlePosition(5);
		
		userBox.setBounds(110, 80, 260, 50);
		panelUp.add(userBox);
		for(int i=0; i<100; i++) {
			if(users[i] != null) {
				userBox.addItem(users[i]);
			}
		}
		userBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Effects.playButtonSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		selectButton.setBounds(380, 80, 150, 50);
		panelUp.add(selectButton);
		selectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(userBox.getSelectedItem() == null) {
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "First, create a user.", "Invalid Option", JOptionPane.ERROR_MESSAGE);
				}
				else {
					frame.setVisible(false);
					
					userName = (String) userBox.getSelectedItem();
					
					isSelected = true;
				}	
			}
		});
		
		newUserName.setBounds(110, 80, 260, 50);
		panelDown.add(newUserName);
		newUserName.setText("");
		
		newUserButton.setBounds(380, 80, 150, 50);
		panelDown.add(newUserButton);
		newUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(newUserName.getText().equals("") || newUserName.getText().startsWith(" ") || newUserName.getText().endsWith(" ")) {
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "The name is empty or invalid.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					boolean isSame = false;
					
					for(int i=0; i<100; i++) {
						if(newUserName.getText().equals(users[i])) {
							isSame = true;
							break;
						}
					}
					if(isSame == false) {
						try {
							frame.setVisible(false);
							
							userName = newUserName.getText();
							
							Path userPath = Paths.get("users\\" + userName);
							Files.createDirectories(userPath);
							
							File file = new File(userPath + "\\profile.acc");
							if(file.exists() == false) {
									file.createNewFile();
							}
							
							d.resetProfile();
							addProfile();
							isSelected = true;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else if(isSame == true) {
						try {
							Effects.playErrorSound();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "This name is already taken.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
        UIManager.setLookAndFeel( new FlatLightLaf() );
        SwingUtilities.updateComponentTreeUI(frame);
		frame.setVisible(true);
		
		while(!isAvailable) {
			if(isSelected == true) {
				isAvailable = true;
			}
		}
	}
	
	public void addProfile() throws IOException {
		
		File file = new File("users\\users.acc");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<100; i++) {
			if(users[i] == null) {
				users[i]= userName;
				break;
			}
		}
		
		for(int i=0; i<100; i++) {
			String line= users[i];
			if(users[i] != null) {
				bWrite.write(line + "\n");
			}
		}
		bWrite.close();
	}
	
	@SuppressWarnings("resource")
	public void readProfiles() throws IOException {
		
		Path userPath = Paths.get("users\\");
		Files.createDirectories(userPath);
		
		File file= new File("users\\users.acc");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<100; i++) {
			users[i] = bRead.readLine();
		}
	}
	
	public void deleteProfile() throws IOException {
		
		File file = new File("users\\users.acc");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<100; i++) {
			if(users[i] == userName) {
				users[i]= null;
				break;
			}
		}
		
		for(int i=0; i<100; i++) {
			String line= users[i];
			if(users[i] != null) {
				bWrite.write(line + "\n");
			}
		}
		bWrite.close();
		
		Path userPath = Paths.get("users\\" + userName);
		
		Files.walk(userPath).sorted(Comparator.reverseOrder()).forEach(path -> {
				try {
					Files.delete(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
            });
	}	
}