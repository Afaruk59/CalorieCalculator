import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Data {
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	String[] addedMeals = new String[1000];
	String[] defaultFoods = new String[1000];
	String[] name = new String[100];
	String[] goals = new String[4];
	String[] today = new String[4];
	String[] weeklyCal = new String[7];
	String[] weeklyMacros = new String[21];
	String[][] table_1 = new String[200][5];
	String[][] table_2 = new String[200][5];
	static Properties profile = new Properties();
		
	public void addFood(String newName, String newProtein, String newCarb, String newFat, String newCal) throws IOException{
				
		File file= new File("users\\" + User.userName + "\\foods.acc");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<1000; i++) {
			if(addedMeals[i] == null) {
				addedMeals[i]= newName;
				addedMeals[i+1]= newProtein;
				addedMeals[i+2]= newCarb;
				addedMeals[i+3]= newFat;
				addedMeals[i+4]= newCal;
				break;
			}
		}
		
		for(int i=0; i<1000; i++) {
			String line= addedMeals[i];
			if(addedMeals[i] != null) {
				bWrite.write(line + "\n");
			}
		}
		bWrite.close();
	}
	
	public void addFavFood(String food) throws IOException {
		
		String pro = null, carb = null, fat = null, cal = null;
		for(int i=0; i<1000; i++) {
			if(defaultFoods[i] == food) {
				
				pro = defaultFoods[i+1];
				carb = defaultFoods[i+2];
				fat = defaultFoods[i+3];
				cal = defaultFoods[i+4];
				
				break;
			}
		}
		
		addFood(food, pro, carb, fat, cal);
	}
	
	public void readFoods() throws IOException {
		
		File file= new File("users\\" + User.userName + "\\foods.acc");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<1000; i++) {
			addedMeals[i]= bRead.readLine();
		}
		
		for(int i=0, j=0; i<100; i++) {
			name[i]= addedMeals[j];
			j+=5;
		}
		bRead.close();
	}
	
	public void readDefaultFoods() throws IOException {
		
		if(profile.getProperty("lang").equals("eng") == true) {
			File file= new File("resources\\defFoodsEng.acc");
			if(file.exists() == false) {
				file.createNewFile();
			}
			
			FileReader fRead= new FileReader(file);        
			BufferedReader bRead= new BufferedReader(fRead);
			
			for(int i=0; i<1000; i++) {
				defaultFoods[i]= bRead.readLine();
			}
			bRead.close();
		}
		else if(profile.getProperty("lang").equals("tr") == true) {
			File file= new File("resources\\defFoodsTr.acc");
			if(file.exists() == false) {
				file.createNewFile();
			}
			
			FileReader fRead= new FileReader(file);        
			BufferedReader bRead= new BufferedReader(fRead);
			
			for(int i=0; i<1000; i++) {
				defaultFoods[i]= bRead.readLine();
			}
			bRead.close();
		}
	}
	
	public void removeFoods() throws IOException {
		
		File file= new File("users\\" + User.userName + "\\foods.acc");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		bWrite.write("");
		bWrite.close();
	}
	
	public void resetProfile() throws IOException {
		
		profile.setProperty("Theme", "0");
		profile.setProperty("welcomeScreen", "1");
		profile.setProperty("calorieGoal", "0");
		profile.setProperty("proteinGoal", "0");
		profile.setProperty("carbGoal", "0");
		profile.setProperty("fatGoal", "0");
		profile.setProperty("proteinToday", "0");
		profile.setProperty("carbToday", "0");
		profile.setProperty("fatToday", "0");
		profile.setProperty("calorieToday", "0");
		profile.setProperty("weeklyCal_0", "0");
		profile.setProperty("weeklyCal_1", "0");
		profile.setProperty("weeklyCal_2", "0");
		profile.setProperty("weeklyCal_3", "0");
		profile.setProperty("weeklyCal_4", "0");
		profile.setProperty("weeklyCal_5", "0");
		profile.setProperty("weeklyCal_6", "0");
		profile.setProperty("weeklyMacros_0", "0");
		profile.setProperty("weeklyMacros_1", "0");
		profile.setProperty("weeklyMacros_2", "0");
		profile.setProperty("weeklyMacros_3", "0");
		profile.setProperty("weeklyMacros_4", "0");
		profile.setProperty("weeklyMacros_5", "0");
		profile.setProperty("weeklyMacros_6", "0");
		profile.setProperty("weeklyMacros_7", "0");
		profile.setProperty("weeklyMacros_8", "0");
		profile.setProperty("weeklyMacros_9", "0");
		profile.setProperty("weeklyMacros_10", "0");
		profile.setProperty("weeklyMacros_11", "0");
		profile.setProperty("weeklyMacros_12", "0");
		profile.setProperty("weeklyMacros_13", "0");
		profile.setProperty("weeklyMacros_14", "0");
		profile.setProperty("weeklyMacros_15", "0");
		profile.setProperty("weeklyMacros_16", "0");
		profile.setProperty("weeklyMacros_17", "0");
		profile.setProperty("weeklyMacros_18", "0");
		profile.setProperty("weeklyMacros_19", "0");
		profile.setProperty("weeklyMacros_20", "0");
		profile.setProperty("bodyFat", "0");
		profile.setProperty("bodyFatType", "");
		profile.setProperty("bmi", "0");
		profile.setProperty("bmiType", "");
		profile.setProperty("calorie", "0");
		profile.setProperty("lang", "eng");
		profile.setProperty("lang", "eng");
		profile.setProperty("lang", "eng");
		profile.setProperty("lang", "eng");
		
		LocalDateTime currentDate = LocalDateTime.now();
		
    	DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd");
    	profile.setProperty("day", currentDate.format(dayFormat));
    	
    	DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MM");
    	profile.setProperty("month", currentDate.format(monthFormat));
    	
    	DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");
    	profile.setProperty("year", currentDate.format(yearFormat));
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output ,"PROFILE#");
		output.close();
	}
	
	public void loadProfile() throws IOException {
		
		FileInputStream input = new FileInputStream("users\\" + User.userName + "\\profile.acc");
		profile.load(input);
		input.close();
		
		goals[0] = profile.getProperty("calorieGoal");
		goals[1] = profile.getProperty("proteinGoal");
		goals[2] = profile.getProperty("carbGoal");
		goals[3] = profile.getProperty("fatGoal");
		
		today[0] = profile.getProperty("proteinToday");
		today[1] = profile.getProperty("carbToday");
		today[2] = profile.getProperty("fatToday");
		today[3] = profile.getProperty("calorieToday");
		
		weeklyCal[0] = profile.getProperty("weeklyCal_0");
		weeklyCal[1] = profile.getProperty("weeklyCal_1");
		weeklyCal[2] = profile.getProperty("weeklyCal_2");
		weeklyCal[3] = profile.getProperty("weeklyCal_3");
		weeklyCal[4] = profile.getProperty("weeklyCal_4");
		weeklyCal[5] = profile.getProperty("weeklyCal_5");
		weeklyCal[6] = profile.getProperty("weeklyCal_6");
		
		weeklyMacros[0] = profile.getProperty("weeklyMacros_0");
		weeklyMacros[1] = profile.getProperty("weeklyMacros_1");
		weeklyMacros[2] = profile.getProperty("weeklyMacros_2");
		weeklyMacros[3] = profile.getProperty("weeklyMacros_3");
		weeklyMacros[4] = profile.getProperty("weeklyMacros_4");
		weeklyMacros[5] = profile.getProperty("weeklyMacros_5");
		weeklyMacros[6] = profile.getProperty("weeklyMacros_6");
		weeklyMacros[7] = profile.getProperty("weeklyMacros_7");
		weeklyMacros[8] = profile.getProperty("weeklyMacros_8");
		weeklyMacros[9] = profile.getProperty("weeklyMacros_9");
		weeklyMacros[10] = profile.getProperty("weeklyMacros_10");
		weeklyMacros[11] = profile.getProperty("weeklyMacros_11");
		weeklyMacros[12] = profile.getProperty("weeklyMacros_12");
		weeklyMacros[13] = profile.getProperty("weeklyMacros_13");
		weeklyMacros[14] = profile.getProperty("weeklyMacros_14");
		weeklyMacros[15] = profile.getProperty("weeklyMacros_15");
		weeklyMacros[16] = profile.getProperty("weeklyMacros_16");
		weeklyMacros[17] = profile.getProperty("weeklyMacros_17");
		weeklyMacros[18] = profile.getProperty("weeklyMacros_18");
		weeklyMacros[19] = profile.getProperty("weeklyMacros_19");
		weeklyMacros[20] = profile.getProperty("weeklyMacros_20");
	}
	
	public void writeThemeSetting(int theme) throws IOException {
		
		profile.setProperty("Theme", Integer.toString(theme));
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public int readThemeSetting() throws IOException {
		
		return Integer.parseInt(profile.getProperty("Theme"));
	}
	
	public void writeWSetting(int setting) throws IOException {
		
		profile.setProperty("welcomeScreen", Integer.toString(setting));
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public int readWSetting() throws IOException {
		
		return Integer.parseInt(profile.getProperty("welcomeScreen"));
	}
	
	public void writeLangSetting(String lang) throws IOException {
		
		profile.setProperty("lang", lang);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public int readLangSetting() {
		
		int index = 0;
		
		if(profile.getProperty("lang").equals("eng") == true) {
			index = 0;
		}
		else if(profile.getProperty("lang").equals("tr") == true) {
			index = 1;
		}
		return index;
	}
	
	public void writeBodyFatResult(String bodyFat) throws IOException {
		
		profile.setProperty("bodyFat", bodyFat);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeBodyFatResultType(String bodyFatType) throws IOException {
		
		profile.setProperty("bodyFatType", bodyFatType);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public String readBodyFatResult() {
		
		return profile.getProperty("bodyFat");
	}
	
	public String readBodyFatResultType() {
		
		return profile.getProperty("bodyFatType");
	}
	
	public void writeBmiResult(String bmi) throws IOException {
		
		profile.setProperty("bmi", bmi);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeBmiResultType(String bmiType) throws IOException {
		
		profile.setProperty("bmiType", bmiType);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public String readBmiResult() {
		
		return profile.getProperty("bmi");
	}
	
	public String readBmiResultType() {
		
		return profile.getProperty("bmiType");
	}
	
	public void writeCalorieResult(String cal) throws IOException {
		
		profile.setProperty("calorie", cal);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public String readCalorieResult() {
		
		return profile.getProperty("calorie");
	}
	
	public void writeGoals(String cal, String pro, String carb, String fat) throws IOException {
		
		goals[0] = cal;
		goals[1] = pro;
		goals[2] = carb;
		goals[3] = fat;
		
		profile.setProperty("calorieGoal", cal);
		profile.setProperty("proteinGoal", pro);
		profile.setProperty("carbGoal", carb);
		profile.setProperty("fatGoal", fat);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeToday(String pro, String carb, String fat, String cal) throws IOException {
		
		today[3] = cal;
		today[0] = pro;
		today[1] = carb;
		today[2] = fat;
		
		profile.setProperty("proteinToday", pro);
		profile.setProperty("carbToday", carb);
		profile.setProperty("fatToday", fat);
		profile.setProperty("calorieToday", cal);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeWeeklyCal(String cal) throws IOException {
		
		weeklyCal[6] = weeklyCal[5];
		weeklyCal[5] = weeklyCal[4];
		weeklyCal[4] = weeklyCal[3];
		weeklyCal[3] = weeklyCal[2];
		weeklyCal[2] = weeklyCal[1];
		weeklyCal[1] = weeklyCal[0];
		weeklyCal[0] = cal;
		
		profile.setProperty("weeklyCal_0", weeklyCal[0]);
		profile.setProperty("weeklyCal_1", weeklyCal[1]);
		profile.setProperty("weeklyCal_2", weeklyCal[2]);
		profile.setProperty("weeklyCal_3", weeklyCal[3]);
		profile.setProperty("weeklyCal_4", weeklyCal[4]);
		profile.setProperty("weeklyCal_5", weeklyCal[5]);
		profile.setProperty("weeklyCal_6", weeklyCal[6]);
		
		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeWeeklyMacros(String pro, String carb, String fat) throws IOException {
		
		weeklyMacros[20]= weeklyMacros[17];
		weeklyMacros[19]= weeklyMacros[16];
		weeklyMacros[18]= weeklyMacros[15];
		weeklyMacros[17]= weeklyMacros[14];
		weeklyMacros[16]= weeklyMacros[13];
		weeklyMacros[15]= weeklyMacros[12];
		weeklyMacros[14]= weeklyMacros[11];
		weeklyMacros[13]= weeklyMacros[10];
		weeklyMacros[12]= weeklyMacros[9];
		weeklyMacros[11]= weeklyMacros[8];
		weeklyMacros[10]= weeklyMacros[7];
		weeklyMacros[9]= weeklyMacros[6];
		weeklyMacros[8]= weeklyMacros[5];
		weeklyMacros[7]= weeklyMacros[4];
		weeklyMacros[6]= weeklyMacros[3];
		weeklyMacros[5]= weeklyMacros[2];
		weeklyMacros[4]= weeklyMacros[1];
		weeklyMacros[3]= weeklyMacros[0];
		weeklyMacros[2]= pro; weeklyMacros[1]= carb; weeklyMacros[0]= fat; 
		
		profile.setProperty("weeklyMacros_0", weeklyMacros[0]);
		profile.setProperty("weeklyMacros_1", weeklyMacros[1]);
		profile.setProperty("weeklyMacros_2", weeklyMacros[2]);
		profile.setProperty("weeklyMacros_3", weeklyMacros[3]);
		profile.setProperty("weeklyMacros_4", weeklyMacros[4]);
		profile.setProperty("weeklyMacros_5", weeklyMacros[5]);
		profile.setProperty("weeklyMacros_6", weeklyMacros[6]);
		profile.setProperty("weeklyMacros_7", weeklyMacros[7]);
		profile.setProperty("weeklyMacros_8", weeklyMacros[8]);
		profile.setProperty("weeklyMacros_9", weeklyMacros[9]);
		profile.setProperty("weeklyMacros_10", weeklyMacros[10]);
		profile.setProperty("weeklyMacros_11", weeklyMacros[11]);
		profile.setProperty("weeklyMacros_12", weeklyMacros[12]);
		profile.setProperty("weeklyMacros_13", weeklyMacros[13]);
		profile.setProperty("weeklyMacros_14", weeklyMacros[14]);
		profile.setProperty("weeklyMacros_15", weeklyMacros[15]);
		profile.setProperty("weeklyMacros_16", weeklyMacros[16]);
		profile.setProperty("weeklyMacros_17", weeklyMacros[17]);
		profile.setProperty("weeklyMacros_18", weeklyMacros[18]);
		profile.setProperty("weeklyMacros_19", weeklyMacros[19]);
		profile.setProperty("weeklyMacros_20", weeklyMacros[20]);

		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
		profile.store(output, "PROFILE#");
		output.close();
	}
	
	public void writeTable1() {
		
		int i=0, k=0;
		
		while(addedMeals[k] != null) {
			
			table_1[i][0]= addedMeals[k];
			table_1[i][1]= addedMeals[k+1];
			table_1[i][2]= addedMeals[k+2];
			table_1[i][3]= addedMeals[k+3];
			table_1[i][4]= addedMeals[k+4];
			
			k+=5;
			i+=1;
			if(k >= 1000) {
				break;
			}
		}
	}
	
	public void writeTable2() {
		
		int i=0, k=0;
		
		while(defaultFoods[k] != null) {
			
			table_2[i][0]= defaultFoods[k];
			table_2[i][1]= defaultFoods[k+1];
			table_2[i][2]= defaultFoods[k+2];
			table_2[i][3]= defaultFoods[k+3];
			table_2[i][4]= defaultFoods[k+4];
			
			k+=5;
			i+=1;
			if(k >= 1000) {
				break;
			}
		}
	}
}