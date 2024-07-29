import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame implements ActionListener {
	
	JButton btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	
    JButton btn1_back_fromPanelTwo, btn1_back_fromPanelThree, btn1_back_fromPanelEight;
    JButton btn3_back_fromPanelFour, btn3_back_fromPanelFive;
    JButton btn5_back_fromPanelSix, btn5_back_fromPanelSeven;


    CardLayout cardlayout;
    JPanel rootPanel;
    JPanel panelOne, panelTwo, panelThree, panelFour, panelFive, panelSix, panelSeven, panelEight;
	
	
	CardLayoutTest() {
		
		 	super("CardLayout Example"); // Set the title of the JFrame
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(720, 480); // Set the initial size of the JFrame
	        

	        // Initialize the CardLayout and JPanel
	        cardlayout = new CardLayout();
	        rootPanel = new JPanel(cardlayout);

	        // Create buttons and register action listeners
	        btn1_back_fromPanelTwo = new JButton("Back to Main Panel"); 
	        btn1_back_fromPanelThree = new JButton("Back to Main Panel"); 
	        btn1_back_fromPanelEight = new JButton("Back to Main Panel"); 
	        btn3_back_fromPanelFour = new JButton("Back to View Hotel"); 
	        btn3_back_fromPanelFive = new JButton("Back to View Hotel"); 
	        btn5_back_fromPanelSix = new JButton("Back to View Hotel Info"); 
	        btn5_back_fromPanelSeven = new JButton("Back to View Hotel Info"); 
	        
	        btn2 = new JButton("Create Hotel");
	        btn3 = new JButton("View Hotel");
	        btn4 = new JButton("Edit Hotel");
	        btn5 = new JButton("View Hotel Info");
	        btn6 = new JButton("Low Level Info");
	        btn7 = new JButton("High Level Info");
	        btn8 = new JButton("Make Reservation");	        
	      	     
	        btn1_back_fromPanelTwo.addActionListener(this);
	        btn1_back_fromPanelThree.addActionListener(this);
	        btn1_back_fromPanelEight.addActionListener(this);
	        btn3_back_fromPanelFour.addActionListener(this);
	        btn3_back_fromPanelFive.addActionListener(this);
	        btn5_back_fromPanelSix.addActionListener(this);
	        btn5_back_fromPanelSeven.addActionListener(this);
	     
	        
	        btn2.addActionListener(this);
	        btn3.addActionListener(this);
	        btn4.addActionListener(this);
	        btn5.addActionListener(this);
	        btn6.addActionListener(this);
	        btn7.addActionListener(this);
	        btn8.addActionListener(this);

	        // Create Panel One
	        panelOne = new JPanel();
	        panelOne.setBackground(Color.CYAN);
	        panelOne.add(new JLabel("This is Main Panel"));
	        panelOne.add(btn2);
	        panelOne.add(btn3);
	        panelOne.add(btn8);

	        // Create Panel Two
	        panelTwo = new JPanel();
	        panelTwo.setBackground(Color.MAGENTA);
	        panelTwo.add(new JLabel("This is Create Hotel Panel"));
	        panelTwo.add(btn1_back_fromPanelTwo);
	        
	        // Create Panel Three
	        panelThree = new JPanel();
	        panelThree.setBackground(Color.RED);
	        panelThree.add(new JLabel("This is View Hotel Panel"));
	        panelThree.add(btn4);
	        panelThree.add(btn5);
	        panelThree.add(btn1_back_fromPanelThree);
	        
	        // Create Panel Four
	        panelFour = new JPanel();
	        panelFour.setBackground(Color.PINK);
	        panelFour.add(new JLabel("This is Edit Hotel Panel"));
	        panelFour.add(btn3_back_fromPanelFour);
	        
	        // Create Panel Five
	        panelFive = new JPanel();
	        panelFive.setBackground(Color.YELLOW);
	        panelFive.add(new JLabel("This is View Hotel Info Panel"));
	        panelFive.add(btn6);
	        panelFive.add(btn7);
	        panelFive.add(btn3_back_fromPanelFive);
	        
	        // Create Panel Six
	        panelSix = new JPanel();
	        panelSix.setBackground(Color.ORANGE);
	        panelSix.add(new JLabel("This is Low Level Info Panel"));
	        panelSix.add(btn5_back_fromPanelSix);
	        
	        // Create Panel Seven
	        panelSeven = new JPanel();
	        panelSeven.setBackground(Color.GRAY);
	        panelSeven.add(new JLabel("This is High Level Info Panel"));
	        panelSeven.add(btn5_back_fromPanelSeven);
	        
	        // Create Panel Eight
	        panelEight = new JPanel();
	        panelEight.setBackground(Color.LIGHT_GRAY);
	        panelEight.add(new JLabel("This is Make Reservation Panel"));
	        panelEight.add(btn1_back_fromPanelEight);


	        // Add panels to rootPanel with identifiers
	        rootPanel.add(panelOne, "Panel One");
	        rootPanel.add(panelTwo, "Panel Two");
	        rootPanel.add(panelThree, "Panel Three");
	        rootPanel.add(panelFour, "Panel Four");
	        rootPanel.add(panelFive, "Panel Five");
	        rootPanel.add(panelSix, "Panel Six");
	        rootPanel.add(panelSeven, "Panel Seven");
	        rootPanel.add(panelEight, "Panel Eight");

	        // Set up the content pane with buttons and the rootPanel
	        getContentPane().setLayout(new BorderLayout());
	        getContentPane().add(rootPanel, BorderLayout.CENTER);

	        // Display the JFrame
	        setLocationRelativeTo(null); 
	        setVisible(true);
	        
		
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() ==  btn1_back_fromPanelTwo || e.getSource() ==  btn1_back_fromPanelThree || e.getSource() ==  btn1_back_fromPanelEight) {
	            cardlayout.show(rootPanel, "Panel One");
	        } 
	        else if (e.getSource() == btn3_back_fromPanelFour || e.getSource() == btn3_back_fromPanelFive) {
	            cardlayout.show(rootPanel, "Panel Three");
	        }
	        else if (e.getSource() == btn5_back_fromPanelSix || e.getSource() == btn5_back_fromPanelSeven) {
	            cardlayout.show(rootPanel, "Panel Five");
	        }
	        else if (e.getSource() == btn2) {
	            cardlayout.show(rootPanel, "Panel Two");
	        }
	        else if (e.getSource() == btn3) {
	            cardlayout.show(rootPanel, "Panel Three");
	        }
	        else if (e.getSource() == btn4) {
	            cardlayout.show(rootPanel, "Panel Four");
	        }
	        else if (e.getSource() == btn5) {
	            cardlayout.show(rootPanel, "Panel Five");
	        }
	        else if (e.getSource() == btn6) {
	            cardlayout.show(rootPanel, "Panel Six");
	        }
	        else if (e.getSource() == btn7) {
	            cardlayout.show(rootPanel, "Panel Seven");
	        }
	        else if (e.getSource() == btn8) {
	            cardlayout.show(rootPanel, "Panel Eight");
	        }
	    }
		
		
	
	
}
