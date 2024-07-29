import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame implements ActionListener {

	JButton btn1;
	JButton btn2;
	CardLayout cardlayout;
	JPanel rootPanel;
	JPanel panelOne;
	JPanel panelTwo;
	
	
	CardLayoutTest() {
		
		 	super("CardLayout Example"); // Set the title of the JFrame
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(720, 480); // Set the initial size of the JFrame
	        

	        // Initialize the CardLayout and JPanel
	        cardlayout = new CardLayout();
	        rootPanel = new JPanel(cardlayout);

	        // Create buttons and register action listeners
	        btn1 = new JButton("Show Panel One");
	        btn2 = new JButton("Show Panel Two");
	        btn1.addActionListener(this);
	        btn2.addActionListener(this);

	        // Create Panel One
	        panelOne = new JPanel();
	        panelOne.setBackground(Color.CYAN);
	        panelOne.add(new JLabel("This is Panel One"));

	        // Create Panel Two
	        panelTwo = new JPanel();
	        panelTwo.setBackground(Color.MAGENTA);
	        panelTwo.add(new JLabel("This is Panel Two"));

	        // Add panels to rootPanel with identifiers
	        rootPanel.add(panelOne, "Panel One");
	        rootPanel.add(panelTwo, "Panel Two");

	        // Set up the content pane with buttons and the rootPanel
	        getContentPane().setLayout(new BorderLayout());
	        getContentPane().add(rootPanel, BorderLayout.CENTER);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(btn1);
	        buttonPanel.add(btn2);
	        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	        // Display the JFrame
	        setLocationRelativeTo(null);
	        setVisible(true);
		
		
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == btn1) {
	            cardlayout.show(rootPanel, "Panel One");
	        } else if (e.getSource() == btn2) {
	            cardlayout.show(rootPanel, "Panel Two");
	        }
	    }
		
		
	
	
}
