import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame{



    Window() {    	
        
        this.setTitle("Hotel Reservation System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(720, 480);
        this.setVisible(true);
        
        ImageIcon logo = new ImageIcon("HRSlogo.png");
        this.setIconImage(logo.getImage());               
      
     
    }

}
