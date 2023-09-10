import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Body {
	
	static String bodyFat_;
	static String bmi_;
	static String calorie;

	public void bodyFatCalc(boolean male, boolean female, String hip, String height, String neck, String waist) {
								
		double bodyFat = 0;
		
		if(male == false && female == false) {
			JOptionPane.showMessageDialog(null, "Please select a gender.", "Gender not found", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if(height.isEmpty() ==true || neck.isEmpty() ==true || waist.isEmpty() ==true) {
				JOptionPane.showMessageDialog(null, "Please enter missing informations.", "Missing Information", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int height_ = Integer.parseInt(height);
				int neck_ = Integer.parseInt(neck);
				int waist_ = Integer.parseInt(waist);
				
				if(male == true) {
					bodyFat = (495 / (1.0324 - 0.19077 * Math.log10(waist_ - neck_) + 0.15456 * Math.log10(height_))) - 450;
				}
				else if(female == true) {
					if(hip.isEmpty() == false) {
						
						int hip_ = Integer.parseInt(hip);
						bodyFat = (495 / (1.29579 - 0.35004 * Math.log10(waist_ + hip_ - neck_) + 0.22100 * Math.log10(height_))) - 450;
					}
					else {
						JOptionPane.showMessageDialog(null, "Hip is missing.", "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		
		bodyFat_ = df.format(bodyFat);		
	}
	
	public void bmiCalc(String weight, String height) {
		
		double bmi = 0;
		
		if(weight.isEmpty() == true || height.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Please enter missing informations.", "Missing Information", JOptionPane.ERROR_MESSAGE);
		}
		else {
			int weight_ = Integer.parseInt(weight);
			int height_ = Integer.parseInt(height);
			
			bmi = weight_ / Math.pow(height_, 2);
			bmi *= 10000;
		}
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		
		bmi_ = df.format(bmi);
	}
	
	public void calorieCalc(boolean male, boolean female, String age, String weight, String height, int selectedActivity) {
		
		double bmr = 0;
		
		if(male == false && female == false) {
			JOptionPane.showMessageDialog(null, "Please select a gender.", "Gender not found", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if(age.isEmpty() ==true || weight.isEmpty() ==true || height.isEmpty() ==true) {
				JOptionPane.showMessageDialog(null, "Please enter missing informations.", "Missing Information", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int age_ = Integer.parseInt(age);
				int weight_ = Integer.parseInt(weight);
				int height_ = Integer.parseInt(height);
				
				if(male == true) {
					bmr = 88.362 + (13.397 * weight_) + (4.799 * height_) - (5.677 * age_);
				}
				else if(female == true) {
					bmr = 447.593 + (9.247 * weight_) + (3.098 * height_) - (4.330 * age_);
				}
			}
		}
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		
		if(selectedActivity == 0) {
			calorie = df.format(bmr);
		}
		else if(selectedActivity == 1) {
			bmr *= 1.2;
			calorie = df.format(bmr);
		}
		else if(selectedActivity == 2) {
			bmr *= 1.55;
			calorie = df.format(bmr);
		}
		else if(selectedActivity == 3) {
			bmr *= 1.725;
			calorie = df.format(bmr);
		}		
	}
}
