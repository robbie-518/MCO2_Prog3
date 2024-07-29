import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels  = new ArrayList<Hotel>();
	
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            new CardLayoutTest(hotels);
	        }
	    });
	
	}

}
