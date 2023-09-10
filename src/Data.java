import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Data {
	
	String[] array = new String[1000];
	String[] name = new String[100];
	
	//REMOVE ALL FOODS
	public void removeData() throws IOException {
		
		File file3= new File("foods.txt");
		
		FileWriter fWrite= new FileWriter(file3, false);
		BufferedWriter bWrite= new BufferedWriter(fWrite);
		
		bWrite.write("");
		bWrite.close();
	}
	
	//READ FOODS
	public void readData() throws IOException {
		
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
	
	//ADD A FOOD
	public void addData(String newName, String newProtein, String newCarb, String newFat, String newCal) throws IOException{
		
		File file2= new File("foods.txt");
		
		FileWriter fWrite= new FileWriter(file2, false);
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

}