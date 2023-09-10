import java.awt.Point;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Data d= new Data();
		gUI gui= new gUI();
		
		//READ SAVED DATA
		d.readGoals();
		d.readToday();
		d.readWeeklyCal();
		d.readWeeklyMacros();
		
		//SHOW GUI
		gui.gui();
		gui.pieChart(d.today[0], d.today[1], d.today[2]);
		gui.gPieChart(d.goals[1], d.goals[2], d.goals[3]);
		gui.weeklyMacChart(d.weeklyMacros[0], d.weeklyMacros[1], d.weeklyMacros[2], d.weeklyMacros[3], d.weeklyMacros[4], d.weeklyMacros[5], 
				d.weeklyMacros[6], d.weeklyMacros[7], d.weeklyMacros[8], d.weeklyMacros[9], d.weeklyMacros[10], d.weeklyMacros[11], d.weeklyMacros[12], 
				d.weeklyMacros[13], d.weeklyMacros[14], d.weeklyMacros[15], d.weeklyMacros[16], d.weeklyMacros[17], d.weeklyMacros[18], d.weeklyMacros[19], 
				d.weeklyMacros[20]);
		gui.weeklyCalChart(d.weeklyCal[0], d.weeklyCal[1], d.weeklyCal[2], d.weeklyCal[3], d.weeklyCal[4], d.weeklyCal[5], d.weeklyCal[6]);
		
		gui.vp.setViewPosition(new Point(gui.vp.getViewPosition().x + 1, gui.vp.getViewPosition().y));
		gui.vp.setViewPosition(new Point(gui.vp.getViewPosition().x - 1, gui.vp.getViewPosition().y));
		
		/*if(gui.cB.isSelected()) {
			gui.welcomeFrame();
		}*/
	}
}