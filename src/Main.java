/*
_______________                    ______ ___________________        
___    |__  __/_____ ___________  ____  /____  ____/_  __ \( )_______
__  /| |_  /_ _  __ `/_  ___/  / / /_  //_/_____ \ _  /_/ /|/__  ___/
_  ___ |  __/ / /_/ /_  /   / /_/ /_  ,<   ____/ / _\__, /   _(__  ) 
/_/  |_/_/    \__,_/ /_/    \__,_/ /_/|_| /_____/  /____/    /____/  
   
_________      ______            _____           _________      ______            ______      _____              
__  ____/_____ ___  /_______________(_)____      __  ____/_____ ___  /_________  ____  /_____ __  /______________
_  /    _  __ `/_  /_  __ \_  ___/_  /_  _ \     _  /    _  __ `/_  /_  ___/  / / /_  /_  __ `/  __/  __ \_  ___/
/ /___  / /_/ /_  / / /_/ /  /   _  / /  __/     / /___  / /_/ /_  / / /__ / /_/ /_  / / /_/ // /_ / /_/ /  /    
\____/  \__,_/ /_/  \____//_/    /_/  \___/      \____/  \__,_/ /_/  \___/ \__,_/ /_/  \__,_/ \__/ \____//_/     
                                                                                                                                                                                      
*/

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	static String version = "v3.2.2";

	public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException{
		
		User u = new User();
		gUI gui = new gUI();
		Data d = new Data();
		Language l = new Language();
		Charts c = new Charts();
		DateAndTime t = new DateAndTime();
		Ambients a = new Ambients();
		
		//STARTUP LOGO
		Startup.showWindow();
		
		//USER SCREEN
		u.userScreen();
		
		//AMBIENTS
		a.musicStarter();
		
		//LOAD SAVED DATA
		d.loadProfile();
		d.readFoods();
		d.readDefaultFoods();
		
		//LOAD LANGUAGE
		if(Data.profile.getProperty("lang").equals("eng") == true) {
			l.english();
		}
		else if(Data.profile.getProperty("lang").equals("tr") == true) {
			l.turkish();
		}
			
		//SHOW GUI
		gui.gui();
		
		//APPLY LANGUAGE
		gui.langTranslator();
		
		//CALCULATE CHARTS
		c.pieChart(d.today[0], d.today[1], d.today[2]);
		c.gPieChart(d.goals[1], d.goals[2], d.goals[3]);
		c.weeklyMacChart(d.weeklyMacros[0], d.weeklyMacros[1], d.weeklyMacros[2], d.weeklyMacros[3], d.weeklyMacros[4], d.weeklyMacros[5], 
				d.weeklyMacros[6], d.weeklyMacros[7], d.weeklyMacros[8], d.weeklyMacros[9], d.weeklyMacros[10], d.weeklyMacros[11], d.weeklyMacros[12], 
				d.weeklyMacros[13], d.weeklyMacros[14], d.weeklyMacros[15], d.weeklyMacros[16], d.weeklyMacros[17], d.weeklyMacros[18], d.weeklyMacros[19], 
				d.weeklyMacros[20]);
		c.weeklyCalChart(d.weeklyCal[0], d.weeklyCal[1], d.weeklyCal[2], d.weeklyCal[3], d.weeklyCal[4], d.weeklyCal[5], d.weeklyCal[6]);
		
		//TIME CONTROL
		gui.nextDay();
		
		SwingUtilities.updateComponentTreeUI(gui.summaryPage);
		
		//COFFEE ANIMATION
		ProfileName.coffeeAnimation();
        
        //DATE AND TIME
		t.getTime();
        
        //SHOW PROFILE NAME
        ProfileName.profileName();
                
		//SHOW WELCOME SCREEN
		if(gui.welcomeScrenCb.isSelected()) {
			WelcomeScreen.welcomeFrame();
		}
	}
}