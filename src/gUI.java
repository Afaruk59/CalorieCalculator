import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class gUI{
		
	Data d= new Data();
	User u= new User();
	Body b = new Body();

	//MAIN FRAME
	JFrame mainFrame= new JFrame("Afaruk59's Calorie Calculator V3.0.0");
	JPanel contentPane = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	//FONTS
	Font title = new Font("Arial", Font.BOLD, 20);
	Font label = new Font("Arial", Font.PLAIN, 13);
	Font tab = new Font("Arial", Font.PLAIN, 13);
	
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
	
    //SUMMARY PANELS
	JPanel panel = new JPanel();
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	JPanel sPanel1 = new JPanel();
	JPanel sPanel2 = new JPanel();
	JPanel sPanel3 = new JPanel();
	JPanel sPanel4 = new JPanel();
	JPanel sPanel5 = new JPanel();
	
	JLabel label1 = new JLabel("Diary");
	JLabel label2 = new JLabel("Protein (g):");
	JLabel label3 = new JLabel("Carb (g):");
	JLabel label4 = new JLabel("Fat (g):");
	JLabel label5 = new JLabel("Calorie (kJ):");
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JLabel label9 = new JLabel();
	JButton btn6 = new  JButton("Skip to the Next Day  --->");
	
	JLabel label10 = new JLabel("Goals");
	JLabel label11 = new JLabel("Protein");
	JLabel label12 = new JLabel("Carb");
	JLabel label13 = new JLabel("Fat");
	JLabel label14 = new JLabel("Calorie");
	JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBar_1 = new JProgressBar();
	JProgressBar progressBar_2 = new JProgressBar();
	JProgressBar progressBar_3 = new JProgressBar();
	
	//FOOD PANEL
	JPanel panel_1 = new JPanel();
	JPanel fPanelWest = new JPanel();
	JPanel fPanelUp = new JPanel();
	JComboBox comboBox = new JComboBox();
	SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
	JSpinner spinner = new JSpinner(model);
	JLabel label15 = new JLabel("Add Food :");
	JLabel label16 = new JLabel("Amount (g) :");
	JButton btn1 = new JButton("Add");
	JButton btn2 = new JButton("Reset All Food");
	
	JPanel fPanelDown = new JPanel();
	JLabel label22 = new JLabel("Add New Food");
	JLabel label17 = new JLabel("Name:");
	JLabel label18 = new JLabel("Protein (per 1g):");
	JLabel label19 = new JLabel("Carb (per 1g);");
	JLabel label20 = new JLabel("Fat (per 1g):");
	JLabel label21 = new JLabel("Calorie (per 1g);");
	JTextField textField = new JTextField();
	JTextField textField_1 = new JTextField();
	JTextField textField_2 = new JTextField();
	JTextField textField_3 = new JTextField();
	JTextField textField_4 = new JTextField();
	JButton btn3 = new JButton("Add New");
	JButton btn4 = new JButton("Remove Added Meals");
	
	String[] titles = {"NAME","PROTEIN","CARB","FAT","CALORIE"};
	JTable table = new JTable(d.table_1, titles);
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	JPanel fPanelEast = new JPanel();
	JScrollPane fPanelUp_2 = new JScrollPane(table);
	
	JTable table_2 = new JTable(d.table_2, titles);
	JScrollPane fPanelDown_2 = new JScrollPane(table_2);
	JPopupMenu popMenu = new JPopupMenu("Menu");
    JMenuItem mi = new JMenuItem("Add to Favourites");
    Object tableValue;
	
	//GOALS PANEL
	JPanel panel_2 = new JPanel();
	JPanel gPanelWest= new JPanel();
	JPanel gPanelEast= new JPanel();
	JPanel chartPanel= new JPanel();
	JLabel label27 = new JLabel("Set Goals");
	JLabel label23 = new JLabel("Calorie (kJ):");
	JLabel label24 = new JLabel("Carb (g):");
	JLabel label25 = new JLabel("Fat (g):");
	JLabel label26 = new JLabel("Protein (g):");
	JLabel label28 = new JLabel("Calorie: ");
	JLabel label29 = new JLabel();
	JTextField textField_5 = new JTextField();
	JTextField textField_6 = new JTextField();
	JTextField textField_7 = new JTextField();
	JTextField textField_8 = new JTextField();
	JButton btn5= new JButton("Set");
	JButton btn7= new JButton("Reset");
	
	//SETTINGS PANEL
	JPanel panel_3 = new JPanel();
	JLabel lbl= new JLabel("Choose GUI Theme");
	JComboBox comboBox2= new JComboBox();
	JCheckBox cB= new JCheckBox("Show Welcome Screen");
	JButton btn8 = new  JButton("Reset Profile");
    JLabel lbl2= new JLabel("Github Page:");
    JButton btn9 = new JButton("Afaruk59/CalorieCalculator");
    JButton btn10 = new JButton("Delete Profile");
    
    //BODY PANEL
    JPanel panel_4 = new JPanel();
    
    JPanel bPanel_1 = new JPanel();
	JLabel lblWaist = new JLabel("Waist (cm):");
	JLabel lblGender = new JLabel("Gender:");
	JLabel lblHip = new JLabel("Hip (cm):");
	JLabel lblHeight = new JLabel("Height (cm):");
	JLabel lblNeck = new JLabel("Neck (cm):");
	JRadioButton maleRadio = new JRadioButton("Male");
	JRadioButton femaleRadio = new JRadioButton("Female");
	ButtonGroup bg_1 = new ButtonGroup();
	JTextField hipTF = new JTextField();
	JTextField heightTF = new JTextField();
	JTextField neckTF = new JTextField();
	JTextField waistTF = new JTextField();
	JButton bodyFatBtn = new JButton("Calculate");
	JLabel lblBFResultTitle = new JLabel("Final Body Fat Result");
	JLabel bodyFatResult = new JLabel("% 0");
	JLabel bFResultType = new JLabel("Essential Fat");
	
	JPanel bPanel_2 = new JPanel();
	JLabel lblWeight_2 = new JLabel("Weight (kg):");
	JLabel lblHeight_2 = new JLabel("Height (cm):");
	JTextField weightTF_2 = new JTextField();
	JTextField heightTF_2 = new JTextField();
	JButton bmiBtn = new JButton("Calculate");
	JLabel lblBmiResultTitle = new JLabel("Final BMI Result");
	JLabel bmiResult = new JLabel("% 0");
	JLabel bmiResultType = new JLabel("Severe Thinness");
	
    JPanel bPanel_3 = new JPanel();
	JLabel lblGender_3 = new JLabel("Gender:");
	JLabel lblAge_3 = new JLabel("Age:");
	JLabel lblWeight_3 = new JLabel("Weight (kg):");
	JLabel lblHeight_3 = new JLabel("Height (cm):");
	JLabel lblActivitiy = new JLabel("Activitiy:");
	JRadioButton maleRadio_3 = new JRadioButton("Male");
	JRadioButton femaleRadio_3 = new JRadioButton("Female");
	ButtonGroup bg_3 = new ButtonGroup();
	JTextField ageTF_3 = new JTextField();
	JTextField weightTF_3 = new JTextField();
	JTextField heightTF_3 = new JTextField();
	String[] activity = {"BMR (Basal Metabolic Rate)" , "Sedentary", "Moderate" , "Active"};
	JComboBox activityBox = new JComboBox(activity);
	JButton calBtn = new JButton("Calculate");
	JLabel calResultTitle = new JLabel("Final Calorie Result");
	JLabel calResult = new JLabel("0 Calories/Day");
	JLabel calResultType = new JLabel("Maintain Weight");
	
	public void gui() throws IOException {
				
		//READ SAVED DATA
		d.loadProfile();
		d.readFoods();
		d.readDefaultFoods();
		d.writeTable1();
		d.writeTable2();
		
		//CONTENT PANE
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		mainFrame.setContentPane(contentPane);
		
		//TABBED PANE
		contentPane.add(tabbedPane);
//---------------------------------------------------------------------------------------------		
		//SUMMARY PANE
		tabbedPane.addTab("Summary", null, panel, null);
		tabbedPane.setFont(tab);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(10,10,10,10));
		
		panelUp.setLayout(new BoxLayout(panelUp, BoxLayout.X_AXIS));
		panel.add(panelUp);
		
		panelDown.setLayout(new BoxLayout(panelDown, BoxLayout.X_AXIS));
		panel.add(panelDown);
		
		sPanel1.setPreferredSize(new Dimension(250,341));
		panelUp.add(sPanel1);
		sPanel1.setLayout(null);
		sPanel1.setBorder(title1);
		title1.setTitleFont(title);
		
		sPanel3.setPreferredSize(new Dimension(400,341));
		panelUp.add(sPanel3);
		sPanel3.setLayout(null);
		sPanel3.setBorder(title2);
		title2.setTitleFont(title);
		
		sPanel2.setPreferredSize(new Dimension(402,341));
		panelUp.add(sPanel2);
		sPanel2.setLayout(new BoxLayout(sPanel2, BoxLayout.X_AXIS));
		sPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		sPanel2.setBorder(title3);
		title3.setTitleFont(title);
		
		sPanel4.setPreferredSize(new Dimension(653,341));
		panelDown.add(sPanel4);
		sPanel4.setLayout(new BoxLayout(sPanel4, BoxLayout.X_AXIS));
		sPanel4.setBorder(title4);
		title4.setTitleFont(title);
		title4.setTitlePosition(5);
		
		sPanel5.setPreferredSize(new Dimension(653,341));
		panelDown.add(sPanel5);
		sPanel5.setLayout(new BoxLayout(sPanel5, BoxLayout.X_AXIS));
		sPanel5.setBorder(title5);
		title5.setTitleFont(title);
		title5.setTitlePosition(5);
		
		label2.setBounds(32, 86, 100, 30);
		sPanel1.add(label2);
		label2.setFont(label);
		
		label3.setBounds(32, 128, 100, 30);
		sPanel1.add(label3);
		label3.setFont(label);
		
		label4.setBounds(32, 170, 100, 30);
		sPanel1.add(label4);
		label4.setFont(label);
		
		label5.setBounds(32, 212, 100, 30);
		sPanel1.add(label5);
		label5.setFont(label);
		
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBounds(171, 86, 100, 30);
		sPanel1.add(label6);
		label6.setText(d.today[0]);
		label6.setFont(label);
		
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setBounds(171, 128, 100, 30);
		sPanel1.add(label7);
		label7.setText(d.today[1]);
		label7.setFont(label);
		
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setBounds(171, 170, 100, 30);
		sPanel1.add(label8);
		label8.setText(d.today[2]);
		label8.setFont(label);
		
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setBounds(171, 212, 100, 30);
		sPanel1.add(label9);
		label9.setText(d.today[3]);
		label9.setFont(label);
		
		btn6.setBounds(32, 260, 200, 30);
		sPanel1.add(btn6);
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					d.writeWeeklyCal(d.today[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				sPanel5.removeAll();
				weeklyCalChart(d.weeklyCal[0], d.weeklyCal[1], d.weeklyCal[2], d.weeklyCal[3], d.weeklyCal[4], d.weeklyCal[5], d.weeklyCal[6]);
				
				try {
					d.writeWeeklyMacros(d.today[0], d.today[1], d.today[2]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				sPanel4.removeAll();
				weeklyMacChart(d.weeklyMacros[0], d.weeklyMacros[1], d.weeklyMacros[2], d.weeklyMacros[3], d.weeklyMacros[4], d.weeklyMacros[5], 
						d.weeklyMacros[6], d.weeklyMacros[7], d.weeklyMacros[8], d.weeklyMacros[9], d.weeklyMacros[10], d.weeklyMacros[11], d.weeklyMacros[12], 
						d.weeklyMacros[13], d.weeklyMacros[14], d.weeklyMacros[15], d.weeklyMacros[16], d.weeklyMacros[17], d.weeklyMacros[18], d.weeklyMacros[19], 
						d.weeklyMacros[20]);
				
				label6.setText("0");
				label7.setText("0");
				label8.setText("0");
				label9.setText("0");
				
				try {
					d.writeToday("0", "0", "0", "0");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				sPanel2.removeAll();
				pieChart("0", "0", "0");
				
				progressBar.setValue(0);
				progressBar_1.setValue(0);
				progressBar_2.setValue(0);
				progressBar_3.setValue(0);
				SwingUtilities.updateComponentTreeUI(sPanel3);
				
				sPanel3.add(progressBar);
				sPanel3.add(progressBar_1);
				sPanel3.add(progressBar_2);
				sPanel3.add(progressBar_3);
				
				JOptionPane.showMessageDialog(mainFrame, "Passed the next day.", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		label11.setBounds(46, 41, 70, 15);
		sPanel3.add(label11);
		label11.setFont(label);
		
		label12.setBounds(46, 110, 70, 15);
		sPanel3.add(label12);
		label12.setFont(label);
		
		label13.setBounds(46, 179, 70, 15);
		sPanel3.add(label13);
		label13.setFont(label);
		
		label14.setBounds(46, 248, 70, 15);
		sPanel3.add(label14);
		label14.setFont(label);
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(46, 62, 318, 30);
		sPanel3.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(Integer.parseInt(d.goals[1]));
		progressBar.setValue((int) Double.parseDouble(d.today[0]));
		progressBar.setFont(label);
		
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(46, 132, 318, 30);
		sPanel3.add(progressBar_1);
		progressBar_1.setMinimum(0);
		progressBar_1.setMaximum(Integer.parseInt(d.goals[2]));
		progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
		progressBar_1.setFont(label);
		
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(46, 201, 318, 30);
		sPanel3.add(progressBar_2);
		progressBar_2.setMinimum(0);
		progressBar_2.setMaximum(Integer.parseInt(d.goals[3]));
		progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
		progressBar_2.setFont(label);
		
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(46, 270, 318, 30);
		sPanel3.add(progressBar_3);
		progressBar_3.setMinimum(0);
		progressBar_3.setMaximum(Integer.parseInt(d.goals[0]));
		progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
		progressBar_3.setFont(label);
//---------------------------------------------------------------------------------------------		
		//FOOD PANE
		tabbedPane.addTab("Food", null, panel_1, null);
		panel_1.setLayout(new BoxLayout(panel_1 , BoxLayout.X_AXIS));
		panel_1.setBorder(new EmptyBorder(10,10,10,10));
		
		//WEST SIDE
		fPanelWest.setLayout(new BoxLayout(fPanelWest , BoxLayout.Y_AXIS));
		panel_1.add(fPanelWest);
		fPanelWest.setPreferredSize(new Dimension(400,500));
		
		//UP SIDE
		fPanelUp.setBorder(BorderFactory.createTitledBorder(title6));
		title6.setTitleFont(title);
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
		
		label16.setBounds(123, 109, 177, 60);
		fPanelUp.add(label16);
		label16.setFont(label);
		
		//ADD FOOD BUTTON
		btn1.setBounds(246, 180, 156, 34);
		fPanelUp.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				double pro,carb,fat,cal;
						
				pro= Double.parseDouble(label6.getText());
				carb= Double.parseDouble(label7.getText());
				fat= Double.parseDouble(label8.getText());
				cal= Double.parseDouble(label9.getText());
						
				for(int i=0; i<100; i++) {
					if(comboBox.getSelectedItem() == d.addedMeals[i]) {
								
						pro += (Double.parseDouble(d.addedMeals[i+1]) * (int) spinner.getValue());
						carb += (Double.parseDouble(d.addedMeals[i+2]) * (int) spinner.getValue());
						fat += (Double.parseDouble(d.addedMeals[i+3]) * (int) spinner.getValue());
						cal += (Double.parseDouble(d.addedMeals[i+4]) * (int) spinner.getValue());
						break;
					}
				}
						
				label6.setText(Double.toString(pro));
				label7.setText(Double.toString(carb));
				label8.setText(Double.toString(fat));
				label9.setText(Double.toString(cal));
				
				sPanel2.removeAll();
				
				try {
					d.writeToday(label6.getText(), label7.getText(), label8.getText(), label9.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				pieChart(label6.getText(), label7.getText(), label8.getText());
				
				progressBar.setValue((int) Double.parseDouble(d.today[0]));
				progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
				progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
				progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
				
				JOptionPane.showMessageDialog(mainFrame, "The food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//RESET BUTTON
		btn2.setBounds(122, 235, 280, 34);
		fPanelUp.add(btn2);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label6.setText("0");
				label7.setText("0");
				label8.setText("0");
				label9.setText("0");
				
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
				
				pieChart("0", "0", "0");
				
				JOptionPane.showMessageDialog(mainFrame, "All meals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//DOWN SIDE
		fPanelDown.setBorder(BorderFactory.createTitledBorder(title7));
		title7.setTitleFont(title);
		title7.setTitlePosition(5);
		fPanelWest.add(fPanelDown);
		fPanelDown.setLayout(null);
		
		label17.setBounds(120, 46, 120, 20);
		fPanelDown.add(label17);
		label17.setFont(label);
		
		label18.setBounds(120, 77, 120, 20);
		fPanelDown.add(label18);
		label18.setFont(label);
		
		label19.setBounds(120, 108, 120, 20);
		fPanelDown.add(label19);
		label19.setFont(label);
		
		label20.setBounds(120, 139, 120, 20);
		fPanelDown.add(label20);
		label20.setFont(label);
		
		label21.setBounds(120, 170, 120, 20);
		fPanelDown.add(label21);
		label21.setFont(label);
		
		//NEW FOOD NAME
		textField.setBounds(275, 45, 125, 25);
		fPanelDown.add(textField);
		
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
		btn3.setBounds(274, 210, 125, 34);
		fPanelDown.add(btn3);
		btn3.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
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
				panel_1.remove(fPanelEast);
				panel_1.add(fPanelEast);
				JOptionPane.showMessageDialog(mainFrame, "The new meal has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//REMOVE ALL BUTTON
		btn4.setBounds(120, 260, 279, 34);
		fPanelDown.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
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
				panel_1.remove(fPanelEast);
				panel_1.add(fPanelEast);
				JOptionPane.showMessageDialog(mainFrame, "All saved meals have been removed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//EAST SIDE
		panel_1.add(fPanelEast);
		fPanelEast.setLayout(new BoxLayout(fPanelEast, BoxLayout.Y_AXIS));
		
		fPanelEast.add(fPanelUp_2);
		fPanelUp_2.setBorder(BorderFactory.createTitledBorder(title8));
		title8.setTitleFont(title);
		
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table.setEnabled(false);
        
		fPanelEast.add(fPanelDown_2);
		fPanelDown_2.setBorder(BorderFactory.createTitledBorder(title10));
		title10.setTitleFont(title);
		title10.setTitlePosition(5);
		
        table_2.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table_2.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table_2.setEnabled(false);
        
        popMenu.add(mi);        
        mi.addActionListener(new ActionListener() {

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
					panel_1.remove(fPanelEast);
					panel_1.add(fPanelEast);
				}
				else if(tableValue == null) {
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
                    popMenu.show(table_2, e.getX(), e.getY());
                }
            }
        });
//---------------------------------------------------------------------------------------------
		//GOALS PANE
		tabbedPane.addTab("Goals", null, panel_2, null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		panel_2.setBorder(new EmptyBorder(10,10,10,10));
		
		//WEST SIDE
		gPanelWest.setPreferredSize(new Dimension(925,341));
		gPanelWest.setBorder(BorderFactory.createTitledBorder(title9));
		title9.setTitleFont(title);
		gPanelWest.setLayout(null);
		panel_2.add(gPanelWest);
		
		label23.setHorizontalAlignment(SwingConstants.LEFT);
		label23.setBounds(125, 199, 89, 20);
		gPanelWest.add(label23);
		label23.setFont(label);
		
		label24.setHorizontalAlignment(SwingConstants.LEFT);
		label24.setBounds(125, 263, 89, 20);
		gPanelWest.add(label24);
		label24.setFont(label);
		
		label25.setHorizontalAlignment(SwingConstants.LEFT);
		label25.setBounds(125, 295, 89, 20);
		gPanelWest.add(label25);
		label25.setFont(label);
		
		label26.setHorizontalAlignment(SwingConstants.LEFT);
		label26.setBounds(125, 230, 89, 20);
		gPanelWest.add(label26);
		label26.setFont(label);
		
		label28.setHorizontalAlignment(SwingConstants.CENTER);
		label28.setBounds(130, 530, 100, 50);
		gPanelWest.add(label28);
		label28.setFont(new Font("Arial" , Font.BOLD , 25));
		
		label29.setHorizontalAlignment(SwingConstants.CENTER);
		label29.setBounds(280, 530, 100, 50);
		gPanelWest.add(label29);
		label29.setFont(new Font("Arial" , Font.BOLD , 25));
		label29.setText(d.goals[0]);
		
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
		
		btn5.setBounds(240,330,139,34);
		gPanelWest.add(btn5);
		btn5.addActionListener(new ActionListener() {

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
					gPieChart(d.goals[1], d.goals[2], d.goals[3]);
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
				
				label29.setText(d.goals[0]);
				JOptionPane.showMessageDialog(mainFrame, "Goals have been set.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn7.setBounds(124,377,255,34);
		gPanelWest.add(btn7);
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				progressBar.setMaximum(0);
				progressBar_1.setMaximum(0);
				progressBar_2.setMaximum(0);
				progressBar_3.setMaximum(0);
				
				chartPanel.removeAll();
				
				try {
					d.writeGoals("0", "0", "0", "0");
					gPieChart(d.goals[1], d.goals[2], d.goals[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				label29.setText(d.goals[0]);
				JOptionPane.showMessageDialog(mainFrame, "Goals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		//EAST SIDE
		panel_2.add(gPanelEast);
		gPanelEast.setLayout(null);
		gPanelEast.setBorder(BorderFactory.createTitledBorder(title2));
		gPanelEast.setPreferredSize(new Dimension(1047,341));
		
		chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
		chartPanel.setBounds(45,110,500,450);
		gPanelEast.add(chartPanel);
		
//---------------------------------------------------------------------------------------------
		//BODY PANE
		tabbedPane.addTab("Body", null, panel_4, null);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		panel_4.setBorder(new EmptyBorder(10,10,10,10));
		
		//BODY FAT
		panel_4.add(bPanel_1);
		bPanel_1.setBorder(title11);
		title11.setTitleFont(title);
		bPanel_1.setLayout(null);
		
		lblWaist.setBounds(75, 334, 100, 30);
		bPanel_1.add(lblWaist);
		lblWaist.setFont(label);
		
		lblGender.setBounds(75, 170, 100, 30);
		bPanel_1.add(lblGender);
		lblGender.setFont(label);
		
		lblHip.setBounds(75, 211, 100, 30);
		bPanel_1.add(lblHip);
		lblHip.setFont(label);
		
		lblHeight.setBounds(75, 252, 100, 30);
		bPanel_1.add(lblHeight);
		lblHeight.setFont(label);
		
		lblNeck.setBounds(75, 293, 100, 30);
		bPanel_1.add(lblNeck);
		lblNeck.setFont(label);
		
		maleRadio.setBounds(160, 174, 54, 23);
		bPanel_1.add(maleRadio);
		maleRadio.setFont(label);
		
		femaleRadio.setBounds(216, 174, 70, 23);
		bPanel_1.add(femaleRadio);
		femaleRadio.setFont(label);
		
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
				
				String result = b.bodyFat_;
				
				if(b.bodyFat_.equals("0") == false) {
					bodyFatResult.setText("% " + result);
				}
				
				if(maleRadio.isSelected() == true && b.bodyFat_.equals("0") == false) {
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
				
				if(femaleRadio.isSelected() == true && b.bodyFat_.equals("0") == false) {
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
				
				if(b.bodyFat_.equals("0") == false) {
					
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
		lblBFResultTitle.setFont(title);
		
		bodyFatResult.setHorizontalAlignment(SwingConstants.CENTER);
		bodyFatResult.setBounds(75, 492, 211, 30);
		bPanel_1.add(bodyFatResult);
		bodyFatResult.setFont(label);
		bodyFatResult.setText("% " + d.readBodyFatResult());
		
		bFResultType.setHorizontalAlignment(SwingConstants.CENTER);
		bFResultType.setBounds(75, 533, 211, 30);
		bPanel_1.add(bFResultType);
		bFResultType.setFont(label);
		bFResultType.setText(d.readBodyFatResultType());
		
		//BMI
		panel_4.add(bPanel_2);
		bPanel_2.setBorder(title12);
		title12.setTitleFont(title);
		bPanel_2.setLayout(null);
		
		lblWeight_2.setBounds(75, 262, 100, 30);
		bPanel_2.add(lblWeight_2);
		lblWeight_2.setFont(label);
		
		lblHeight_2.setBounds(75, 303, 100, 30);
		bPanel_2.add(lblHeight_2);
		lblHeight_2.setFont(label);
		
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
				
				String result = b.bmi_;
				
				if(b.bmi_.equals("0") == false) {
					bmiResult.setText("% " + result);
				}
				
				if(b.bmi_.equals("0") == false) {
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
				
				if(b.bmi_.equals("0") == false) {
					
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
		lblBmiResultTitle.setFont(title);
			
		bmiResult.setHorizontalAlignment(SwingConstants.CENTER);
		bmiResult.setBounds(75, 492, 211, 30);
		bPanel_2.add(bmiResult);
		bmiResult.setFont(label);
		bmiResult.setText("% " + d.readBmiResult());
			
		bmiResultType.setHorizontalAlignment(SwingConstants.CENTER);
		bmiResultType.setBounds(75, 533, 211, 30);
		bPanel_2.add(bmiResultType);
		bmiResultType.setFont(label);
		bmiResultType.setText(d.readBmiResultType());
		
		//CALORIE
		panel_4.add(bPanel_3);
		bPanel_3.setBorder(title13);
		title13.setTitleFont(title);
		bPanel_3.setLayout(null);
		
		lblGender_3.setBounds(75, 150, 100, 30);
		bPanel_3.add(lblGender_3);
		lblGender_3.setFont(label);
				
		lblAge_3.setBounds(75, 191, 100, 30);
		bPanel_3.add(lblAge_3);
		lblAge_3.setFont(label);
				
		lblWeight_3.setBounds(75, 232, 100, 30);
		bPanel_3.add(lblWeight_3);
		lblWeight_3.setFont(label);
				
		lblHeight_3.setBounds(75, 273, 100, 30);
		bPanel_3.add(lblHeight_3);
		lblHeight_3.setFont(label);
				
		lblActivitiy.setBounds(76, 309, 100, 30);
		bPanel_3.add(lblActivitiy);
		lblActivitiy.setFont(label);
				
		maleRadio_3.setBounds(160, 154, 54, 23);
		bPanel_3.add(maleRadio_3);
		maleRadio_3.setFont(label);
				
		femaleRadio_3.setBounds(216, 154, 70, 23);
		bPanel_3.add(femaleRadio_3);
		femaleRadio_3.setFont(label);
		
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
				
				if(b.calorie.equals("0") == false) {
					
					calResult.setText(b.calorie + " Calories/Day");
					
					try {
						d.writeCalorieResult(b.calorie);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
				
		calResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		calResultTitle.setBounds(55, 451, 251, 30);
		bPanel_3.add(calResultTitle);
		calResultTitle.setFont(title);
				
		calResult.setHorizontalAlignment(SwingConstants.LEFT);
		calResult.setBounds(70, 492, 300, 30);
		bPanel_3.add(calResult);
		calResult.setFont(label);
		calResult.setText(d.readCalorieResult() + " Calories/Day");
				
		calResultType.setHorizontalAlignment(SwingConstants.CENTER);
		calResultType.setBounds(185, 492, 120, 30);
		bPanel_3.add(calResultType);
		calResultType.setFont(label);
				
//---------------------------------------------------------------------------------------------
		//SETTINGS PANE
		tabbedPane.addTab("Settings", null, panel_3, null);
		panel_3.setLayout(null);
		panel_3.setBorder(new EmptyBorder(10,10,10,10));
		
		lbl.setBounds(40,30,150,30);
		panel_3.add(lbl);
		lbl.setFont(label);

        comboBox2.addItem("Light");
        comboBox2.addItem("Dark");
        comboBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(comboBox2.getSelectedIndex()==0) {
					try {
			            UIManager.setLookAndFeel( new FlatLightLaf() );
			            SwingUtilities.updateComponentTreeUI(mainFrame);
			            SwingUtilities.updateComponentTreeUI(popMenu);
			            d.writeThemeSetting(0);
			        } catch( Exception ex ) {
			            System.err.println( "Failed to initialize LaF" );
			        }
				}
				else if(comboBox2.getSelectedIndex()==1) {
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
        comboBox2.setBounds(40,70,300,30);
        panel_3.add(comboBox2);
        try {
			comboBox2.setSelectedIndex(d.readThemeSetting());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        cB.setBounds(40,120,500,30);
        cB.setBackground(null);
        panel_3.add(cB);
        cB.setFont(tab);
        SwingUtilities.updateComponentTreeUI(cB);
        int set= d.readWSetting();
        if(set==1) {
        	cB.setSelected(true);
        }
        cB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cB.isSelected()) {
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
        
        btn8.setBounds(40,170,300,30);
        panel_3.add(btn8);
		SwingUtilities.updateComponentTreeUI(btn8);
        btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure?", "Reset Profile", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						d.resetProfile();
						d.removeFoods();
						JOptionPane.showMessageDialog(mainFrame, "Profile has been reset.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
        });
        
        lbl2.setBounds(371,30,150,30);
        lbl2.setFont(label);
        panel_3.add(lbl2);
		SwingUtilities.updateComponentTreeUI(lbl2);
        
        btn9.setBounds(370,70,300,30);
        panel_3.add(btn9);
		SwingUtilities.updateComponentTreeUI(btn9);
        btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					URI url = new URI("https://github.com/Afaruk59/CalorieCalculator");
					java.awt.Desktop.getDesktop().browse(url);
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
				}
			}
        });
        
        btn10.setBounds(40,230,300,30);
        panel_3.add(btn10);
		SwingUtilities.updateComponentTreeUI(btn10);
		btn10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure?", "Delete Profile", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						u.deleteProfile();
						JOptionPane.showMessageDialog(mainFrame, "Profile removed.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
        });
        
		//FRAME		
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(420, 150, 1150, 800);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		
		try {
			profileName();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void welcomeFrame() throws InterruptedException, IOException {
		
		JFrame frame= new JFrame("Welcome to ACC V3.0.0");
		frame.setBounds(620, 300, 750, 500);
		frame.setResizable(false);
		
		contentPane = new JPanel();
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
        
        if(comboBox2.getSelectedIndex() == 0) {
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

	public void coffeeAnimation() throws InterruptedException {
		
		JPanel coffeePanel = new JPanel();
		coffeePanel.setLayout(new BoxLayout(coffeePanel, BoxLayout.X_AXIS));
		coffeePanel.setBounds(1101,6,25,25);
		mainFrame.add(coffeePanel);
		
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
        
        while(true) {
    		if(comboBox2.getSelectedIndex() == 1) {
				imgLab3.setVisible(true);
				Thread.sleep(1000);
				imgLab3.setVisible(false);
				imgLab4.setVisible(true);
				Thread.sleep(1000);
				imgLab4.setVisible(false);
    		}
    		else if(comboBox2.getSelectedIndex() == 0) {
				imgLab1.setVisible(true);
				Thread.sleep(1000);
				imgLab1.setVisible(false);
				imgLab2.setVisible(true);
				Thread.sleep(1000);
				imgLab2.setVisible(false);
			}
        }
	}
	
	public void profileName() throws InterruptedException {
		
		User u= new User();
		
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		profilePanel.setBounds(890,3,200,40);
		mainFrame.add(profilePanel);
		
		ImageIcon img1 = new ImageIcon("resources\\img\\user.png");
		Image scaledImage1 = img1.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imgLab1 = new JLabel(scaledIcon1);
        profilePanel.add(imgLab1);
		
		JLabel name = new JLabel(u.userName);
		Font font = new Font("Arial", Font.BOLD, 15);
		name.setFont(font);
		profilePanel.add(name);
	}

	public void pieChart(String pro, String carb, String fat) {
		
		double p = Double.parseDouble(pro);
		double c = Double.parseDouble(carb);
		double f = Double.parseDouble(fat);
        	
        	//DATA SET
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Protein", p);
            dataset.setValue("Carb", c);
            dataset.setValue("Fat", f);

            JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);
            
            chart.setBackgroundPaint(null);
            chart.getLegend().setBackgroundPaint(null);
            chart.getLegend().setItemPaint(Color.GRAY);
            chart.getPlot().setBackgroundPaint(null);
            
            ChartPanel chartPanel = new ChartPanel(chart);
            sPanel2.add(chartPanel);
	}
	
	public void gPieChart(String pro, String carb, String fat) {
		
		int p = Integer.parseInt(pro);
		int c = Integer.parseInt(carb);
		int f = Integer.parseInt(fat);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Protein", p);
        dataset.setValue("Carb", c);
        dataset.setValue("Fat", f);

        JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);

        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);

        ChartPanel chartPanel = new ChartPanel(chart);
        this.chartPanel.add(chartPanel);    
	}
	
	public void weeklyMacChart(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, 
			String k, String l, String m, String n, String o, String p, String r, String s, String t, String u, String v) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(Double.parseDouble(v), "Protein", "T-7");
		dataset.addValue(Double.parseDouble(u), "Carb", "T-7");
		dataset.addValue(Double.parseDouble(t), "Fat", "T-7");
       
		dataset.addValue(Double.parseDouble(s), "Protein", "T-6");
		dataset.addValue(Double.parseDouble(r), "Carb", "T-6");
		dataset.addValue(Double.parseDouble(p), "Fat", "T-6");
       
		dataset.addValue(Double.parseDouble(o), "Protein", "T-5");
		dataset.addValue(Double.parseDouble(n), "Carb", "T-5");
		dataset.addValue(Double.parseDouble(m), "Fat", "T-5");
       
		dataset.addValue(Double.parseDouble(l), "Protein", "T-4");
		dataset.addValue(Double.parseDouble(k), "Carb", "T-4");
		dataset.addValue(Double.parseDouble(j), "Fat", "T-4");
		
		dataset.addValue(Double.parseDouble(i), "Protein", "T-3");
		dataset.addValue(Double.parseDouble(h), "Carb", "T-3");
		dataset.addValue(Double.parseDouble(g), "Fat", "T-3");
       
		dataset.addValue(Double.parseDouble(f), "Protein", "T-2");
		dataset.addValue(Double.parseDouble(e), "Carb", "T-2");
		dataset.addValue(Double.parseDouble(d), "Fat", "T-2");
       
		dataset.addValue(Double.parseDouble(c), "Protein", "Yesterday");
		dataset.addValue(Double.parseDouble(b), "Carb", "Yesterday");
		dataset.addValue(Double.parseDouble(a), "Fat", "Yesterday");
       
		JFreeChart chart = ChartFactory.createBarChart(null, null, null, dataset);
        
		chart.setBackgroundPaint(null);
		chart.getLegend().setBackgroundPaint(null);
		chart.getLegend().setItemPaint(Color.GRAY);
		chart.getPlot().setBackgroundPaint(null);

		ChartPanel chartPanel = new ChartPanel(chart);
		sPanel4.add(chartPanel);
	}
	
	public void weeklyCalChart(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {
		
		double mon = Double.parseDouble(first);
		double tue = Double.parseDouble(second);
		double wed = Double.parseDouble(third);
		double thu = Double.parseDouble(fourth);
		double fri = Double.parseDouble(fifth);
		double sat = Double.parseDouble(sixth);
		double sun = Double.parseDouble(seventh);
		
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(sun, "Calorie", "T-7");
        dataset.addValue(sat, "Calorie", "T-6");
        dataset.addValue(fri, "Calorie", "T-5");
        dataset.addValue(thu, "Calorie", "T-4");
        dataset.addValue(wed, "Calorie", "T-3");
        dataset.addValue(tue, "Calorie", "T-2");
        dataset.addValue(mon, "Calorie", "Yesterday");
        
        JFreeChart chart = ChartFactory.createLineChart(null, null, null, dataset, PlotOrientation.VERTICAL, true, true, false );
        
        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        sPanel5.add(chartPanel);	
	}
}