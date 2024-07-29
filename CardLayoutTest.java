import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CardLayoutTest extends JFrame implements ActionListener {
	
	JButton btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	
    JButton btn1_back_fromPanelTwo, btn1_back_fromPanelThree, btn1_back_fromPanelEight, btn1_back_fromPanelNine;
    JButton btn3_back_fromPanelFour, btn3_back_fromPanelFive;
    JButton btn5_back_fromPanelSix, btn5_back_fromPanelSeven;


    CardLayout cardlayout;
    JPanel rootPanel;
    JPanel panelOne, panelTwo, panelThree, panelFour, panelFive, panelSix, panelSeven, panelEight, panelNine;
    JPanel panelNine_HotelButtons;
    
    private JLabel hotelNameLabel, totalRoomsLabel, estimatedEarningsLabel;
    
    private ArrayList<Hotel> hotels;
    
    private Hotel selectedHotel;
	
    public CardLayoutTest(ArrayList<Hotel> hotels) {
		
    	super("Hotel Reservation System"); // Set the title of the JFrame
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480); // Set the initial size of the JFrame
	        
        ImageIcon windowIcon = new ImageIcon("HRSlogo.png");
        setIconImage(windowIcon.getImage());
       
        this.hotels = hotels;
	        
	    // Initialize the CardLayout and JPanel
        cardlayout = new CardLayout();
	    rootPanel = new JPanel(cardlayout);

	    // Create buttons and register action listeners
	    btn1_back_fromPanelTwo = new JButton("Back to Main Panel"); 
	    btn1_back_fromPanelThree = new JButton("Back to Main Panel"); 
	    btn1_back_fromPanelEight = new JButton("Back to Main Panel");
	    btn1_back_fromPanelNine = new JButton("Back to Main Panel");
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
	    btn9 = new JButton("Choose Hotel");	 
	      	     
	    btn1_back_fromPanelTwo.addActionListener(this);
	    btn1_back_fromPanelThree.addActionListener(this);
	    btn1_back_fromPanelEight.addActionListener(this);
	    btn1_back_fromPanelNine.addActionListener(this);
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
	    btn9.addActionListener(this);
	        
	      
	        
	    // Create Panel One
	    JPanel panelOneButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelOneButtons.add(btn2);
	    panelOneButtons.add(btn9);
	    panelOneButtons.add(btn3);
	    panelOneButtons.add(btn8);
	        
	    panelOne = new JPanel(new BorderLayout());
	    panelOne.setBackground(Color.CYAN);
	    panelOne.add(new JLabel("This is Main Panel"), BorderLayout.NORTH);
	    panelOne.add(panelOneButtons, BorderLayout.SOUTH);
	    
	        
	        
	    // Create Panel Two
	    panelTwo = new JPanel(new BorderLayout());
	    panelTwo.setBackground(Color.MAGENTA);
	    panelTwo.add(new JLabel("Create Hotel Panel"), BorderLayout.NORTH);
	    
	    
	    // Input Panel with controlled layout and sizing
	    JPanel inputPanel = new JPanel();
	    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
	    JTextField hotelNameField = new JTextField();
	    hotelNameField.setPreferredSize(new Dimension(200, 30));
	    JTextField numRoomsField = new JTextField();
	    numRoomsField.setPreferredSize(new Dimension(200, 30));
	    inputPanel.add(new JLabel("Hotel Name:"));
	    inputPanel.add(hotelNameField);
	    inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	    inputPanel.add(new JLabel("Number of Rooms:"));
	    inputPanel.add(numRoomsField);
	    
	    // Submit button for creating the hotel
	    JButton submitButton = new JButton("Create This Hotel");
	    submitButton.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	            	
	    		String hotelName = hotelNameField.getText();
	    		String numRoomsText = numRoomsField.getText();
	    		int numRooms;
	    		
	    		// Check if either field is empty
	    		if (hotelName.isEmpty() || numRoomsText.isEmpty()) {
	    			JOptionPane.showMessageDialog(null, "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}

	    		// Validate number of rooms is an integer
	    		try {
	    			numRooms = Integer.parseInt(numRoomsText);
	    		} catch (NumberFormatException ex) {
	    			JOptionPane.showMessageDialog(null, "Please enter a valid number for rooms.", "Input Error", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}

	    		// Check for the number of rooms constraints
	    		if (numRooms < 5 || numRooms > 50) {
	    			JOptionPane.showMessageDialog(null, "Number of rooms must be between 5 and 50.", "Range Error", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}

	    		// Check if hotel name already exists
	    		boolean exists = false;
	    		for (Hotel hotel : hotels) {
	    			if (hotel.getHotelName().equals(hotelName)) {
	    				exists = true;
	    				break;
	    			}
	    		}

	    		if (exists) {
	    			JOptionPane.showMessageDialog(null, "A hotel with this name already exists.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
	    		} else {
	    			// Add the hotel if it doesn't exist
	    			Hotel newHotel = new Hotel(hotelName, numRooms);
	    			hotels.add(newHotel);
	    			addHotelButton(newHotel);
	    			hotelNameField.setText(""); // Reset the text field
	    			numRoomsField.setText(""); // Reset the text field
	    			JOptionPane.showMessageDialog(null, "Hotel has successfully been added.", "Hotel Creation", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    	}
	    });
	        
	    // button panel at the bottom
	    JPanel panelTwoButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelTwoButtons.add(submitButton);
	    panelTwoButtons.add(btn1_back_fromPanelTwo);
	    
	        
	    // Add input panel and button panel to center panel
	    JPanel centerPanel = new JPanel(new BorderLayout());
	    centerPanel.add(inputPanel, BorderLayout.NORTH);
	    centerPanel.add(panelTwoButtons, BorderLayout.SOUTH);
	    panelTwo.add(centerPanel, BorderLayout.CENTER);
	        
	    // Create Panel Three	    
	    panelThree = new JPanel(new BorderLayout());
	    panelThree.setBackground(Color.RED);
	    panelThree.add(new JLabel("This is Hotel Managing Panel"), BorderLayout.NORTH);
	   
	    
	    // button panel at the bottom
	    JPanel panelThreeButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelThreeButtons.add(btn4);
	    panelThreeButtons.add(btn5);
	    panelThreeButtons.add(btn1_back_fromPanelThree);
	    panelThree.add(panelThreeButtons, BorderLayout.SOUTH);
	        
	    // Create Panel Four
	    panelFour = new JPanel();
	    panelFour.setBackground(Color.PINK);
	    panelFour.add(new JLabel("This is Edit Hotel Panel"));
	    panelFour.add(btn3_back_fromPanelFour);
	    
	    // Create Panel Five
	    panelFive = new JPanel(new BorderLayout());
	    panelFive.setBackground(Color.YELLOW);
	    panelFive.add(new JLabel("This is View Hotel Info Panel"), BorderLayout.NORTH);
	    
	    JPanel panelFiveButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelFiveButtons.add(btn6);
	    panelFiveButtons.add(btn7);
	    panelFiveButtons.add(btn3_back_fromPanelFive);
	    panelFive.add(panelFiveButtons, BorderLayout.SOUTH);
	   
	        
	    // Create Panel Six
	    panelSix = new JPanel(new BorderLayout());
	    panelSix.setBackground(Color.ORANGE);
	    panelSix.add(new JLabel("This is Low Level Info Panel"), BorderLayout.NORTH);
	    
	    JPanel panelSixButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelSixButtons.add(btn5_back_fromPanelSix);
	    panelSix.add(panelSixButtons, BorderLayout.SOUTH);
	    
	    // Create Panel Seven
	    panelSeven = new JPanel(new BorderLayout());
	    panelSeven.setBackground(Color.GRAY);
	    panelSeven.add(new JLabel("This is High Level Info Panel"), BorderLayout.NORTH);
	    
	    // labels for high level info
	    hotelNameLabel = new JLabel();
        totalRoomsLabel = new JLabel();
        estimatedEarningsLabel = new JLabel();
        
        // panel to place the labels in
        JPanel panelSevenContent = new JPanel();
        panelSevenContent.setLayout(new BoxLayout(panelSevenContent, BoxLayout.Y_AXIS));
        panelSevenContent.add(hotelNameLabel);
        panelSevenContent.add(totalRoomsLabel);
        panelSevenContent.add(estimatedEarningsLabel);
        panelSeven.add(panelSevenContent, BorderLayout.CENTER);

	    JPanel panelSevenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelSevenButtons.add(btn5_back_fromPanelSeven);
	    panelSeven.add(panelSevenButtons, BorderLayout.SOUTH);
	    
	    // Create Panel Eight
	    panelEight = new JPanel(new BorderLayout());
	    panelEight.setBackground(Color.LIGHT_GRAY);
	    panelEight.add(new JLabel("This is Make Reservation Panel"), BorderLayout.NORTH);
	    
	    JPanel panelEightButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelEightButtons.add(btn1_back_fromPanelEight);
	    panelEight.add(panelEightButtons, BorderLayout.SOUTH);
	    
	    // Create Panel Nine
	    panelNine = new JPanel(new BorderLayout());
	    panelNine.setBackground(Color.MAGENTA);
	    panelNine.add(new JLabel("Choose a Hotel"), BorderLayout.NORTH);
	    
	    // Panel for dynamically adding hotel buttons
	    panelNine_HotelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelNine_HotelButtons.setBackground(Color.blue);
	    panelNine.add(panelNine_HotelButtons, BorderLayout.CENTER);

	    JPanel panelNineButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelNineButtons.add(btn1_back_fromPanelNine);
	    panelNine.add(panelNineButtons, BorderLayout.SOUTH);
	    
	    
	    
	        
	     
	        
	    // Add panels to rootPanel with identifiers
	    rootPanel.add(panelOne, "Panel One");
	    rootPanel.add(panelTwo, "Panel Two");
	    rootPanel.add(panelThree, "Panel Three");
	    rootPanel.add(panelFour, "Panel Four");
	    rootPanel.add(panelFive, "Panel Five");
	    rootPanel.add(panelSix, "Panel Six");
	    rootPanel.add(panelSeven, "Panel Seven");
	    rootPanel.add(panelEight, "Panel Eight");
	    rootPanel.add(panelNine, "Panel Nine");

	    // Set up the content pane with buttons and the rootPanel
	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(rootPanel, BorderLayout.CENTER);

	    // Display the JFrame
	    setLocationRelativeTo(null); 
	    setVisible(true);
	    
		
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() ==  btn1_back_fromPanelTwo || e.getSource() ==  btn1_back_fromPanelThree || e.getSource() ==  btn1_back_fromPanelEight || e.getSource() ==  btn1_back_fromPanelNine) {
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
	            if (selectedHotel == null) {
	                JOptionPane.showMessageDialog(null, "Please choose a hotel first.", "Selection Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	                cardlayout.show(rootPanel, "Panel Three");
	            }
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
	     else if (e.getSource() == btn9) {
	            cardlayout.show(rootPanel, "Panel Nine");
	        }
	    }
		
		
	 public void addHotelButton(Hotel hotel) { // method to be added into hotel creation constructor
		 JButton hotelButton = new JButton(hotel.getHotelName());
		 hotelButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 selectedHotel = hotel;
				 updateHotelInfoPanels();
				 cardlayout.show(rootPanel, "Panel One");
		      }
		 });
		 
		 panelNine_HotelButtons.add(hotelButton);
		 panelNine_HotelButtons.revalidate();
		 panelNine_HotelButtons.repaint();
		 
	 }
	 
	// Method to update panels with the selected hotel's information
	 private void updateHotelInfoPanels() {
		 if (selectedHotel != null) {
	            hotelNameLabel.setText("Hotel Name: " + selectedHotel.getHotelName());
	            totalRoomsLabel.setText("Total Rooms: " + selectedHotel.getHotelRoomNum());
	            estimatedEarningsLabel.setText("Estimated Earnings: " + selectedHotel.getEstimatedEarnings());
	        }
	 }
	
}