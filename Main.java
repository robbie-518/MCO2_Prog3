import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
			
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            new CardLayoutTest();
	        }
	    });
	
	}

}
