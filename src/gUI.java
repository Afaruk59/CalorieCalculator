import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class gUI {
	
	Data d= new Data();
	
	JFrame f= new JFrame("Afaruk59's Calorie Calculator ver_2.0.0");
	JPanel contentPane = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	Font title = new Font("Arial", Font.BOLD, 20);
	Font label = new Font("Arial", Font.PLAIN, 13);
	Font tab = new Font("Arial", Font.PLAIN, 13);
	
	JScrollPane scrollPane = new JScrollPane();
	JViewport vp= scrollPane.getViewport();
	JPanel panel = new JPanel();
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
	
	JPanel panel_1 = new JPanel();
	JPanel fPanelWest = new JPanel();
	JComboBox comboBox = new JComboBox();
	SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
	JSpinner spinner = new JSpinner(model);
	JLabel label15 = new JLabel("Add Food :");
	JLabel label16 = new JLabel("Amount (g) :");
	JButton btn1 = new JButton("Add");
	JButton btn2 = new JButton("Reset All Food");
	
	JPanel fPanelEast = new JPanel();
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
	JButton btn4 = new JButton("Remove All Food");
	
	JPanel panel_2 = new JPanel();
	JPanel gPanelWest= new JPanel();
	JPanel gPanelEast= new JPanel();
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
	
	JPanel panel_3 = new JPanel();
	JLabel lbl= new JLabel("Choose GUI Theme");
	JComboBox comboBox2= new JComboBox();
	JCheckBox cB= new JCheckBox("Show Welcome Screen");
	JButton btn8 = new  JButton("Reset Everything");
	
	public void gui() throws IOException {
		
		d.readFoods();
		d.readGoals();
		d.readToday();
		d.readWeeklyCal();
		d.readWeeklyMacros();
		
		//CONTENT PANE
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		f.setContentPane(contentPane);
		
		//TABBED PANE
		contentPane.add(tabbedPane);
//---------------------------------------------------------------------------------------------		
		//SUMMARY PANE
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("Summary", null, scrollPane, null);
		tabbedPane.setFont(tab);
		
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		sPanel1.setPreferredSize(new Dimension(250,341));
		panel.add(sPanel1);
		sPanel1.setLayout(null);
		sPanel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		sPanel2.setPreferredSize(new Dimension(402,341));
		panel.add(sPanel2);
		sPanel2.setLayout(new BoxLayout(sPanel2, BoxLayout.X_AXIS));
		sPanel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		sPanel3.setPreferredSize(new Dimension(400,341));
		panel.add(sPanel3);
		sPanel3.setLayout(null);
		sPanel3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		sPanel4.setPreferredSize(new Dimension(653,341));
		panel.add(sPanel4);
		sPanel4.setLayout(new BoxLayout(sPanel4, BoxLayout.X_AXIS));
		sPanel4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		sPanel5.setPreferredSize(new Dimension(653,341));
		panel.add(sPanel5);
		sPanel5.setLayout(new BoxLayout(sPanel5, BoxLayout.X_AXIS));
		sPanel5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(22, 75, 213, 25);
		label1.setFont(title);
		sPanel1.add(label1);
		
		label2.setBounds(22, 106, 100, 30);
		sPanel1.add(label2);
		label2.setFont(label);
		
		label3.setBounds(22, 148, 100, 30);
		sPanel1.add(label3);
		label3.setFont(label);
		
		label4.setBounds(22, 190, 100, 30);
		sPanel1.add(label4);
		label4.setFont(label);
		
		label5.setBounds(22, 232, 100, 30);
		sPanel1.add(label5);
		label5.setFont(label);
		
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBounds(161, 106, 100, 30);
		sPanel1.add(label6);
		label6.setText(d.today[0]);
		label6.setFont(label);
		
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setBounds(161, 148, 100, 30);
		sPanel1.add(label7);
		label7.setText(d.today[1]);
		label7.setFont(label);
		
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setBounds(161, 190, 100, 30);
		sPanel1.add(label8);
		label8.setText(d.today[2]);
		label8.setFont(label);
		
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setBounds(161, 232, 100, 30);
		sPanel1.add(label9);
		label9.setText(d.today[3]);
		label9.setFont(label);
		
		btn6.setBounds(22, 280, 200, 30);
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
				
				JOptionPane.showMessageDialog(f, "Passed the next day.", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setFont(title);
		label10.setBounds(12, 29, 376, 30);
		sPanel3.add(label10);
		
		label11.setBounds(46, 56, 70, 15);
		sPanel3.add(label11);
		label11.setFont(label);
		
		label12.setBounds(46, 130, 70, 15);
		sPanel3.add(label12);
		label12.setFont(label);
		
		label13.setBounds(46, 204, 70, 15);
		sPanel3.add(label13);
		label13.setFont(label);
		
		label14.setBounds(46, 278, 70, 15);
		sPanel3.add(label14);
		label14.setFont(label);
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(46, 83, 318, 35);
		sPanel3.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(Integer.parseInt(d.goals[1]));
		progressBar.setValue((int) Double.parseDouble(d.today[0]));
		progressBar.setFont(label);
		
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(46, 157, 318, 35);
		sPanel3.add(progressBar_1);
		progressBar_1.setMinimum(0);
		progressBar_1.setMaximum(Integer.parseInt(d.goals[2]));
		progressBar_1.setValue((int) Double.parseDouble(d.today[1]));
		progressBar_1.setFont(label);
		
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(46, 231, 318, 35);
		sPanel3.add(progressBar_2);
		progressBar_2.setMinimum(0);
		progressBar_2.setMaximum(Integer.parseInt(d.goals[3]));
		progressBar_2.setValue((int) Double.parseDouble(d.today[2]));
		progressBar_2.setFont(label);
		
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(46, 305, 318, 35);
		sPanel3.add(progressBar_3);
		progressBar_3.setMinimum(0);
		progressBar_3.setMaximum(Integer.parseInt(d.goals[0]));
		progressBar_3.setValue((int) Double.parseDouble(d.today[3]));
		progressBar_3.setFont(label);
//---------------------------------------------------------------------------------------------		
		//FOOD PANE
		tabbedPane.addTab("Food", null, panel_1, null);
		panel_1.setLayout(new BoxLayout(panel_1 , BoxLayout.X_AXIS));
		
		//WEST SIDE
		fPanelWest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		fPanelWest.setLayout(null);
		panel_1.add(fPanelWest);
		
		comboBox.setBounds(146, 65, 156, 24);
		for(int i=0; i<100; i++) {
			if(d.name[i] != null) {
				comboBox.addItem(d.name[i]);
			}
		}
		fPanelWest.add(comboBox);
		
		spinner.setBounds(146, 130, 156, 20);
		fPanelWest.add(spinner);
	
		label15.setBounds(22, 48, 177, 60);
		fPanelWest.add(label15);
		label15.setFont(label);
		
		label16.setBounds(22, 109, 177, 60);
		fPanelWest.add(label16);
		label16.setFont(label);
		
		//ADD FOOD BUTTON
		btn1.setBounds(146, 180, 156, 34);
		fPanelWest.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				double pro,carb,fat,cal;
						
				pro= Double.parseDouble(label6.getText());
				carb= Double.parseDouble(label7.getText());
				fat= Double.parseDouble(label8.getText());
				cal= Double.parseDouble(label9.getText());
						
				for(int i=0; i<100; i++) {
					if(comboBox.getSelectedItem() == d.array[i]) {
								
						pro += (Double.parseDouble(d.array[i+1]) * (int) spinner.getValue());
						carb += (Double.parseDouble(d.array[i+2]) * (int) spinner.getValue());
						fat += (Double.parseDouble(d.array[i+3]) * (int) spinner.getValue());
						cal += (Double.parseDouble(d.array[i+4]) * (int) spinner.getValue());
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
				
				JOptionPane.showMessageDialog(f, "The food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//RESET BUTTON
		btn2.setBounds(22, 235, 280, 34);
		fPanelWest.add(btn2);
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
				
				JOptionPane.showMessageDialog(f, "All meals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//EASTSIDE
		fPanelEast.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(fPanelEast);
		fPanelEast.setLayout(null);
		
		label22.setHorizontalAlignment(SwingConstants.CENTER);
		label22.setFont(title);
		label22.setBounds(70, 51, 192, 20);
		fPanelEast.add(label22);
		
		label17.setBounds(20, 96, 120, 20);
		fPanelEast.add(label17);
		label17.setFont(label);
		
		label18.setBounds(20, 127, 120, 20);
		fPanelEast.add(label18);
		label18.setFont(label);
		
		label19.setBounds(20, 158, 120, 20);
		fPanelEast.add(label19);
		label19.setFont(label);
		
		label20.setBounds(20, 189, 120, 20);
		fPanelEast.add(label20);
		label20.setFont(label);
		
		label21.setBounds(20, 220, 120, 20);
		fPanelEast.add(label21);
		label21.setFont(label);
		
		//NEW FOOD NAME
		textField.setBounds(175, 96, 120, 25);
		fPanelEast.add(textField);
		
		//NEW FOOD PROTEIN
		textField_1.setBounds(175, 127, 120, 25);
		textField_1.setText("0");
		fPanelEast.add(textField_1);
		textField_1.setColumns(10);
		
		//NEW FOOD CARB
		textField_2.setBounds(175, 158, 120, 25);
		textField_2.setText("0");
		fPanelEast.add(textField_2);
		textField_2.setColumns(10);
		
		//NEW FOOD FAT
		textField_3.setBounds(175, 189, 120, 25);
		textField_3.setText("0");
		fPanelEast.add(textField_3);
		textField_3.setColumns(10);
		
		//NEW FOOD CALORIE
		textField_4.setBounds(175, 220, 120, 25);
		textField_4.setText("0");
		fPanelEast.add(textField_4);
		textField_4.setColumns(10);
		
		//ADD NEW BUTTON
		btn3.setBounds(60, 260, 200, 30);
		fPanelEast.add(btn3);
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
					JOptionPane.showMessageDialog(f, "The new food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//REMOVE ALL BUTTON
		btn4.setBounds(60, 300, 200, 30);
		fPanelEast.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				for(int i=0; i<1000; i++) {
					d.array[i] = null;
				}
				for(int i=0; i<100; i++) {
					d.name[i] = null;
				}
				try {
					d.removeFoods();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(f, "All meals have been removed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
//---------------------------------------------------------------------------------------------
		//GOALS PANE
		tabbedPane.addTab("Goals", null, panel_2, null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		//WEST SIDE
		gPanelWest.setPreferredSize(new Dimension(700,341));
		gPanelWest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		gPanelWest.setLayout(null);
		panel_2.add(gPanelWest);
		
		label27.setHorizontalAlignment(SwingConstants.CENTER);
		label27.setFont(title);
		label27.setBounds(30, 56, 195, 24);
		gPanelWest.add(label27);
		
		label23.setHorizontalAlignment(SwingConstants.CENTER);
		label23.setBounds(10, 99, 89, 20);
		gPanelWest.add(label23);
		label23.setFont(label);
		
		label24.setHorizontalAlignment(SwingConstants.CENTER);
		label24.setBounds(10, 163, 89, 20);
		gPanelWest.add(label24);
		label24.setFont(label);
		
		label25.setHorizontalAlignment(SwingConstants.CENTER);
		label25.setBounds(10, 195, 89, 20);
		gPanelWest.add(label25);
		label25.setFont(label);
		
		label26.setHorizontalAlignment(SwingConstants.CENTER);
		label26.setBounds(10, 130, 89, 20);
		gPanelWest.add(label26);
		label26.setFont(label);
		
		label28.setHorizontalAlignment(SwingConstants.CENTER);
		label28.setBounds(20, 330, 89, 20);
		gPanelWest.add(label28);
		label28.setFont(new Font("Arial" , Font.BOLD , 18));
		
		label29.setHorizontalAlignment(SwingConstants.CENTER);
		label29.setBounds(145, 330, 89, 20);
		gPanelWest.add(label29);
		label29.setFont(new Font("Arial" , Font.BOLD , 18));
		label29.setText(d.goals[0]);
		
		textField_5.setBounds(130, 96, 120, 25);
		textField_5.setText("0");
		gPanelWest.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6.setBounds(130, 127, 120, 25);
		textField_6.setText("0");
		gPanelWest.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7.setBounds(130, 160, 120, 25);
		textField_7.setText("0");
		gPanelWest.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8.setBounds(130, 192, 120, 25);
		textField_8.setText("0");
		gPanelWest.add(textField_8);
		textField_8.setColumns(10);
		
		btn5.setBounds(130,230,119,27);
		gPanelWest.add(btn5);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int calgoal, progoal, carbgoal, fatgoal;
				
				calgoal= Integer.parseInt(textField_5.getText());
				progoal= Integer.parseInt(textField_6.getText());
				carbgoal= Integer.parseInt(textField_7.getText());
				fatgoal= Integer.parseInt(textField_8.getText());
				
				gPanelEast.removeAll();
				
				try {
					d.writeGoals(Integer.toString(calgoal), Integer.toString(progoal), Integer.toString(carbgoal), Integer.toString(fatgoal));
					gPieChart(d.goals[1], d.goals[2], d.goals[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					d.readGoals();
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
				JOptionPane.showMessageDialog(f, "Goals have been set.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn7.setBounds(130,268,119,27);
		gPanelWest.add(btn7);
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				progressBar.setMaximum(0);
				progressBar_1.setMaximum(0);
				progressBar_2.setMaximum(0);
				progressBar_3.setMaximum(0);
				
				gPanelEast.removeAll();
				
				try {
					d.writeGoals("0", "0", "0", "0");
					gPieChart(d.goals[1], d.goals[2], d.goals[3]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				label29.setText(d.goals[0]);
				JOptionPane.showMessageDialog(f, "Goals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		//EAST SIDE
		panel_2.add(gPanelEast);
		gPanelEast.setLayout(new BoxLayout(gPanelEast, BoxLayout.X_AXIS));
		gPanelEast.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
//---------------------------------------------------------------------------------------------
		//SETTINGS PANE
		tabbedPane.addTab("Settings", null, panel_3, null);
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setLayout(null);
		
		lbl.setBounds(20,20,150,30);
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
			            SwingUtilities.updateComponentTreeUI(f);
			            d.writeThemeSetting(0);
			        } catch( Exception ex ) {
			            System.err.println( "Failed to initialize LaF" );
			        }
				}
				else if(comboBox2.getSelectedIndex()==1) {
					try {
			            UIManager.setLookAndFeel( new FlatDarkLaf() );
			            SwingUtilities.updateComponentTreeUI(f);
			            d.writeThemeSetting(1);
			        } catch( Exception ex ) {
			            System.err.println( "Failed to initialize LaF" );
			        }
				}
			}
        });
        comboBox2.setBounds(20,60,300,30);
        panel_3.add(comboBox2);
        try {
			comboBox2.setSelectedIndex(d.readThemeSetting());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        /*cB.setBounds(20,110,500,30);
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
        });*/
        
        btn8.setBounds(20,160,300,30);
        SwingUtilities.updateComponentTreeUI(btn8);
        panel_3.add(btn8);
        btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(f, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						d.writeGoals("0", "0", "0", "0");
						d.writeToday("0", "0", "0", "0");
						d.removeFoods();
						d.removeWeeklyCal();
						d.resetSettings();
						d.removeWeeklyMacros();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(f, "Everything have been reset.\nYou need to reopen the program.", "Information", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
        });
        
		//FRAME		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(620, 300, 680, 465);
		f.setResizable(false);
		f.setVisible(true);
		
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
	}
	
	public void welcomeFrame() throws InterruptedException {
		
		JFrame tf= new JFrame("Welcome");
		JButton btn= new JButton("OK");
		btn.setBounds(300, 400, 150, 30);
		tf.add(btn);
        SwingUtilities.updateComponentTreeUI(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setVisible(false);
			}
		});
		
        tf.setBounds(580, 280, 750, 500);
        tf.setLayout(null);
		tf.setResizable(true);
		
		Thread.sleep(1200);
		tf.setVisible(true);
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

            JFreeChart chart = ChartFactory.createPieChart("Today", dataset, true, true, false);
            
            chart.setBackgroundPaint(null);
            chart.getLegend().setBackgroundPaint(null);
            chart.getTitle().setFont(title);
            chart.getLegend().setItemPaint(Color.GRAY);
            chart.getTitle().setPaint(Color.GRAY);
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

        JFreeChart chart = ChartFactory.createPieChart("Goals", dataset, true, true, false);

        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getTitle().setFont(title);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getTitle().setPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        
        gPanelEast.add(chartPanel);
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
       
       JFreeChart chart = ChartFactory.createBarChart("Past Week Macros", null, null, dataset);
        
       chart.setBackgroundPaint(null);
       chart.getLegend().setBackgroundPaint(null);
       chart.getTitle().setFont(title);
       chart.getLegend().setItemPaint(Color.GRAY);
       chart.getTitle().setPaint(Color.GRAY);
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
        
        JFreeChart chart = ChartFactory.createLineChart("Past Week Calories", null, null, dataset, PlotOrientation.VERTICAL, true, true, false );
        
        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getTitle().setFont(title);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getTitle().setPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);
      
        ChartPanel chartPanel = new ChartPanel(chart);
        
        sPanel5.add(chartPanel);	
	}
}
