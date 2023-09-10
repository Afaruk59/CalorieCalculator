import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
	
	String[] array = new String[1000];
	String[] name = new String[100];
	String[] settings = new String[5];
	String[] goals = {"0", "0", "0", "0"};
	String[] today = new String[4];
	String[] weeklyCal = new String[7];
	String[] weeklyMacros = new String[21];
	
	//ADD A FOOD
	public void addFood(String newName, String newProtein, String newCarb, String newFat, String newCal) throws IOException{
		
		File file= new File("foods.txt");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<1000; i++) {
			if(array[i] == null) {
				array[i]= newName;
				array[i+1]= newProtein;
				array[i+2]= newCarb;
				array[i+3]= newFat;
				array[i+4]= newCal;
				break;
			}
		}
		
		for(int i=0; i<1000; i++) {
			String line= array[i];
			if(array[i] != null) {
				bWrite.write(line + "\n");
			}
		}
		bWrite.close();
	}
	
	//READ FOODS
	public void readFoods() throws IOException {
		
		File file= new File("foods.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<1000; i++) {
			array[i]= bRead.readLine();
		}
		
		for(int i=0, j=0; i<100; i++) {
			name[i]= array[j];
			j+=5;
		}
	}
	
	//REMOVE ALL FOODS
	public void removeFoods() throws IOException {
		
		File file= new File("foods.txt");
		
		FileWriter fWrite= new FileWriter(file, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		bWrite.write("");
		bWrite.close();
	}
	
	public void writeThemeSetting(int theme) throws IOException {
		
		File file= new File("settings.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		String line;
		line= Integer.toString(theme);
		
		settings[0] = line;
		
		for(int i=0; i<5; i++) {
			bWrite.write(settings[i] + "\n");
		}
		bWrite.close();
	}
	
	public int readThemeSetting() throws IOException {
		
		File file= new File("settings.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<5; i++) {
			settings[i]= bRead.readLine();
		}
		
		return Integer.parseInt(settings[0]);
	}
	
	public void writeWSetting(int a) throws IOException {
		
		File file= new File("settings.txt");
		
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		String line= Integer.toString(a);
		settings[1]= line;
		
		for(int i=0; i<5; i++) {
			bWrite.write(settings[i] + "\n");
		}
		bWrite.close();
	}
	
	public int readWSetting() throws IOException {
		
		File file= new File("settings.txt");
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<5; i++) {
			settings[i]= bRead.readLine();
		}
		
		return Integer.parseInt(settings[1]);
	}
	
	public void readGoals() throws IOException {
		
		File file= new File("goals.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
			
		for(int i=0; i<4; i++) {
			goals[i] = bRead.readLine();
		}
	}
	
	public void writeGoals(String cal, String pro, String carb, String fat) throws IOException {
		
		File file= new File("goals.txt");
		
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		goals[0] = cal;
		goals[1] = pro;
		goals[2] = carb;
		goals[3] = fat;
		
		for(int i=0; i<4; i++) {
			bWrite.write(goals[i] + "\n");
		}
		bWrite.close();
	}
	
	public void readToday() throws IOException{
		
		File file= new File("today.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<4; i++) {
			today[i] = bRead.readLine();
		}
	}
	
	public void writeToday(String pro, String carb, String fat, String cal) throws IOException {
		
		File file= new File("today.txt");
		
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		today[3] = cal;
		today[0] = pro;
		today[1] = carb;
		today[2] = fat;
		
		for(int i=0; i<4; i++) {
			bWrite.write(today[i] + "\n");
		}
		bWrite.close();
	}

	public void readWeeklyCal() throws IOException {
		
		File file= new File("weeklyCal.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<7; i++) {
			weeklyCal[i] = bRead.readLine();
		}
	}
	
	public void writeWeeklyCal(String cal) throws IOException {
		
		File file= new File("weeklyCal.txt");
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		weeklyCal[6] = weeklyCal[5];
		weeklyCal[5] = weeklyCal[4];
		weeklyCal[4] = weeklyCal[3];
		weeklyCal[3] = weeklyCal[2];
		weeklyCal[2] = weeklyCal[1];
		weeklyCal[1] = weeklyCal[0];
		weeklyCal[0] = cal;
		
		for(int i=0; i<7; i++) {
			bWrite.write(weeklyCal[i] + "\n");
		}
		bWrite.close();
	}
	
	public void removeWeeklyCal() throws IOException {
		
		File file= new File("weeklyCal.txt");
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<7; i++) {
			weeklyCal[i] = "0";
		}
		
		for(int i=0; i<7; i++) {
			bWrite.write(weeklyCal[i] + "\n");
		}
		bWrite.close();
	}
	
	public void resetSettings() throws IOException {
		
		File file= new File("settings.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);

		settings[0] = "0";
		settings[1] = "1";
		
		for(int i=0; i<5; i++) {
			bWrite.write(settings[i] + "\n");
		}
		bWrite.close();
	}
	
	public void readWeeklyMacros() throws IOException {
		
		File file= new File("weeklyMacros.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileReader fRead= new FileReader(file);        
		BufferedReader bRead= new BufferedReader(fRead);
		
		for(int i=0; i<21; i++) {
			weeklyMacros[i] = bRead.readLine();
		}
	}
	
	public void writeWeeklyMacros(String pro, String carb, String fat) throws IOException {
		
		File file= new File("weeklyMacros.txt");
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
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
		
		for(int i=0; i<21; i++) {
			bWrite.write(weeklyMacros[i] + "\n");
		}
		bWrite.close();
	}
	
	public void removeWeeklyMacros() throws IOException {
		
		File file= new File("weeklyMacros.txt");
		FileWriter fWrite= new FileWriter(file);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		for(int i=0; i<21; i++) {
			weeklyMacros[i] = "0";
		}
		
		for(int i=0; i<21; i++) {
			bWrite.write(weeklyMacros[i] + "\n");
		}
		bWrite.close();
	}
}
