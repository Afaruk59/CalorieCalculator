import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Data data= new Data();
		data.readData();
		
		//FRAME
		JFrame f= new JFrame("Afaruk59's Calorie Calculator ver_1.0.0");
		
		//CONTENT PANE
		JPanel cPane= new JPanel(); 
		cPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		cPane.setLayout(new BoxLayout(cPane, BoxLayout.X_AXIS));
		f.setContentPane(cPane);
		
		//WEST PANEL
		JPanel pWest = new JPanel();
		pWest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cPane.add(pWest);
		pWest.setLayout(null);
		
		//SELECT FOOD
		JComboBox cb= new JComboBox();
		cb.setBounds(84, 11, 118, 22);
		for(int i=0; i<100; i++) {
			if(data.name[i] != null) {
				cb.addItem(data.name[i]);
			}
		}
		pWest.add(cb);
		
		JLabel label1 = new JLabel("Amount(g):");
		label1.setBounds(10, 47, 71, 14);
		pWest.add(label1);
		
		JLabel label2 = new JLabel("Add Food:");
		label2.setBounds(10, 15, 71, 14);
		pWest.add(label2);
		
		JLabel label3 = new JLabel("Add New Food");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label3.setBounds(10, 171, 192, 14);
		pWest.add(label3);
		
		//NEW FOOD NAME
		JTextField textField = new JTextField();
		textField.setBounds(116, 196, 86, 20);
		pWest.add(textField);
		
		
		JLabel label4 = new JLabel("Name:");
		label4.setBounds(10, 196, 96, 14);
		pWest.add(label4);
		
		JLabel label5 = new JLabel("Protein (per 1g):");
		label5.setBounds(10, 227, 96, 14);
		pWest.add(label5);
		
		JLabel label6 = new JLabel("Carb (per 1g);");
		label6.setBounds(10, 258, 96, 14);
		pWest.add(label6);
		
		JLabel label7 = new JLabel("Fat (per 1g):");
		label7.setBounds(10, 289, 96, 14);
		pWest.add(label7);
		
		JLabel label8 = new JLabel("Calorie (per 1g);");
		label8.setBounds(10, 320, 96, 14);
		pWest.add(label8);
		
		//NEW FOOD PROTEIN
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(116, 227, 86, 20);
		textField_1.setText("0");
		pWest.add(textField_1);
		textField_1.setColumns(10);
		
		//NEW FOOD CARB
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(116, 258, 86, 20);
		textField_2.setText("0");
		pWest.add(textField_2);
		textField_2.setColumns(10);
		
		//NEW FOOD FAT
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(116, 289, 86, 20);
		textField_3.setText("0");
		pWest.add(textField_3);
		textField_3.setColumns(10);
		
		//NEW FOOD CALORIE
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(116, 320, 86, 20);
		textField_4.setText("0");
		pWest.add(textField_4);
		textField_4.setColumns(10);
		
		//FOOD AMOUNT
		JTextField textField_5 = new JTextField();
		textField_5.setBounds(84, 44, 118, 20);
		textField_5.setText("1");
		pWest.add(textField_5);
		textField_5.setColumns(10);
		
		
		//CENTER PANEL
		JPanel pCenter = new JPanel();
		cPane.add(pCenter);
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		
		JPanel pUp = new JPanel();
		pUp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pCenter.add(pUp);
		pUp.setLayout(null);
		
		//SET GOALS PANEL
		JLabel label10 = new JLabel("Set Goals");
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label10.setBounds(10, 11, 195, 24);
		pUp.add(label10);
		
		JLabel label11 = new JLabel("Calorie (kJ)");
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setBounds(10, 49, 89, 14);
		pUp.add(label11);
		
		JLabel label12 = new JLabel("Carb (g)");
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setBounds(10, 113, 89, 14);
		pUp.add(label12);
		
		JLabel label13 = new JLabel("Fat (g)");
		label13.setHorizontalAlignment(SwingConstants.CENTER);
		label13.setBounds(10, 145, 89, 14);
		pUp.add(label13);
		
		JLabel label14 = new JLabel("Protein (g)");
		label14.setHorizontalAlignment(SwingConstants.CENTER);
		label14.setBounds(10, 80, 89, 14);
		pUp.add(label14);
		
		JTextField textField_6 = new JTextField();
		textField_6.setBounds(119, 46, 86, 20);
		textField_6.setText("0");
		pUp.add(textField_6);
		textField_6.setColumns(10);
		
		JTextField textField_7 = new JTextField();
		textField_7.setBounds(119, 77, 86, 20);
		textField_7.setText("0");
		pUp.add(textField_7);
		textField_7.setColumns(10);
		
		JTextField textField_8 = new JTextField();
		textField_8.setBounds(119, 110, 86, 20);
		textField_8.setText("0");
		pUp.add(textField_8);
		textField_8.setColumns(10);
		
		JTextField textField_9 = new JTextField();
		textField_9.setBounds(119, 142, 86, 20);
		textField_9.setText("0");
		pUp.add(textField_9);
		textField_9.setColumns(10);
		
		
		JPanel pDown = new JPanel();
		pDown.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pCenter.add(pDown);
		pDown.setLayout(null);
		
		//SUMMARY PANEL
		JLabel label15 = new JLabel("Summary");
		label15.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label15.setHorizontalAlignment(SwingConstants.CENTER);
		label15.setBounds(10, 11, 195, 24);
		pDown.add(label15);
		
		JLabel label16 = new JLabel("Protein");
		label16.setBounds(27, 46, 46, 14);
		pDown.add(label16);
		
		JLabel label17 = new JLabel("Carb");
		label17.setBounds(27, 71, 46, 14);
		pDown.add(label17);
		
		JLabel label18 = new JLabel("Fat");
		label18.setBounds(27, 96, 46, 14);
		pDown.add(label18);
		
		JLabel label19 = new JLabel("Cal");
		label19.setBounds(27, 121, 46, 14);
		pDown.add(label19);
		
		JLabel label20 = new JLabel("0");
		label20.setHorizontalAlignment(SwingConstants.RIGHT);
		label20.setBounds(83, 46, 46, 14);
		pDown.add(label20);
		
		JLabel label21 = new JLabel("0");
		label21.setHorizontalAlignment(SwingConstants.RIGHT);
		label21.setBounds(83, 71, 46, 14);
		pDown.add(label21);
		
		JLabel label22 = new JLabel("0");
		label22.setHorizontalAlignment(SwingConstants.RIGHT);
		label22.setBounds(83, 96, 46, 14);
		pDown.add(label22);
		
		JLabel label23 = new JLabel("0");
		label23.setHorizontalAlignment(SwingConstants.RIGHT);
		label23.setBounds(83, 121, 46, 14);
		pDown.add(label23);
		
		JLabel label24 = new JLabel("g");
		label24.setBounds(159, 46, 46, 14);
		pDown.add(label24);
		
		JLabel label25 = new JLabel("g");
		label25.setBounds(159, 71, 46, 14);
		pDown.add(label25);
		
		JLabel label26 = new JLabel("g");
		label26.setBounds(159, 96, 46, 14);
		pDown.add(label26);
		
		JLabel label27 = new JLabel("kJ");
		label27.setBounds(159, 121, 46, 14);
		pDown.add(label27);
		
		
		//EAST PANEL
		JPanel pEast = new JPanel();
		pEast.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cPane.add(pEast);
		pEast.setLayout(null);
		
		JLabel label28 = new JLabel("Goals");
		label28.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label28.setHorizontalAlignment(SwingConstants.CENTER);
		label28.setBounds(10, 53, 192, 17);
		pEast.add(label28);
		
		JLabel label29 = new JLabel("Protein");
		label29.setHorizontalAlignment(SwingConstants.CENTER);
		label29.setBounds(35, 81, 46, 14);
		pEast.add(label29);
		
		JLabel label30 = new JLabel("Carb");
		label30.setHorizontalAlignment(SwingConstants.CENTER);
		label30.setBounds(35, 129, 46, 14);
		pEast.add(label30);
		
		JLabel label31 = new JLabel("Fat");
		label31.setHorizontalAlignment(SwingConstants.CENTER);
		label31.setBounds(35, 179, 46, 14);
		pEast.add(label31);
		
		JLabel label32 = new JLabel("Calorie");
		label32.setHorizontalAlignment(SwingConstants.CENTER);
		label32.setBounds(35, 229, 46, 14);
		pEast.add(label32);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(35, 104, 146, 14);
		pEast.add(progressBar);
		progressBar.setMinimum(0);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(35, 204, 146, 14);
		pEast.add(progressBar_1);
		progressBar_1.setMinimum(0);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(35, 154, 146, 14);
		pEast.add(progressBar_2);
		progressBar_2.setMinimum(0);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(35, 254, 146, 14);
		pEast.add(progressBar_3);
		progressBar_3.setMinimum(0);
		
		//WEST PANEL BUTTONS
		JButton btn1 = new JButton("Add");
		btn1.setBounds(84, 75, 86, 23);
		pWest.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				double pro,carb,fat,cal;
						
				pro= Double.parseDouble(label20.getText());
				carb= Double.parseDouble(label21.getText());
				fat= Double.parseDouble(label22.getText());
				cal= Double.parseDouble(label23.getText());
						
				for(int i=0; i<100; i++) {
					if(cb.getSelectedItem() == data.array[i]) {
								
						pro += (Double.parseDouble(data.array[i+1]) * Double.parseDouble(textField_5.getText()));
						carb += (Double.parseDouble(data.array[i+2]) * Double.parseDouble(textField_5.getText()));
						fat += (Double.parseDouble(data.array[i+3]) * Double.parseDouble(textField_5.getText()));
						cal += (Double.parseDouble(data.array[i+4]) * Double.parseDouble(textField_5.getText()));
						break;
					}
				}
				
				progressBar.setValue((int) pro);
				progressBar_1.setValue((int) fat);
				progressBar_2.setValue((int) carb);
				progressBar_3.setValue((int) cal);
						
				label20.setText(Double.toString(pro));
				label21.setText(Double.toString(carb));
				label22.setText(Double.toString(fat));
				label23.setText(Double.toString(cal));
				
				JOptionPane.showMessageDialog(f, "The food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
						
		JButton btn2 = new JButton("Reset All Foods");
		btn2.setBounds(84, 109, 128, 23);
		pWest.add(btn2);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label20.setText("0");
				label21.setText("0");
				label22.setText("0");
				label23.setText("0");
				
				progressBar.setValue(0);
				progressBar_1.setValue(0);
				progressBar_2.setValue(0);
				progressBar_3.setValue(0);
				JOptionPane.showMessageDialog(f, "All meals have been reset.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
						
		JButton btn3 = new JButton("Add New");
		btn3.setBounds(115, 350, 86, 23);
		pWest.add(btn3);
		btn3.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String newName= textField.getText();
					String newProtein= textField_1.getText();
					String newCarb= textField_2.getText();
					String newFat= textField_3.getText();
					String newCal= textField_4.getText();
							
					data.addData(newName, newProtein, newCarb, newFat, newCal);
					cb.addItem(newName);
					JOptionPane.showMessageDialog(f, "The new food has been added.", "Successful", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
				
		JButton btn4 = new JButton("Remove All Foods");
		btn4.setBounds(10, 382, 191, 23);
		pWest.add(btn4);
		btn4.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
				cb.removeAllItems();
				for(int i=0; i<1000; i++) {
					data.array[i] = null;
				}
				for(int i=0; i<100; i++) {
					data.name[i] = null;
				}
				try {
					data.removeData();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(f, "All meals have been removed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//SET GOALS BUTTON
		JButton btn5= new JButton("Set");
		btn5.setBounds(119,170,85,23);
		pUp.add(btn5);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int calgoal, progoal, carbgoal, fatgoal;
				
				calgoal= Integer.parseInt(textField_6.getText());
				progoal= Integer.parseInt(textField_7.getText());
				carbgoal= Integer.parseInt(textField_8.getText());
				fatgoal= Integer.parseInt(textField_9.getText());
				
				progressBar.setMaximum(progoal);
				progressBar_1.setMaximum(fatgoal);
				progressBar_2.setMaximum(carbgoal);
				progressBar_3.setMaximum(calgoal);
				
				JOptionPane.showMessageDialog(f, "Goals have been set.", "Successful", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(500, 200, 680, 465);
		f.setResizable(false);
		f.setVisible(true);
		
	}

}
