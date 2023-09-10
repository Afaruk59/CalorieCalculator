import java.awt.FlowLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DateAndTime extends gUI{

	static JLabel time = new JLabel("");
	static String day;
	static String month;
	static String year;
	
	public void getTime() throws InterruptedException, IOException {
				
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		datePanel.setBounds(410,8,300,40);
		mainFrame.add(datePanel);
		
		datePanel.add(time);
		time.setFont(labelFont);
		
		SwingUtilities.updateComponentTreeUI(time);
		
        while (true) {
        	
            LocalDateTime currentDate = LocalDateTime.now(); 
            
            if(Data.profile.getProperty("lang").equals("eng") == true) {
            	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("|   dd/MM/yyyy EEEE HH:mm:ss");
            	String saat = currentDate.format(timeFormat); 
            	time.setText(saat);
            	datePanel.setBounds(385,8,300,40);
            }
            else if(Data.profile.getProperty("lang").equals("tr") == true) {
            	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("|   dd/MM/yyyy EEEE HH:mm:ss", new Locale("tr"));
            	String saat = currentDate.format(timeFormat); 
            	time.setText(saat);
            	datePanel.setBounds(415,8,300,40);
            }
            
        	DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd");
        	day = currentDate.format(dayFormat); 
        	Data.profile.setProperty("day", day);
        	
        	DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MM");
        	month = currentDate.format(monthFormat); 
        	Data.profile.setProperty("month", month);
        	
        	DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");
        	year = currentDate.format(yearFormat); 
        	Data.profile.setProperty("year", year);
        	
    		FileOutputStream output = new FileOutputStream("users\\" + User.userName + "\\profile.acc");
    		Data.profile.store(output, "PROFILE#");
    		output.close();
            
            Thread.sleep(1000);
        }
	}
}