import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class gUI{
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	Data d= new Data();
	User u= new User();
	Body b = new Body();
	Language l = new Language();
	Ambients a = new Ambients();
	
	//MAIN FRAME
	static JFrame mainFrame= new JFrame("Afaruk59's Calorie Calculator v3.2.0");
	JPanel contentPane = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	//FONTS
	Font titleFont = new Font("Arial", Font.BOLD, 20);
	Font labelFont = new Font("Arial", Font.PLAIN, 13);
	Font tabFont = new Font("Arial", Font.PLAIN, 13);
	
	//BORDER TITLES
	TitledBorder title1= new TitledBorder("Diary");
	TitledBorder title2= new TitledBorder("Goals");
	TitledBorder title3= new TitledBorder("Today");
	TitledBorder title4= new TitledBorder("Past Week Macros");
	TitledBorder title5= new TitledBorder("Past Week Calories");
	TitledBorder title6= new TitledBorder("Add Food");
	TitledBorder title7= new TitledBorder("Add New Meal");
	TitledBorder title8= new TitledBorder("Added Meals & Favourites");
	TitledBorder title9= new TitledBorder("Set Goals");
	TitledBorder title10= new TitledBorder("Foods");
	TitledBorder title11= new TitledBorder("Body Fat Calculator");
	TitledBorder title12= new TitledBorder("BMI Calculator");
	TitledBorder title13= new TitledBorder("Calorie Calculator");
	TitledBorder title14= new TitledBorder("Body Stats");
	
    //SUMMARY PANELS
	JPanel summaryPage = new JPanel();
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	JPanel sPanel1 = new JPanel();
	static JPanel sPanel2 = new JPanel();
	JPanel sPanel3 = new JPanel();
	static JPanel sPanel4 = new JPanel();
	static JPanel sPanel5 = new JPanel();
	
	JLabel diaryProteinLbl = new JLabel();
	JLabel diaryCarbLbl = new JLabel();
	JLabel diaryFatLbl = new JLabel();
	JLabel diaryCalLbl = new JLabel();
	JLabel proteinValue = new JLabel();
	JLabel carbValue = new JLabel();
	JLabel fatValue = new JLabel();
	JLabel calValue = new JLabel();
	
	JLabel proGoalLbl = new JLabel();
	JLabel carbGoalLbl = new JLabel();
	JLabel fatGoalLbl = new JLabel();
	JLabel calGoalLbl = new JLabel();
	JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBar_1 = new JProgressBar();
	JProgressBar progressBar_2 = new JProgressBar();
	JProgressBar progressBar_3 = new JProgressBar();
	
	//FOOD PANEL
	JPanel foodPage = new JPanel();
	JPanel fPanelWest = new JPanel();
	JPanel fPanelUp = new JPanel();
	JComboBox<String> comboBox = new JComboBox<String>();
	SpinnerNumberModel model = new SpinnerNumberModel(1, 1, null, 1);
	JSpinner spinner = new JSpinner(model);
	JLabel amountLbl = new JLabel();
	JButton addBtn = new JButton();
	JButton resetAllFoodBtn = new JButton();
	
	JPanel fPanelDown = new JPanel();
	JLabel newNameLbl = new JLabel();
	JLabel newProLbl = new JLabel();
	JLabel newCarbLbl = new JLabel();
	JLabel newFatLbl = new JLabel();
	JLabel newCalLbl = new JLabel();
	JTextField textField = new JTextField();
	JTextField textField_1 = new JTextField();
	JTextField textField_2 = new JTextField();
	JTextField textField_3 = new JTextField();
	JTextField textField_4 = new JTextField();
	JButton addNewBtn = new JButton();
	JButton removeMealsBtn = new JButton();
	
	JTable table = new JTable(d.table_1, Language.tableTitles);
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	JPanel fPanelEast = new JPanel();
	JScrollPane fPanelUp_2 = new JScrollPane(table);
	
	JTable table_2 = new JTable(d.table_2, Language.tableTitles);
	JScrollPane fPanelDown_2 = new JScrollPane(table_2);
	JPopupMenu popMenu = new JPopupMenu();
    JMenuItem addFavItem = new JMenuItem();
    Object tableValue;
	
	//GOALS PANEL
	JPanel goalsPage = new JPanel();
	JPanel gPanelWest= new JPanel();
	JPanel gPanelEast= new JPanel();
	static JPanel chartPanel= new JPanel();
	JLabel setCalGoalLbl = new JLabel();
	JLabel setCarbGoalLbl = new JLabel();
	JLabel setFatGoalLbl = new JLabel();
	JLabel setProGoalLbl = new JLabel();
	JLabel calGoalTitleLbl = new JLabel();
	JLabel calGoalValueLbl = new JLabel();
	JTextField textField_5 = new JTextField();
	JTextField textField_6 = new JTextField();
	JTextField textField_7 = new JTextField();
	JTextField textField_8 = new JTextField();
	JButton setGoalBtn= new JButton();
	JButton resetGoalBtn= new JButton();
	
    //BODY PANEL
    JPanel bodyPage = new JPanel();
    
    JPanel bPanel_1 = new JPanel();
	JLabel lblWaist = new JLabel();
	JLabel lblGender = new JLabel();
	JLabel lblHip = new JLabel();
	JLabel lblHeight = new JLabel();
	JLabel lblNeck = new JLabel();
	JRadioButton maleRadio = new JRadioButton();
	JRadioButton femaleRadio = new JRadioButton();
	ButtonGroup bg_1 = new ButtonGroup();
	JTextField hipTF = new JTextField();
	JTextField heightTF = new JTextField();
	JTextField neckTF = new JTextField();
	JTextField waistTF = new JTextField();
	JButton bodyFatBtn = new JButton();
	JLabel lblBFResultTitle = new JLabel();
	JLabel bodyFatResult = new JLabel("% 0");
	JLabel bFResultType = new JLabel("Essential Fat");
	
	JPanel bPanel_2 = new JPanel();
	JLabel lblWeight_2 = new JLabel();
	JLabel lblHeight_2 = new JLabel();
	JTextField weightTF_2 = new JTextField();
	JTextField heightTF_2 = new JTextField();
	JButton bmiBtn = new JButton();
	JLabel lblBmiResultTitle = new JLabel();
	JLabel bmiResult = new JLabel("% 0");
	JLabel bmiResultType = new JLabel("Severe Thinness");
	
    JPanel bPanel_3 = new JPanel();
	JLabel lblGender_3 = new JLabel();
	JLabel lblAge_3 = new JLabel();
	JLabel lblWeight_3 = new JLabel();
	JLabel lblHeight_3 = new JLabel();
	JLabel lblActivitiy = new JLabel();
	JRadioButton maleRadio_3 = new JRadioButton();
	JRadioButton femaleRadio_3 = new JRadioButton();
	ButtonGroup bg_3 = new ButtonGroup();
	JTextField ageTF_3 = new JTextField();
	JTextField weightTF_3 = new JTextField();
	JTextField heightTF_3 = new JTextField();
	String[] activity = {"BMR (Basal Metabolic Rate)" , "Sedentary", "Moderate" , "Active"};
	JComboBox<String> activityBox = new JComboBox<String>(activity);
	JButton calBtn = new JButton();
	JLabel calResultTitle = new JLabel();
	JLabel calResult = new JLabel("0 Calories/Day");
	JLabel calResultType = new JLabel("Maintain Weight");
	
	//SETTINGS PANEL
	JPanel settingsPage = new JPanel();
	JLabel themeTitleLbl= new JLabel();
	JComboBox<String> themeComboBox= new JComboBox<String>();
	JCheckBox welcomeScrenCb= new JCheckBox();
	JButton resetProfileBtn = new  JButton();
    JLabel gitPageTitleLbl= new JLabel();
    JButton gitPageBtn = new JButton("Afaruk59/CalorieCalculator");
    JButton deleteProfileBtn = new JButton();
    JLabel langSettingLbl = new JLabel();
    JComboBox<String> langComboBox= new JComboBox<String>();
	JLabel soundLbl = new JLabel("Ambients:");
	JComboBox<String> soundBox = new JComboBox<String>();
	JButton verBtn = new JButton();
	
	public void gui() throws IOException {
				
		//READ SAVED DATA
		d.loadProfile();
		d.readFoods();
		d.readDefaultFoods();
		d.writeTable1();
		d.writeTable2();
		
		Charts c = new Charts();
				
		//CONTENT PANE
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		mainFrame.setContentPane(contentPane);
		
		//TABBED PANE
		contentPane.add(tabbedPane);
//---------------------------------------------------------------------------------------------		
		//SUMMARY PANE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			tabbedPane.addTab("Summary", null, summaryPage, null);
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			tabbedPane.addTab("Özet", null, summaryPage, null);
		}
		tabbedPane.setFont(tabFont);
		
		summaryPage.setLayout(new BoxLayout(summaryPage, BoxLayout.Y_AXIS));
		summaryPage.setBorder(new EmptyBorder(10,10,10,10));
		
		panelUp.setLayout(new BoxLayout(panelUp, BoxLayout.X_AXIS));
		summaryPage.add(panelUp);
		
		panelDown.setLayout(new BoxLayout(panelDown, BoxLayout.X_AXIS));
		summaryPage.add(panelDown);
		
		sPanel1.setPreferredSize(new Dimension(250,341));
		panelUp.add(sPanel1);
		sPanel1.setLayout(null);
		sPanel1.setBorder(title1);
		title1.setTitleFont(titleFont);
		
		sPanel3.setPreferredSize(new Dimension(400,341));
		panelUp.add(sPanel3);
		sPanel3.setLayout(null);
		sPanel3.setBorder(title2);
		title2.setTitleFont(titleFont);
		
		sPanel2.setPreferredSize(new Dimension(402,341));
		panelUp.add(sPanel2);
		sPanel2.setLayout(new BoxLayout(sPanel2, BoxLayout.X_AXIS));
		sPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		sPanel2.setBorder(title3);
		title3.setTitleFont(titleFont);
		
		sPanel4.setPreferredSize(new Dimension(653,341));
		panelDown.add(sPanel4);
		sPanel4.setLayout(new BoxLayout(sPanel4, BoxLayout.X_AXIS));
		sPanel4.setBorder(title4);
		title4.setTitleFont(titleFont);
		title4.setTitlePosition(5);
		
		sPanel5.setPreferredSize(new Dimension(653,341));
		panelDown.add(sPanel5);
		sPanel5.setLayout(new BoxLayout(sPanel5, BoxLayout.X_AXIS));
		sPanel5.setBorder(title5);
		title5.setTitleFont(titleFont);
		title5.setTitlePosition(5);
		
		diaryProteinLbl.setBounds(32, 106, 100, 30);
		sPanel1.add(diaryProteinLbl);
		diaryProteinLbl.setFont(labelFont);
		
		diaryCarbLbl.setBounds(32, 148, 100, 30);
		sPanel1.add(diaryCarbLbl);
		diaryCarbLbl.setFont(labelFont);
		
		diaryFatLbl.setBounds(32, 190, 100, 30);
		sPanel1.add(diaryFatLbl);
		diaryFatLbl.setFont(labelFont);
		
		diaryCalLbl.setBounds(32, 232, 100, 30);
		sPanel1.add(diaryCalLbl);
		diaryCalLbl.setFont(labelFont);
		
		proteinValue.setHorizontalAlignment(SwingConstants.CENTER);
		proteinValue.setBounds(171, 106, 100, 30);
		sPanel1.add(proteinValue);
		proteinValue.setText(d.today[0]);
		proteinValue.setFont(labelFont);
		
		carbValue.setHorizontalAlignment(SwingConstants.CENTER);
		carbValue.setBounds(171, 148, 100, 30);
		sPanel1.add(carbValue);
		carbValue.setText(d.today[1]);
		carbValue.setFont(labelFont);
		
		fatValue.setHorizontalAlignment(SwingConstants.CENTER);
		fatValue.setBounds(171, 190, 100, 30);
		sPanel1.add(fatValue);
		fatValue.setText(d.today[2]);
		fatValue.setFont(labelFont);
		
		calValue.setHorizontalAlignment(SwingConstants.CENTER);
		calValue.setBounds(171, 232, 100, 30);
		sPanel1.add(calValue);
		calValue.setText(d.today[3]);
		calValue.setFont(labelFont);
		
		proGoalLbl.setBounds(46, 41, 70, 15);
		sPanel3.add(proGoalLbl);
		proGoalLbl.setFont(labelFont);
		
		carbGoalLbl.setBounds(46, 110, 70, 15);
		sPanel3.add(carbGoalLbl);
		carbGoalLbl.setFont(labelFont);
		
		fatGoalLbl.setBounds(46, 179, 70, 15);
		sPanel3.add(fatGoalLbl);
		fatGoalLbl.setFont(labelFont);
		
		calGoalLbl.setBounds(46, 248, 70, 15);
		sPanel3.add(calGoalLbl);
		calGoalLbl.setFont(labelFont);
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(46, 62, 318, 30);
		sPanel3.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(Integer.parseInt(d.goals[1]));
		progressBar.setValue((int) Double.parseDouble(d.today[0]));
		progressBar.setFont(labelFont);
		
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(46, 132, 318, 30);
		sPanel3.add(progressBar_1);
		progressBar_1.setMinimum(0);
		progressBar_1.setMaximum(Integer.parseInt(d.goals[2]));
		progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
		progressBar_1.setFont(labelFont);
		
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(46, 201, 318, 30);
		sPanel3.add(progressBar_2);
		progressBar_2.setMinimum(0);
		progressBar_2.setMaximum(Integer.parseInt(d.goals[3]));
		progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
		progressBar_2.setFont(labelFont);
		
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(46, 270, 318, 30);
		sPanel3.add(progressBar_3);
		progressBar_3.setMinimum(0);
		progressBar_3.setMaximum(Integer.parseInt(d.goals[0]));
		progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
		progressBar_3.setFont(labelFont);
//---------------------------------------------------------------------------------------------		
		//FOOD PANE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			tabbedPane.addTab("Food", null, foodPage, null);
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			tabbedPane.addTab("Yiyecek", null, foodPage, null);
		}
		foodPage.setLayout(new BoxLayout(foodPage , BoxLayout.X_AXIS));
		foodPage.setBorder(new EmptyBorder(10,10,10,10));
		
		//WEST SIDE
		fPanelWest.setLayout(new BoxLayout(fPanelWest , BoxLayout.Y_AXIS));
		foodPage.add(fPanelWest);
		fPanelWest.setPreferredSize(new Dimension(400,500));
		
		//UP SIDE
		fPanelUp.setBorder(BorderFactory.createTitledBorder(title6));
		title6.setTitleFont(titleFont);
		fPanelUp.setLayout(null);
		fPanelWest.add(fPanelUp);
		
		comboBox.setBounds(122, 65, 281, 35);
		for(int i=0; i<100; i++) {
			if(d.name[i] != null) {
				comboBox.addItem(d.name[i]);
			}
		}
		fPanelUp.add(comboBox);
		
		spinner.setBounds(246, 130, 156, 20);
		fPanelUp.add(spinner);
		
		amountLbl.setBounds(123, 109, 177, 60);
		fPanelUp.add(amountLbl);
		amountLbl.setFont(labelFont);
		
		//ADD FOOD BUTTON
		addBtn.setBounds(246, 180, 156, 34);
		fPanelUp.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				if(comboBox.getSelectedItem() == null) {
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(mainFrame, "Please add a meal or add to Favourites a food.", "Invalid Food", JOptionPane.ERROR_MESSAGE);
				}
				else {
					double pro,carb,fat,cal;
					
					pro= Double.parseDouble(proteinValue.getText());
					carb= Double.parseDouble(carbValue.getText());
					fat= Double.parseDouble(fatValue.getText());
					cal= Double.parseDouble(calValue.getText());
							
					for(int i=0; i<100; i++) {
						if(comboBox.getSelectedItem() == d.addedMeals[i]) {
									
							pro += (Double.parseDouble(d.addedMeals[i+1]) * (int) spinner.getValue());
							carb += (Double.parseDouble(d.addedMeals[i+2]) * (int) spinner.getValue());
							fat += (Double.parseDouble(d.addedMeals[i+3]) * (int) spinner.getValue());
							cal += (Double.parseDouble(d.addedMeals[i+4]) * (int) spinner.getValue());
							break;
						}
					}
							
					proteinValue.setText(Double.toString(pro));
					carbValue.setText(Double.toString(carb));
					fatValue.setText(Double.toString(fat));
					calValue.setText(Double.toString(cal));
					
					sPanel2.removeAll();
					
					try {
						d.writeToday(proteinValue.getText(), carbValue.getText(), fatValue.getText(), calValue.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					c.pieChart(proteinValue.getText(), carbValue.getText(), fatValue.getText());
					
					progressBar.setValue((int) Double.parseDouble(d.today[0]));
					progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
					progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
					progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
					
					try {
						Effects.playMessageSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(mainFrame, "The food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		
		//RESET BUTTON
		resetAllFoodBtn.setBounds(122, 235, 280, 34);
		fPanelUp.add(resetAllFoodBtn);
		resetAllFoodBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				proteinValue.setText("0");
				carbValue.setText("0");
				fatValue.setText("0");
				calValue.setText("0");
				
				progressBar.setValue(0);
				progressBar_1.setValue(0);
				progressBar_2.setValue(0);
				progressBar_3.setValue(0);
				
				sPanel2.removeAll();
				
				try {
					d.writeToday("0", "0", "0", "0");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				c.pieChart("0", "0", "0");
				
				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(mainFrame, "All meals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//DOWN SIDE
		fPanelDown.setBorder(BorderFactory.createTitledBorder(title7));
		title7.setTitleFont(titleFont);
		title7.setTitlePosition(5);
		fPanelWest.add(fPanelDown);
		fPanelDown.setLayout(null);
		
		newNameLbl.setBounds(120, 46, 120, 20);
		fPanelDown.add(newNameLbl);
		newNameLbl.setFont(labelFont);
		
		newProLbl.setBounds(120, 77, 120, 20);
		fPanelDown.add(newProLbl);
		newProLbl.setFont(labelFont);
		
		newCarbLbl.setBounds(120, 108, 120, 20);
		fPanelDown.add(newCarbLbl);
		newCarbLbl.setFont(labelFont);
		
		newFatLbl.setBounds(120, 139, 120, 20);
		fPanelDown.add(newFatLbl);
		newFatLbl.setFont(labelFont);
		
		newCalLbl.setBounds(120, 170, 120, 20);
		fPanelDown.add(newCalLbl);
		newCalLbl.setFont(labelFont);
		
		//NEW FOOD NAME
		textField.setBounds(275, 45, 125, 25);
		fPanelDown.add(textField);
		textField.setText(null);
		
		//NEW FOOD PROTEIN
		textField_1.setBounds(275, 76, 125, 25);
		textField_1.setText("0");
		fPanelDown.add(textField_1);
		textField_1.setColumns(10);
		
		//NEW FOOD CARB
		textField_2.setBounds(275, 107, 125, 25);
		textField_2.setText("0");
		fPanelDown.add(textField_2);
		textField_2.setColumns(10);
		
		//NEW FOOD FAT
		textField_3.setBounds(275, 138, 125, 25);
		textField_3.setText("0");
		fPanelDown.add(textField_3);
		textField_3.setColumns(10);
		
		//NEW FOOD CALORIE
		textField_4.setBounds(275, 169, 125, 25);
		textField_4.setText("0");
		fPanelDown.add(textField_4);
		textField_4.setColumns(10);
		
		//ADD NEW BUTTON
		addNewBtn.setBounds(274, 210, 125, 34);
		fPanelDown.add(addNewBtn);
		addNewBtn.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty() || textField.getText().startsWith(" ") || textField.getText().endsWith(" ")) {
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(mainFrame, "New meals name is empty or invalid.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						String newName= textField.getText();
						String newProtein= textField_1.getText();
						String newCarb= textField_2.getText();
						String newFat= textField_3.getText();
						String newCal= textField_4.getText();
								
						d.addFood(newName, newProtein, newCarb, newFat, newCal);
						comboBox.addItem(newName);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					d.writeTable1();
					foodPage.remove(fPanelEast);
					foodPage.add(fPanelEast);
					
					try {
						Effects.playMessageSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(mainFrame, "The new meal has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}); 
		
		//REMOVE ALL BUTTON
		removeMealsBtn.setBounds(120, 260, 279, 34);
		fPanelDown.add(removeMealsBtn);
		removeMealsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				for(int i=0; i<1000; i++) {
					d.addedMeals[i] = null;
				}
				for(int i=0; i<100; i++) {
					d.name[i] = null;
				}
				try {
					d.removeFoods();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				for(int i=0; i<100; i++) {
					for(int j=0; j<5; j++) {
						d.table_1[i][j]= null;
					}
				}
				foodPage.remove(fPanelEast);
				foodPage.add(fPanelEast);
				
				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(mainFrame, "All saved meals have been removed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//EAST SIDE
		foodPage.add(fPanelEast);
		fPanelEast.setLayout(new BoxLayout(fPanelEast, BoxLayout.Y_AXIS));
		
		fPanelEast.add(fPanelUp_2);
		fPanelUp_2.setBorder(BorderFactory.createTitledBorder(title8));
		title8.setTitleFont(titleFont);
		
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table.setEnabled(false);
        
		fPanelEast.add(fPanelDown_2);
		fPanelDown_2.setBorder(BorderFactory.createTitledBorder(title10));
		title10.setTitleFont(titleFont);
		title10.setTitlePosition(5);
		
        table_2.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table_2.setEnabled(false);
        
        popMenu.add(addFavItem);        
        addFavItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tableValue != null) {
					try {
						d.addFavFood(tableValue.toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					comboBox.addItem(tableValue.toString());
					
					d.writeTable1();
					foodPage.remove(fPanelEast);
					foodPage.add(fPanelEast);
				}
				else if(tableValue == null) {
					try {
						Effects.playErrorSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "Food name is null.", "Invalid Food", JOptionPane.ERROR_MESSAGE);
				}
			}
        });
        
        table_2.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                	
                    int row = table_2.rowAtPoint(e.getPoint());
                    int column = table_2.columnAtPoint(e.getPoint());
                    
                    tableValue = table_2.getValueAt(row, column);
                    
                    if(column == 0) {
                    	popMenu.show(table_2, e.getX(), e.getY());
                    }
                }
            }
        });
//---------------------------------------------------------------------------------------------
		//GOALS PANE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			tabbedPane.addTab("Goals", null, goalsPage, null);
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			tabbedPane.addTab("Hedefler", null, goalsPage, null);
		}
		goalsPage.setLayout(new BoxLayout(goalsPage, BoxLayout.X_AXIS));
		goalsPage.setBorder(new EmptyBorder(10,10,10,10));
		
		//WEST SIDE
		gPanelWest.setPreferredSize(new Dimension(925,341));
		gPanelWest.setBorder(BorderFactory.createTitledBorder(title9));
		title9.setTitleFont(titleFont);
		gPanelWest.setLayout(null);
		goalsPage.add(gPanelWest);
		
		setCalGoalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		setCalGoalLbl.setBounds(125, 199, 89, 20);
		gPanelWest.add(setCalGoalLbl);
		setCalGoalLbl.setFont(labelFont);
		
		setCarbGoalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		setCarbGoalLbl.setBounds(125, 263, 89, 20);
		gPanelWest.add(setCarbGoalLbl);
		setCarbGoalLbl.setFont(labelFont);
		
		setFatGoalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		setFatGoalLbl.setBounds(125, 295, 89, 20);
		gPanelWest.add(setFatGoalLbl);
		setFatGoalLbl.setFont(labelFont);
		
		setProGoalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		setProGoalLbl.setBounds(125, 230, 89, 20);
		gPanelWest.add(setProGoalLbl);
		setProGoalLbl.setFont(labelFont);
		
		calGoalTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		calGoalTitleLbl.setBounds(130, 530, 100, 50);
		gPanelWest.add(calGoalTitleLbl);
		calGoalTitleLbl.setFont(new Font("Arial" , Font.BOLD , 25));
		
		calGoalValueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		calGoalValueLbl.setBounds(280, 530, 100, 50);
		gPanelWest.add(calGoalValueLbl);
		calGoalValueLbl.setFont(new Font("Arial" , Font.BOLD , 25));
		calGoalValueLbl.setText(d.goals[0]);
		
		textField_5.setBounds(240, 196, 140, 25);
		textField_5.setText("0");
		gPanelWest.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6.setBounds(240, 227, 140, 25);
		textField_6.setText("0");
		gPanelWest.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7.setBounds(240, 260, 140, 25);
		textField_7.setText("0");
		gPanelWest.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8.setBounds(240, 292, 140, 25);
		textField_8.setText("0");
		gPanelWest.add(textField_8);
		textField_8.setColumns(10);
		
		setGoalBtn.setBounds(240,330,139,34);
		gPanelWest.add(setGoalBtn);
		setGoalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int calgoal, progoal, carbgoal, fatgoal;
				
				calgoal= Integer.parseInt(textField_5.getText());
				progoal= Integer.parseInt(textField_6.getText());
				carbgoal= Integer.parseInt(textField_7.getText());
				fatgoal= Integer.parseInt(textField_8.getText());
				
				chartPanel.removeAll();
				
				try {
					d.writeGoals(Integer.toString(calgoal), Integer.toString(progoal), Integer.toString(carbgoal), Integer.toString(fatgoal));
					c.gPieChart(d.goals[1], d.goals[2], d.goals[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					d.loadProfile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				progressBar.setMaximum(Integer.parseInt(d.goals[1]));
				progressBar_1.setMaximum(Integer.parseInt(d.goals[2]));
				progressBar_2.setMaximum(Integer.parseInt(d.goals[3]));
				progressBar_3.setMaximum(Integer.parseInt(d.goals[0]));
				
				progressBar.setValue((int) Double.parseDouble(d.today[0]));
				progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
				progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
				progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
				
				calGoalValueLbl.setText(d.goals[0]);
				
				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(mainFrame, "Goals have been set.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		resetGoalBtn.setBounds(124,377,255,34);
		gPanelWest.add(resetGoalBtn);
		resetGoalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				progressBar.setMaximum(0);
				progressBar_1.setMaximum(0);
				progressBar_2.setMaximum(0);
				progressBar_3.setMaximum(0);
				
				chartPanel.removeAll();
				
				try {
					d.writeGoals("0", "0", "0", "0");
					c.gPieChart(d.goals[1], d.goals[2], d.goals[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				calGoalValueLbl.setText(d.goals[0]);
				
				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(mainFrame, "Goals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		//EAST SIDE
		goalsPage.add(gPanelEast);
		gPanelEast.setLayout(null);
		gPanelEast.setBorder(BorderFactory.createTitledBorder(title2));
		gPanelEast.setPreferredSize(new Dimension(1047,341));
		
		chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
		chartPanel.setBounds(45,110,500,450);
		gPanelEast.add(chartPanel);
		
//---------------------------------------------------------------------------------------------
		//BODY PANE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			tabbedPane.addTab("Body", null, bodyPage, null);
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			tabbedPane.addTab("Vücut", null, bodyPage, null);
		}
		bodyPage.setLayout(new BoxLayout(bodyPage, BoxLayout.X_AXIS));
		bodyPage.setBorder(new EmptyBorder(10,10,10,10));
		
		//BODY FAT
		bodyPage.add(bPanel_1);
		bPanel_1.setBorder(title11);
		title11.setTitleFont(titleFont);
		bPanel_1.setLayout(null);
		
		lblWaist.setBounds(75, 334, 100, 30);
		bPanel_1.add(lblWaist);
		lblWaist.setFont(labelFont);
		
		lblGender.setBounds(75, 170, 100, 30);
		bPanel_1.add(lblGender);
		lblGender.setFont(labelFont);
		
		lblHip.setBounds(75, 211, 100, 30);
		bPanel_1.add(lblHip);
		lblHip.setFont(labelFont);
		
		lblHeight.setBounds(75, 252, 100, 30);
		bPanel_1.add(lblHeight);
		lblHeight.setFont(labelFont);
		
		lblNeck.setBounds(75, 293, 100, 30);
		bPanel_1.add(lblNeck);
		lblNeck.setFont(labelFont);
		
		maleRadio.setBounds(160, 174, 70, 23);
		bPanel_1.add(maleRadio);
		maleRadio.setFont(labelFont);
				
		femaleRadio.setBounds(216, 174, 70, 23);
		bPanel_1.add(femaleRadio);
		femaleRadio.setFont(labelFont);
		
		bg_1.add(maleRadio);
		bg_1.add(femaleRadio);
		
		hipTF.setBounds(156, 216, 130, 25);
		bPanel_1.add(hipTF);
		hipTF.setColumns(10);
		hipTF.setText(null);
		
		heightTF.setColumns(10);
		heightTF.setBounds(156, 257, 130, 25);
		bPanel_1.add(heightTF);
		heightTF.setText(null);
		
		neckTF.setColumns(10);
		neckTF.setBounds(156, 298, 130, 25);
		bPanel_1.add(neckTF);
		neckTF.setText(null);
		
		waistTF.setColumns(10);
		waistTF.setBounds(156, 337, 130, 25);
		bPanel_1.add(waistTF);
		waistTF.setText(null);
		
		bodyFatBtn.setBounds(156, 380, 130, 30);
		bPanel_1.add(bodyFatBtn);
		bodyFatBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				b.bodyFatCalc(maleRadio.isSelected(), femaleRadio.isSelected(), hipTF.getText(),
						heightTF.getText(), neckTF.getText(), waistTF.getText());
				
				String result = Body.bodyFat_;
				
				if(Body.bodyFat_.equals("0") == false) {
					bodyFatResult.setText("% " + result);
				}
				
				if(maleRadio.isSelected() == true && Body.bodyFat_.equals("0") == false) {
					if(Double.parseDouble(result) <= 5) {
						bFResultType.setText("Essential Fat");
					}
					if(Double.parseDouble(result) > 5 && Double.parseDouble(result) <= 13) {
						bFResultType.setText("Athletes");
					}
					if(Double.parseDouble(result) > 13 && Double.parseDouble(result) <= 17) {
						bFResultType.setText("Fitness");
					}
					if(Double.parseDouble(result) > 17 && Double.parseDouble(result) <= 24) {
						bFResultType.setText("Average");
					}
					if(Double.parseDouble(result) > 24) {
						bFResultType.setText("Obese");
					}
				}
				
				if(femaleRadio.isSelected() == true && Body.bodyFat_.equals("0") == false) {
					if(Double.parseDouble(result) <= 13) {
						bFResultType.setText("Essential Fat");
					}
					if(Double.parseDouble(result) > 13 && Double.parseDouble(result) <= 20) {
						bFResultType.setText("Athletes");
					}
					if(Double.parseDouble(result) > 20 && Double.parseDouble(result) <= 24) {
						bFResultType.setText("Fitness");
					}
					if(Double.parseDouble(result) > 24 && Double.parseDouble(result) <= 31) {
						bFResultType.setText("Average");
					}
					if(Double.parseDouble(result) > 31) {
						bFResultType.setText("Obese");
					}
				}
				
				if(Body.bodyFat_.equals("0") == false) {
					
					try {
						d.writeBodyFatResult(result);
						d.writeBodyFatResultType(bFResultType.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		lblBFResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBFResultTitle.setBounds(55, 451, 251, 30);
		bPanel_1.add(lblBFResultTitle);
		lblBFResultTitle.setFont(titleFont);
		
		bodyFatResult.setHorizontalAlignment(SwingConstants.CENTER);
		bodyFatResult.setBounds(75, 492, 211, 30);
		bPanel_1.add(bodyFatResult);
		bodyFatResult.setFont(labelFont);
		bodyFatResult.setText("% " + d.readBodyFatResult());
		
		bFResultType.setHorizontalAlignment(SwingConstants.CENTER);
		bFResultType.setBounds(75, 533, 211, 30);
		bPanel_1.add(bFResultType);
		bFResultType.setFont(labelFont);
		bFResultType.setText(d.readBodyFatResultType());
		
		//BMI
		bodyPage.add(bPanel_2);
		bPanel_2.setBorder(title12);
		title12.setTitleFont(titleFont);
		bPanel_2.setLayout(null);
		
		lblWeight_2.setBounds(75, 262, 100, 30);
		bPanel_2.add(lblWeight_2);
		lblWeight_2.setFont(labelFont);
		
		lblHeight_2.setBounds(75, 303, 100, 30);
		bPanel_2.add(lblHeight_2);
		lblHeight_2.setFont(labelFont);
		
		weightTF_2.setBounds(156, 267, 130, 25);
		bPanel_2.add(weightTF_2);
		weightTF_2.setColumns(10);	
		
		heightTF_2.setColumns(10);
		heightTF_2.setBounds(156, 308, 130, 25);
		bPanel_2.add(heightTF_2);	
		
		bmiBtn.setBounds(156, 350, 130, 30);
		bPanel_2.add(bmiBtn);
		bmiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				b.bmiCalc(weightTF_2.getText(), heightTF_2.getText());
				
				String result = Body.bmi_;
				
				if(Body.bmi_.equals("0") == false) {
					bmiResult.setText("% " + result);
				}
				
				if(Body.bmi_.equals("0") == false) {
					if(Double.parseDouble(result) <= 16) {
						bmiResultType.setText("Severe Thinness");
					}
					if(Double.parseDouble(result) > 16 && Double.parseDouble(result) <= 17) {
						bmiResultType.setText("Moderate Thinness");
					}
					if(Double.parseDouble(result) > 17 && Double.parseDouble(result) <= 18.5) {
						bmiResultType.setText("Mild Thinnes");
					}
					if(Double.parseDouble(result) > 18.5 && Double.parseDouble(result) <= 25) {
						bmiResultType.setText("Normal");
					}
					if(Double.parseDouble(result) > 25 && Double.parseDouble(result) <= 30) {
						bmiResultType.setText("Overweight");
					}
					if(Double.parseDouble(result) > 30) {
						bmiResultType.setText("Obese");
					}
				}
				
				if(Body.bmi_.equals("0") == false) {
					
					try {
						d.writeBmiResult(result);
						d.writeBmiResultType(bmiResultType.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
			
		lblBmiResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBmiResultTitle.setBounds(55, 451, 251, 30);
		bPanel_2.add(lblBmiResultTitle);
		lblBmiResultTitle.setFont(titleFont);
			
		bmiResult.setHorizontalAlignment(SwingConstants.CENTER);
		bmiResult.setBounds(75, 492, 211, 30);
		bPanel_2.add(bmiResult);
		bmiResult.setFont(labelFont);
		bmiResult.setText("% " + d.readBmiResult());
			
		bmiResultType.setHorizontalAlignment(SwingConstants.CENTER);
		bmiResultType.setBounds(75, 533, 211, 30);
		bPanel_2.add(bmiResultType);
		bmiResultType.setFont(labelFont);
		bmiResultType.setText(d.readBmiResultType());
		
		//CALORIE
		bodyPage.add(bPanel_3);
		bPanel_3.setBorder(title13);
		title13.setTitleFont(titleFont);
		bPanel_3.setLayout(null);
		
		lblGender_3.setBounds(75, 150, 100, 30);
		bPanel_3.add(lblGender_3);
		lblGender_3.setFont(labelFont);
				
		lblAge_3.setBounds(75, 191, 100, 30);
		bPanel_3.add(lblAge_3);
		lblAge_3.setFont(labelFont);
				
		lblWeight_3.setBounds(75, 232, 100, 30);
		bPanel_3.add(lblWeight_3);
		lblWeight_3.setFont(labelFont);
				
		lblHeight_3.setBounds(75, 273, 100, 30);
		bPanel_3.add(lblHeight_3);
		lblHeight_3.setFont(labelFont);
				
		lblActivitiy.setBounds(76, 309, 100, 30);
		bPanel_3.add(lblActivitiy);
		lblActivitiy.setFont(labelFont);
				
		maleRadio_3.setBounds(160, 154, 70, 23);
		bPanel_3.add(maleRadio_3);
		maleRadio_3.setFont(labelFont);
				
		femaleRadio_3.setBounds(216, 154, 70, 23);
		bPanel_3.add(femaleRadio_3);
		femaleRadio_3.setFont(labelFont);
		
		bg_3.add(maleRadio_3);
		bg_3.add(femaleRadio_3);
				
		ageTF_3.setBounds(160, 194, 130, 25);
		bPanel_3.add(ageTF_3);
		ageTF_3.setColumns(10);
				
		weightTF_3.setBounds(160, 235, 130, 25);
		bPanel_3.add(weightTF_3);
		weightTF_3.setColumns(10);
				
		heightTF_3.setColumns(10);
		heightTF_3.setBounds(160, 276, 130, 25);
		bPanel_3.add(heightTF_3);
				
		activityBox.setToolTipText("");
		activityBox.setBounds(75, 345, 215, 30);
		bPanel_3.add(activityBox);
				
		calBtn.setBounds(160, 391, 130, 30);
		bPanel_3.add(calBtn);
		calBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				b.calorieCalc(maleRadio_3.isSelected(), femaleRadio_3.isSelected(), ageTF_3.getText(), weightTF_3.getText(),
						heightTF_3.getText(), activityBox.getSelectedIndex());
				
				if(Body.calorie.equals("0") == false) {
					
					calResult.setText(Body.calorie + " Calories/Day");
					
					try {
						d.writeCalorieResult(Body.calorie);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
				
		calResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		calResultTitle.setBounds(55, 451, 251, 30);
		bPanel_3.add(calResultTitle);
		calResultTitle.setFont(titleFont);
				
		calResult.setHorizontalAlignment(SwingConstants.LEFT);
		calResult.setBounds(70, 492, 300, 30);
		bPanel_3.add(calResult);
		calResult.setFont(labelFont);
		calResult.setText(d.readCalorieResult() + " Calories/Day");
				
		calResultType.setHorizontalAlignment(SwingConstants.CENTER);
		calResultType.setBounds(185, 492, 120, 30);
		bPanel_3.add(calResultType);
		calResultType.setFont(labelFont);
		
//---------------------------------------------------------------------------------------------
		//SETTINGS PANE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			tabbedPane.addTab("Settings", null, settingsPage, null);
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			tabbedPane.addTab("Ayarlar", null, settingsPage, null);
		}
		settingsPage.setLayout(null);
		settingsPage.setBorder(new EmptyBorder(10,10,10,10));
		
		themeTitleLbl.setBounds(40,30,150,30);
		settingsPage.add(themeTitleLbl);
		themeTitleLbl.setFont(labelFont);

		themeComboBox.addItem("Light");
		themeComboBox.addItem("Dark");
		themeComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(themeComboBox.getSelectedIndex()==0) {
					try {
			            UIManager.setLookAndFeel( new FlatLightLaf() );
			            SwingUtilities.updateComponentTreeUI(mainFrame);
			            SwingUtilities.updateComponentTreeUI(popMenu);
			            d.writeThemeSetting(0);
			        } catch( Exception ex ) {
			            System.err.println( "Failed to initialize LaF" );
			        }
				}
				else if(themeComboBox.getSelectedIndex()==1) {
					try {
			            UIManager.setLookAndFeel( new FlatDarkLaf() );
			            SwingUtilities.updateComponentTreeUI(mainFrame);
			            SwingUtilities.updateComponentTreeUI(popMenu);
			            d.writeThemeSetting(1);
			        } catch( Exception ex ) {
			            System.err.println( "Failed to initialize LaF" );
			        }
				}
			}
        });
		themeComboBox.setBounds(40,70,300,30);
        settingsPage.add(themeComboBox);
        themeComboBox.setSelectedIndex(d.readThemeSetting());
        
        welcomeScrenCb.setBounds(40,120,500,30);
        welcomeScrenCb.setBackground(null);
        settingsPage.add(welcomeScrenCb);
        welcomeScrenCb.setFont(tabFont);
        int set= d.readWSetting();
        if(set==1) {
        	welcomeScrenCb.setSelected(true);
        }
        welcomeScrenCb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(welcomeScrenCb.isSelected()) {
					try {
						d.writeWSetting(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
					try {
						d.writeWSetting(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
        });
        
        resetProfileBtn.setBounds(40,170,300,30);
        settingsPage.add(resetProfileBtn);
		resetProfileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure?", "Reset Profile", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						d.resetProfile();
						d.removeFoods();
						try {
							Effects.playMessageSound();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(mainFrame, "Profile has been reset.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
        });
        
		gitPageTitleLbl.setBounds(371,30,150,30);
		gitPageTitleLbl.setFont(labelFont);
        settingsPage.add(gitPageTitleLbl);
		SwingUtilities.updateComponentTreeUI(gitPageTitleLbl);
        
		gitPageBtn.setBounds(370,70,300,30);
        settingsPage.add(gitPageBtn);
		gitPageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Effects.playButtonSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				
				try {
					URI url = new URI("https://github.com/Afaruk59/CalorieCalculator");
					java.awt.Desktop.getDesktop().browse(url);
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
				}
			}
        });
        
		deleteProfileBtn.setBounds(40,230,300,30);
        settingsPage.add(deleteProfileBtn);
		deleteProfileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Effects.playMessageSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
				int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure?", "Delete Profile", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						DateAndTime.run = false;
						u.deleteProfile();
						try {
							Effects.playMessageSound();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(mainFrame, "Profile removed.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
        });
		
		langSettingLbl.setBounds(41,290,300,30);
		settingsPage.add(langSettingLbl);
		
		langComboBox.setBounds(120,290,220,30);
		langComboBox.addItem("English");
		langComboBox.addItem("Türkçe");
		settingsPage.add(langComboBox);
		langComboBox.setSelectedIndex(d.readLangSetting());
		langComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Language l = new Language();
				
				if(langComboBox.getSelectedIndex()==0) {
					try {
						l.english();
						d.writeLangSetting("eng");
						langTranslator();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if(langComboBox.getSelectedIndex()==1) {
					try {
						l.turkish();
						d.writeLangSetting("tr");
						langTranslator();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
        });
		
		soundLbl.setBounds(41,350,300,30);
		settingsPage.add(soundLbl);
		
		soundBox.setBounds(120,350,220,30);
		soundBox.addItem("On");
		soundBox.addItem("Off");
		settingsPage.add(soundBox);
		soundBox.setSelectedIndex(d.readAmbSetting());
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				
				if(soundBox.getSelectedIndex() == 0) {
					try {
						Thread.sleep(10000);
						a.musicStarter();
					} catch (UnsupportedAudioFileException | LineUnavailableException | InterruptedException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		t.start();
		soundBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(soundBox.getSelectedIndex() == 0) {
					try {
						d.writeAmbSetting("0");
						a.musicStarter();
					} catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				else if(soundBox.getSelectedIndex() == 1) {
					try {
						d.writeAmbSetting("1");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					Thread t1 = new Thread(new Runnable() {

						@Override
						public void run() {

							Ambients.music_1.close();
						}
					});
					Thread t2 = new Thread(new Runnable() {

						@Override
						public void run() {

							Ambients.music_2.close();
						}
					});
					Thread t3 = new Thread(new Runnable() {

						@Override
						public void run() {

							Ambients.music_3.close();
						}
					});
					
					t1.start();
					t2.start();
					t3.start();
				}
			}
		});
		
		verBtn.setBounds(40,410,300,30);
		settingsPage.add(verBtn);
		verBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VersionCheck v = new VersionCheck();
				
				try {
					Effects.playButtonSound();
					v.verCheck();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		SwingUtilities.updateComponentTreeUI(settingsPage);
        
		//FRAME		
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(420, 150, 1150, 800);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
	}
	
	public void langTranslator() throws IOException {
		
        TableColumnModel columnModel = table_2.getColumnModel();
        for(int i=0; i<5; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(Language.tableTitles[i]);
        }
        TableColumnModel columnModel_2 = table.getColumnModel();
        for(int i=0; i<5; i++) {
            TableColumn column = columnModel_2.getColumn(i);
            column.setHeaderValue(Language.tableTitles[i]);
        }
				
		tabbedPane.setTitleAt(0, Language.lang.getProperty("tab1"));
		tabbedPane.setTitleAt(1, Language.lang.getProperty("tab2"));
		tabbedPane.setTitleAt(2, Language.lang.getProperty("tab3"));
		tabbedPane.setTitleAt(3, Language.lang.getProperty("tab4"));
		tabbedPane.setTitleAt(4, Language.lang.getProperty("tab6"));

		title1.setTitle(Language.lang.getProperty("title1"));
		title2.setTitle(Language.lang.getProperty("title2"));
		title3.setTitle(Language.lang.getProperty("title3"));
		title4.setTitle(Language.lang.getProperty("title4"));
		title5.setTitle(Language.lang.getProperty("title5"));
		title6.setTitle(Language.lang.getProperty("title6"));
		title7.setTitle(Language.lang.getProperty("title7"));
		title8.setTitle(Language.lang.getProperty("title8"));
		title9.setTitle(Language.lang.getProperty("title9"));
		title10.setTitle(Language.lang.getProperty("title10"));
		title11.setTitle(Language.lang.getProperty("title11"));
		title12.setTitle(Language.lang.getProperty("title12"));
		title13.setTitle(Language.lang.getProperty("title13"));
		
		diaryProteinLbl.setText(Language.lang.getProperty("diaryProteinLbl"));
		diaryCarbLbl.setText(Language.lang.getProperty("diaryCarbLbl"));
		diaryFatLbl.setText(Language.lang.getProperty("diaryFatLbl"));
		diaryCalLbl.setText(Language.lang.getProperty("diaryCalLbl"));
		
		proGoalLbl.setText(Language.lang.getProperty("proGoalLbl"));
		carbGoalLbl.setText(Language.lang.getProperty("carbGoalLbl"));
		fatGoalLbl.setText(Language.lang.getProperty("fatGoalLbl"));
		calGoalLbl.setText(Language.lang.getProperty("calGoalLbl"));
		
		amountLbl.setText(Language.lang.getProperty("amountLbl"));
		addBtn.setText(Language.lang.getProperty("addBtn"));
		resetAllFoodBtn.setText(Language.lang.getProperty("resetAllFoodBtn"));
		
		newNameLbl.setText(Language.lang.getProperty("newNameLbl"));
		newProLbl.setText(Language.lang.getProperty("newProLbl"));
		newCarbLbl.setText(Language.lang.getProperty("newCarbLbl"));
		newFatLbl.setText(Language.lang.getProperty("newFatLbl"));
		newCalLbl.setText(Language.lang.getProperty("newCalLbl"));
		addNewBtn.setText(Language.lang.getProperty("addNewBtn"));
		removeMealsBtn.setText(Language.lang.getProperty("removeMealsBtn"));
		
		addFavItem.setText(Language.lang.getProperty("addFavItem"));
		
		setCalGoalLbl.setText(Language.lang.getProperty("setCalGoalLbl"));
		setCarbGoalLbl.setText(Language.lang.getProperty("setCarbGoalLbl"));
		setFatGoalLbl.setText(Language.lang.getProperty("setFatGoalLbl"));
		setProGoalLbl.setText(Language.lang.getProperty("setProGoalLbl"));
		calGoalTitleLbl.setText(Language.lang.getProperty("calGoalTitleLbl"));
		setGoalBtn.setText(Language.lang.getProperty("setGoalBtn"));
		resetGoalBtn.setText(Language.lang.getProperty("resetGoalBtn"));
		
		themeTitleLbl.setText(Language.lang.getProperty("themeTitleLbl"));
		welcomeScrenCb.setText(Language.lang.getProperty("welcomeScrenCb"));
		resetProfileBtn.setText(Language.lang.getProperty("resetProfileBtn"));
		gitPageTitleLbl.setText(Language.lang.getProperty("gitPageTitleLbl"));
		deleteProfileBtn.setText(Language.lang.getProperty("deleteProfileBtn"));
		langSettingLbl.setText(Language.lang.getProperty("langSettingLbl"));
		soundLbl.setText(Language.lang.getProperty("soundLbl"));
		verBtn.setText(Language.lang.getProperty("verBtn"));
		
		lblWaist.setText(Language.lang.getProperty("lblWaist"));
		lblGender.setText(Language.lang.getProperty("lblGender"));
		lblHip.setText(Language.lang.getProperty("lblHip"));
		lblHeight.setText(Language.lang.getProperty("lblHeight"));
		lblNeck.setText(Language.lang.getProperty("lblNeck"));
		maleRadio.setText(Language.lang.getProperty("maleRadio"));
		femaleRadio.setText(Language.lang.getProperty("femaleRadio"));
		bodyFatBtn.setText(Language.lang.getProperty("bodyFatBtn"));
		lblBFResultTitle.setText(Language.lang.getProperty("lblBFResultTitle"));
		
		lblWeight_2.setText(Language.lang.getProperty("lblWeight_2"));
		lblHeight_2.setText(Language.lang.getProperty("lblHeight_2"));
		bmiBtn.setText(Language.lang.getProperty("bmiBtn"));
		lblBmiResultTitle.setText(Language.lang.getProperty("lblBmiResultTitle"));
		
		lblGender_3.setText(Language.lang.getProperty("lblGender_3"));
		lblAge_3.setText(Language.lang.getProperty("lblAge_3"));
		lblWeight_3.setText(Language.lang.getProperty("lblWeight_3"));
		lblHeight_3.setText(Language.lang.getProperty("lblHeight_3"));
		lblActivitiy.setText(Language.lang.getProperty("lblActivitiy"));
		maleRadio_3.setText(Language.lang.getProperty("maleRadio_3"));
		femaleRadio_3.setText(Language.lang.getProperty("femaleRadio_3"));
		calBtn.setText(Language.lang.getProperty("calBtn"));
		calResultTitle.setText(Language.lang.getProperty("calResultTitle"));
		calResultType.setText(Language.lang.getProperty("calResultType"));
		
		d.readDefaultFoods();
		d.writeTable2();
	}
	
	public void nextDay() {
				
		Charts c = new Charts();
    	
    	LocalDate currentDate = LocalDate.now();
    	
    	LocalDate pastDate = LocalDate.of(Integer.parseInt(Data.profile.getProperty("year")),
    										Integer.parseInt(Data.profile.getProperty("month")),
    										Integer.parseInt(Data.profile.getProperty("day")));
    	
    	int gap = (int) ChronoUnit.DAYS.between(pastDate, currentDate);
		
    	for(int i=0; i<gap; i++) {
    		
			try {
				d.writeWeeklyCal(d.today[3]);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			sPanel5.removeAll();
			c.weeklyCalChart(d.weeklyCal[0], d.weeklyCal[1], d.weeklyCal[2], d.weeklyCal[3], d.weeklyCal[4], d.weeklyCal[5], d.weeklyCal[6]);
			
			try {
				d.writeWeeklyMacros(d.today[0], d.today[1], d.today[2]);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			sPanel4.removeAll();
			c.weeklyMacChart(d.weeklyMacros[0], d.weeklyMacros[1], d.weeklyMacros[2], d.weeklyMacros[3], d.weeklyMacros[4], d.weeklyMacros[5], 
					d.weeklyMacros[6], d.weeklyMacros[7], d.weeklyMacros[8], d.weeklyMacros[9], d.weeklyMacros[10], d.weeklyMacros[11], d.weeklyMacros[12], 
					d.weeklyMacros[13], d.weeklyMacros[14], d.weeklyMacros[15], d.weeklyMacros[16], d.weeklyMacros[17], d.weeklyMacros[18], d.weeklyMacros[19], 
					d.weeklyMacros[20]);
			
			proteinValue.setText("0");
			carbValue.setText("0");
			fatValue.setText("0");
			calValue.setText("0");
			
			try {
				d.writeToday("0", "0", "0", "0");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			sPanel2.removeAll();
			c.pieChart("0", "0", "0");
			
			progressBar.setValue(0);
			progressBar_1.setValue(0);
			progressBar_2.setValue(0);
			progressBar_3.setValue(0);
			SwingUtilities.updateComponentTreeUI(sPanel3);
			
			sPanel3.add(progressBar);
			sPanel3.add(progressBar_1);
			sPanel3.add(progressBar_2);
			sPanel3.add(progressBar_3);
    	}
	}
}