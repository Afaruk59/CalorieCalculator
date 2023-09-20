import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Startup {

	public static void showWindow() {
		
	    JWindow window = new JWindow();

	    ImageIcon imageIcon = new ImageIcon("resources\\img\\logo.png");

	    JLabel label = new JLabel(imageIcon);
	    window.getContentPane().add(label, BorderLayout.CENTER);

	    window.pack();
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    window.setVisible(false);
	}
}
