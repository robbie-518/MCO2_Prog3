import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class CardLayoutGUI extends JFrame implements ActionListener {
	
	JButton btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JButton btn1_back_fromPanelTwo, btn1_back_fromPanelThree, btn1_back_fromPanelEight, btn1_back_fromPanelNine;
    JButton btn3_back_fromPanelFour, btn3_back_fromPanelFive;
    JButton btn5_back_fromPanelSix, btn5_back_fromPanelSeven;

    CardLayout cardlayout;
    JPanel rootPanel;
    JPanel panelOne, panelTwo, panelThree, panelFour, panelFive, panelSix, panelSeven, panelEight, panelNine;
    JPanel panelTen, panelEleven, panelTwelve, panelThirteen, panelFourteen, panelFifteen, panelSixteen, panelSeventeen, panelEighteen;
    JPanel panelNine_HotelButtons, panelEleven_RoomButtons, panelFifteen_RoomButtons, panelThirteen_ReservationButtons, panelSixteen_ReservationButtons, panelSeventeen_DayButtons, panelEight_RoomButtons;

    private JLabel hotelNameLabel, totalRoomsLabel, estimatedEarningsLabel;
    private JLabel availableRoomsLabel, bookedRoomsLabel, roomNameLabel, roomTypeLabel;
    private JLabel dateLabel, pricePerNightLabel;
    private JLabel availableDatesLabel, bookedDatesLabel;
    private JLabel guestNameLabel, checkInLabel, checkOutLabel, totalPriceLabel, reservationRoomNameLabel;
    private JPanel priceBreakdownPanel;

    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;
    private Room selectedRoom;
    private Reservation selectedReservation;
    private int selectedDate;
	
    public CardLayoutGUI() {
		
    	super("Hotel Reservation System"); // Set the title of the JFrame
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500); // Set the initial size of the JFrame
	        
        ImageIcon windowIcon = new ImageIcon("HRSlogo.png");
        setIconImage(windowIcon.getImage());
       
        hotels = new ArrayList<>();
        
	        
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
	    btn6 = new JButton("High Level Info");
	    btn7 = new JButton("Low Level Info");
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
	    panelOne = new JPanel(new GridLayout(5, 1, 10, 10));
	    panelOne.add(new JLabel("Main Panel"));
	    panelOne.add(btn2);
	    panelOne.add(btn9);
	    panelOne.add(btn3);
	    panelOne.add(btn8);
	    
	        
	        
	    // Create Panel Two
	    panelTwo = new JPanel(new BorderLayout());
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
	    			updatePanelNine();
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
	    panelThree.add(new JLabel("This is the Hotel Managing Panel!"), BorderLayout.NORTH);
	   
	    
	    // button panel at the bottom
	    JPanel panelThreeButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelThreeButtons.add(btn4);
	    panelThreeButtons.add(btn5);
	    panelThreeButtons.add(btn1_back_fromPanelThree);
	    panelThree.add(panelThreeButtons, BorderLayout.SOUTH);
	        
	   
	    // Create Panel Four
	    panelFour = new JPanel(new GridLayout(7, 1, 10, 10));
        

        JButton changeHotelNameButton = new JButton("Change Hotel Name");
        changeHotelNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newHotelName = JOptionPane.showInputDialog("Enter new hotel name:");
                if (newHotelName != null && !newHotelName.isEmpty()) {
                    boolean exists = false;
                    for (Hotel hotel : hotels) {
                        if (hotel.getHotelName().equals(newHotelName)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        JOptionPane.showMessageDialog(null, "A hotel with this name already exists.", "Duplicate Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        selectedHotel.changeHotelName(newHotelName);
                        updateHotelInfoPanels();
                        updatePanelNine();
                        JOptionPane.showMessageDialog(null, "Hotel name changed successfully.", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedHotel.getRooms().size() >= 50) {
                    JOptionPane.showMessageDialog(null, "Cannot add more rooms. Maximum limit reached.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String roomName = JOptionPane.showInputDialog("Enter room name:");
                if (roomName != null && !roomName.isEmpty()) {
                    boolean exists = false;
                    for (Room room : selectedHotel.getRooms()) {
                        if (room.getName().equals(roomName)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        JOptionPane.showMessageDialog(null, "A room with this name already exists.", "Duplicate Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        String roomType = JOptionPane.showInputDialog("Enter room type (DELUXE, EXECUTIVE, STANDARD):")
                                .toUpperCase();
                        if (roomType.equals("DELUXE") || roomType.equals("EXECUTIVE") || roomType.equals("STANDARD")) {
                            selectedHotel.addRoom(roomName, roomType);
                            updateHotelInfoPanels();
                            JOptionPane.showMessageDialog(null, "Room added successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid room type. Please enter DELUXE, EXECUTIVE, or STANDARD.",
                                    "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        JButton removeRoomButton = new JButton("Remove Room");
        removeRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanelFifteen();
                cardlayout.show(rootPanel, "Panel Fifteen");
            }
        });

        JButton updateBasePriceButton = new JButton("Update Base Price");
        updateBasePriceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!selectedHotel.getReservations().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cannot update base price. There are existing reservations.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String newBasePriceText = JOptionPane.showInputDialog("Enter new base price:");
                try {
                    double newBasePrice = Double.parseDouble(newBasePriceText);
                    if (newBasePrice >= 100) {
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to update the base price to Php " + newBasePrice + "?",
                                "Confirm Update", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            selectedHotel.changePrice(newBasePrice);
                            updateHotelInfoPanels();
                            JOptionPane.showMessageDialog(null, "Base price updated successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Base price must be greater than or equal to Php 100.", "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the base price.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton removeReservationButton = new JButton("Remove Reservation");
        removeReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanelSixteen();
                cardlayout.show(rootPanel, "Panel Sixteen");
            }
        });

        JButton datePriceModifierButton = new JButton("Date Price Modifier");
        datePriceModifierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanelSeventeen();
                cardlayout.show(rootPanel, "Panel Seventeen");
            }
        });

        JButton backToViewHotelButton = new JButton("Back to View Hotel");
        backToViewHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Three");
            }
        });

        panelFour.add(changeHotelNameButton);
        panelFour.add(addRoomButton);
        panelFour.add(removeRoomButton);
        panelFour.add(updateBasePriceButton);
        panelFour.add(datePriceModifierButton);
        panelFour.add(removeReservationButton);
        panelFour.add(backToViewHotelButton);
	    
	    
	    // Create Panel Five
	    panelFive = new JPanel(new BorderLayout());
	    panelFive.add(new JLabel("This is the View Hotel Info Panel!"), BorderLayout.NORTH);
	    
	    JPanel panelFiveButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelFiveButtons.add(btn6);
	    panelFiveButtons.add(btn7);
	    panelFiveButtons.add(btn3_back_fromPanelFive);
	    panelFive.add(panelFiveButtons, BorderLayout.SOUTH);
	   
	        
	    // Create Panel Six
	    panelSix = new JPanel(new BorderLayout());
        panelSix.add(new JLabel("This is the High Level Info Panel!"), BorderLayout.NORTH);

        // labels to be added to panelSixContent
        hotelNameLabel = new JLabel();
        totalRoomsLabel = new JLabel();
        estimatedEarningsLabel = new JLabel();

        // panel containing all the labels
        JPanel panelSixContent = new JPanel();
        panelSixContent.setLayout(new BoxLayout(panelSixContent, BoxLayout.Y_AXIS));
        panelSixContent.add(hotelNameLabel);
        panelSixContent.add(totalRoomsLabel);
        panelSixContent.add(estimatedEarningsLabel);
        panelSix.add(panelSixContent, BorderLayout.CENTER);

        JPanel panelSixButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSixButtons.add(btn5_back_fromPanelSix);
        panelSix.add(panelSixButtons, BorderLayout.SOUTH);
	    
	    // Create Panel Seven
	    panelSeven = new JPanel(new BorderLayout());
	    panelSeven.add(new JLabel("This is the Low Level Info Panel!"), BorderLayout.NORTH);
	    
        
        // buttons for panel seven
        JButton chooseDateButton = new JButton("Choose Date");
        JButton chooseRoomButton = new JButton("Choose Room");
        JButton chooseReservationButton = new JButton("Choose Reservation");
        
        // panel to place the labels in
        JPanel panelSevenContent = new JPanel();
        panelSevenContent.setLayout(new BoxLayout(panelSevenContent, BoxLayout.Y_AXIS));
        panelSeven.add(panelSevenContent, BorderLayout.CENTER);
        
        chooseDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter a date (1-31):");
                try {
                    int date = Integer.parseInt(input);
                    if (date < 1 || date > 31) {
                        throw new NumberFormatException();
                    }
                    selectedDate = date;
                    updatePanelTen();
                    cardlayout.show(rootPanel, "Panel Ten");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid date between 1 and 31.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        chooseRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanelEleven();
                cardlayout.show(rootPanel, "Panel Eleven");
            }
        });

        chooseReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanelThirteen();
                cardlayout.show(rootPanel, "Panel Thirteen");
            }
        });

        JPanel panelSevenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSevenButtons.add(chooseDateButton);
        panelSevenButtons.add(chooseRoomButton);
        panelSevenButtons.add(chooseReservationButton);
        panelSevenButtons.add(btn5_back_fromPanelSeven);
        panelSeven.add(panelSevenButtons, BorderLayout.SOUTH);
	    
        // Create Panel Eight
        panelEight = new JPanel(new BorderLayout());
        panelEight.add(new JLabel("This is the Make a Reservation Panel!"), BorderLayout.NORTH);

        panelEight_RoomButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelEight.add(panelEight_RoomButtons, BorderLayout.CENTER);

        JPanel panelEightButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelEightButtons.add(btn1_back_fromPanelEight);
        panelEight.add(panelEightButtons, BorderLayout.SOUTH);
	    
	    // Create Panel Nine
	    panelNine = new JPanel(new BorderLayout());
	    panelNine.add(new JLabel("Choose a Hotel"), BorderLayout.NORTH);
	    
	    // Panel for dynamically adding hotel buttons
	    panelNine_HotelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelNine.add(panelNine_HotelButtons, BorderLayout.CENTER);

	    JPanel panelNineButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    panelNineButtons.add(btn1_back_fromPanelNine);
	    panelNine.add(panelNineButtons, BorderLayout.SOUTH);
	    
	    
	    // Create Panel Ten
        panelTen = new JPanel(new BorderLayout());
        dateLabel = new JLabel();
        availableRoomsLabel = new JLabel();
        bookedRoomsLabel = new JLabel();

        JPanel panelTenContent = new JPanel();
        panelTenContent.setLayout(new BoxLayout(panelTenContent, BoxLayout.Y_AXIS));
        panelTenContent.add(dateLabel);
        panelTenContent.add(availableRoomsLabel);
        panelTenContent.add(bookedRoomsLabel);
        panelTen.add(panelTenContent, BorderLayout.CENTER);

        JButton btn_back_fromPanelTen = new JButton("Back to High Level Info");
        btn_back_fromPanelTen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Seven");
            }
        });
        
        JPanel panelTenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTenButtons.add(btn_back_fromPanelTen);
        panelTen.add(panelTenButtons, BorderLayout.SOUTH);
	    
	    
	    // Create Panel Eleven
        panelEleven = new JPanel(new BorderLayout());

        panelEleven_RoomButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelEleven.add(panelEleven_RoomButtons, BorderLayout.CENTER);

        JButton btn_back_fromPanelEleven = new JButton("Back to High Level Info");
        btn_back_fromPanelEleven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Seven");
            }
        });
	    
        JPanel panelElevenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelElevenButtons.add(btn_back_fromPanelEleven);
        panelEleven.add(panelElevenButtons, BorderLayout.SOUTH);
	       
        
        
        
        // Create Panel Twelve
        panelTwelve = new JPanel(new BorderLayout());

        roomNameLabel = new JLabel();
        roomTypeLabel = new JLabel();
        availableDatesLabel = new JLabel();
        bookedDatesLabel = new JLabel();
        pricePerNightLabel = new JLabel();

        JPanel panelTwelveContent = new JPanel();
        panelTwelveContent.setLayout(new BoxLayout(panelTwelveContent, BoxLayout.Y_AXIS));
        panelTwelveContent.add(roomNameLabel);
        panelTwelveContent.add(roomTypeLabel);
        panelTwelveContent.add(pricePerNightLabel);
        panelTwelveContent.add(availableDatesLabel);
        panelTwelveContent.add(bookedDatesLabel);
        panelTwelve.add(panelTwelveContent, BorderLayout.CENTER);

        JButton btn_back_fromPanelTwelve = new JButton("Back to Room Selection");
        btn_back_fromPanelTwelve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Eleven");
            }
        });

        JPanel panelTwelveButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTwelveButtons.add(btn_back_fromPanelTwelve);
        panelTwelve.add(panelTwelveButtons, BorderLayout.SOUTH);

        
        
        // Create Panel Thirteen
        panelThirteen = new JPanel(new BorderLayout());

        panelThirteen_ReservationButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelThirteen.add(panelThirteen_ReservationButtons, BorderLayout.CENTER);

        JButton btn_back_fromPanelThirteen = new JButton("Back to High Level Info");
        btn_back_fromPanelThirteen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Seven");
            }
        });

        JPanel panelThirteenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelThirteenButtons.add(btn_back_fromPanelThirteen);
        panelThirteen.add(panelThirteenButtons, BorderLayout.SOUTH);
        
        
        
        // Create Panel Fourteen
        panelFourteen = new JPanel(new BorderLayout());

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        guestNameLabel = new JLabel();
        reservationRoomNameLabel = new JLabel();
        checkInLabel = new JLabel();
        checkOutLabel = new JLabel();
        totalPriceLabel = new JLabel();

        detailsPanel.add(guestNameLabel);
        detailsPanel.add(reservationRoomNameLabel);
        detailsPanel.add(checkInLabel);
        detailsPanel.add(checkOutLabel);
        detailsPanel.add(totalPriceLabel);

        JLabel breakdownHeader = new JLabel("Breakdown of Price Per Day:");
        detailsPanel.add(breakdownHeader);

        priceBreakdownPanel = new JPanel();
        priceBreakdownPanel.setLayout(new BoxLayout(priceBreakdownPanel, BoxLayout.Y_AXIS));

        detailsPanel.add(priceBreakdownPanel);

        panelFourteen.add(detailsPanel, BorderLayout.CENTER);

        JButton btn_back_fromPanelFourteen = new JButton("Back to Reservation Selection");
        btn_back_fromPanelFourteen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Thirteen");
            }
        });

        JPanel panelFourteenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelFourteenButtons.add(btn_back_fromPanelFourteen);
        panelFourteen.add(panelFourteenButtons, BorderLayout.SOUTH);
        
        
        // Create Panel Fifteen
        panelFifteen = new JPanel(new BorderLayout());

        panelFifteen_RoomButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelFifteen.add(panelFifteen_RoomButtons, BorderLayout.CENTER);

        JButton btn_back_fromPanelFifteen = new JButton("Back to Edit Hotel");
        btn_back_fromPanelFifteen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Four");
            }
        });

        JPanel panelFifteenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelFifteenButtons.add(btn_back_fromPanelFifteen);
        panelFifteen.add(panelFifteenButtons, BorderLayout.SOUTH);

        // Create Panel Sixteen
        panelSixteen = new JPanel(new BorderLayout());

        panelSixteen_ReservationButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSixteen.add(panelSixteen_ReservationButtons, BorderLayout.CENTER);

        JButton btn_back_fromPanelSixteen = new JButton("Back to Edit Hotel");
        btn_back_fromPanelSixteen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Four");
            }
        });

        JPanel panelSixteenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSixteenButtons.add(btn_back_fromPanelSixteen);
        panelSixteen.add(panelSixteenButtons, BorderLayout.SOUTH);
        
        
        // Create Panel Seventeen
        panelSeventeen = new JPanel(new BorderLayout());

        panelSeventeen_DayButtons = new JPanel(new GridLayout(5, 7, 5, 5));
        panelSeventeen.add(panelSeventeen_DayButtons, BorderLayout.CENTER);

        JButton btn_back_fromPanelSeventeen = new JButton("Back to Edit Hotel");
        btn_back_fromPanelSeventeen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel Four");
            }
        });

        JPanel panelSeventeenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSeventeenButtons.add(btn_back_fromPanelSeventeen);
        panelSeventeen.add(panelSeventeenButtons, BorderLayout.SOUTH);
        
        
        // Create Panel Eighteen
        panelEighteen = new JPanel(new BorderLayout());
        panelEighteen.add(new JLabel("Make Reservation Panel"), BorderLayout.NORTH);

        // Input Panel with controlled layout and sizing
        JPanel panelEighteenContent = new JPanel();
        panelEighteenContent.setLayout(new BoxLayout(panelEighteenContent, BoxLayout.Y_AXIS));
        JTextField guestNameField = new JTextField();
        guestNameField.setPreferredSize(new Dimension(200, 30));
        JTextField checkInField = new JTextField();
        checkInField.setPreferredSize(new Dimension(200, 30));
        JTextField checkOutField = new JTextField();
        checkOutField.setPreferredSize(new Dimension(200, 30));

        panelEighteenContent.add(new JLabel("Guest Name:"));
        panelEighteenContent.add(guestNameField);
        panelEighteenContent.add(Box.createRigidArea(new Dimension(0, 10)));
        panelEighteenContent.add(new JLabel("Check-In Date (1-30):"));
        panelEighteenContent.add(checkInField);
        panelEighteenContent.add(Box.createRigidArea(new Dimension(0, 10)));
        panelEighteenContent.add(new JLabel("Check-Out Date (2-31):"));
        panelEighteenContent.add(checkOutField);

        // Submit button for creating the reservation
        JButton createReservationButton = new JButton("Create Reservation");
        createReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String guestName = guestNameField.getText();
                String checkInText = checkInField.getText();
                String checkOutText = checkOutField.getText();
                String discountCode;
                
                if (guestName.isEmpty() || checkInText.isEmpty() || checkOutText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int checkIn = Integer.parseInt(checkInText);
                    int checkOut = Integer.parseInt(checkOutText);

                    if (checkIn < 1 || checkIn > 30 || checkOut <= checkIn || checkOut > 31) {
                        JOptionPane.showMessageDialog(null, "Invalid check-in or check-out date.", "Date Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean available = true;
                    for (int i = checkIn - 1; i < checkOut - 1; i++) {
                        if (!selectedRoom.getAvailability()[i]) {
                            available = false;
                            break;
                        }
                    }

                    if (!available) {
                        JOptionPane.showMessageDialog(null, "Room is not available for the selected dates.", "Availability Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String discountCodeInput = JOptionPane.showInputDialog("Enter discount code (or type 'NONE' if you don't have any):");
                    
                    if (discountCodeInput == null) {
                        // If the user cancels the input dialog, do nothing
                        return;
                    }
                    
                    if (discountCodeInput.equals("I_WORK_HERE") || discountCodeInput.equals("STAY4_GET1") || discountCodeInput.equals("PAYDAY")) {
                        discountCode = discountCodeInput;
                    } else if (discountCodeInput.equalsIgnoreCase("NONE")) {
                        discountCode = "NONE";
                    } else {
                        JOptionPane.showMessageDialog(null, "Code is invalid. Type 'NONE' if you don't have any.", "Invalid Code", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int confirm = JOptionPane.showConfirmDialog(null, "Create reservation for " + guestName + " from day " + checkIn + " to day " + checkOut + "?", "Confirm Reservation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Reservation newReservation = new Reservation(selectedHotel, guestName, checkIn, checkOut, selectedRoom, discountCode);
                        selectedHotel.addReservation(newReservation);
                        for (int i = checkIn - 1; i < checkOut - 1; i++) {
                            selectedRoom.setAvailability(i, false);
                        }
                        updatePanelThirteen();
                        updatePanelSixteen();
                        updateHotelInfoPanels();
                        guestNameField.setText("");
                        checkInField.setText("");
                        checkOutField.setText("");
                        JOptionPane.showMessageDialog(null, "Reservation created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for check-in and check-out dates.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // button panel at the bottom
        JButton btn_back_fromPanelEighteen = new JButton("Back to Main Panel");
        btn_back_fromPanelEighteen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(rootPanel, "Panel One");
            }
        });


        JPanel panelEighteenButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelEighteenButtons.add(createReservationButton);
        panelEighteenButtons.add(btn_back_fromPanelEighteen);

        // Add input panel and button panel to center panel
        JPanel centerPanelEighteen = new JPanel(new BorderLayout());
        centerPanelEighteen.add(panelEighteenContent, BorderLayout.NORTH);
        centerPanelEighteen.add(panelEighteenButtons, BorderLayout.SOUTH);
        panelEighteen.add(centerPanelEighteen, BorderLayout.CENTER);
        
	        
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
        rootPanel.add(panelTen, "Panel Ten");
        rootPanel.add(panelEleven, "Panel Eleven");
        rootPanel.add(panelTwelve, "Panel Twelve");
        rootPanel.add(panelThirteen, "Panel Thirteen");
        rootPanel.add(panelFourteen, "Panel Fourteen");
        rootPanel.add(panelFifteen, "Panel Fifteen");
        rootPanel.add(panelSixteen, "Panel Sixteen");
        rootPanel.add(panelSeventeen, "Panel Seventeen");
        rootPanel.add(panelEighteen, "Panel Eighteen");

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
	    	 if (selectedHotel == null) {
	                JOptionPane.showMessageDialog(null, "Please choose a hotel first.", "Selection Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	            	updatePanelEight();
		            cardlayout.show(rootPanel, "Panel Eight");
	            }
	    	 	
	        }
	     else if (e.getSource() == btn9) {
	    	 if (hotels.isEmpty()) {
	    		 JOptionPane.showMessageDialog(null, "There are currently no hotels.", "Selection Error", JOptionPane.ERROR_MESSAGE);
	    	 } else {
	    		 updatePanelNine();
	    		 cardlayout.show(rootPanel, "Panel Nine"); 
	    	 }
	    	 	
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
	 
	 private void updatePanelTen() {
	        if (selectedHotel != null) {
	            dateLabel.setText("Selected Date: Day " + selectedDate);
	            availableRoomsLabel.setText("Available Rooms: " + selectedHotel.getAvailableRooms(selectedDate));
	            bookedRoomsLabel.setText("Booked Rooms: " + selectedHotel.getBookedRooms(selectedDate));
	        }
	    }
	 
	 private void updatePanelEleven() {
	        panelEleven_RoomButtons.removeAll();
	        if (selectedHotel != null) {
	            for (Room room : selectedHotel.getRooms()) {
	                JButton roomButton = new JButton(room.getName());
	                roomButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        selectedRoom = room;
	                        updatePanelTwelve();
	                        cardlayout.show(rootPanel, "Panel Twelve");
	                    }
	                });
	                panelEleven_RoomButtons.add(roomButton);
	            }
	        }
	        panelEleven_RoomButtons.revalidate();
	        panelEleven_RoomButtons.repaint();
	    }
	 
	 private void updatePanelTwelve() {
	        if (selectedRoom != null) {
	            roomNameLabel.setText("Room Name: " + selectedRoom.getName());
	            roomTypeLabel.setText("Room Type: "+ selectedRoom.getType());
	            pricePerNightLabel.setText(String.format("Base Price Per Night: Php %.2f", selectedRoom.getPricePerNight(selectedHotel)));
	            availableDatesLabel.setText("Available Dates: " + selectedRoom.getAvailableDates());
	            bookedDatesLabel.setText("Booked Dates: " + selectedRoom.getBookedDates());
	        }
	    }
	 
	 private void updatePanelThirteen() {
	        panelThirteen_ReservationButtons.removeAll();
	        if (selectedHotel != null) {
	            for (Reservation reservation : selectedHotel.getReservations()) {
	                JButton reservationButton = new JButton(reservation.getGuestName());
	                reservationButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        selectedReservation = reservation;
	                        updatePanelFourteen();
	                        cardlayout.show(rootPanel, "Panel Fourteen");
	                    }
	                });
	                panelThirteen_ReservationButtons.add(reservationButton);
	            }
	        }
	        panelThirteen_ReservationButtons.revalidate();
	        panelThirteen_ReservationButtons.repaint();
	    }
	 
	 private void updatePanelFourteen() {
		    if (selectedReservation != null) {
		        guestNameLabel.setText("Guest Name: " + selectedReservation.getGuestName());
		        reservationRoomNameLabel.setText("Room Name: " + selectedReservation.getRoom().getName());
		        checkInLabel.setText("Check-in day: " + selectedReservation.getCheckInDate());
		        checkOutLabel.setText("Check-out day: " + selectedReservation.getCheckOutDate());
		        totalPriceLabel.setText(String.format("Total Price: Php %.2f", selectedReservation.getReservationPrice()));

		        priceBreakdownPanel.removeAll();
		        String[] priceBreakdown = selectedReservation.getPricePerNight(selectedHotel, selectedReservation.getCheckInDate(), selectedReservation.getCheckOutDate()).split("\n");
		        for (String line : priceBreakdown) {
		            JLabel priceLabel = new JLabel(line);
		            priceBreakdownPanel.add(priceLabel);
		        }

		        priceBreakdownPanel.revalidate();
		        priceBreakdownPanel.repaint();
		    }
		}

	 
	 private void updatePanelFifteen() {
	        panelFifteen_RoomButtons.removeAll();
	        if (selectedHotel != null) {
	            for (Room room : selectedHotel.getRooms()) {
	                JButton roomButton = new JButton(room.getName());
	                roomButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        int confirm = JOptionPane.showConfirmDialog(null,
	                                "Are you sure you want to delete the room: " + room.getName() + "?", "Confirm Deletion",
	                                JOptionPane.YES_NO_OPTION);
	                        if (confirm == JOptionPane.YES_OPTION) {
	                            if (selectedHotel.getRooms().size() > 5) {
	                                selectedHotel.removeRoom(room.getName());
	                                updateHotelInfoPanels();
	                                cardlayout.show(rootPanel, "Panel Four");
	                                JOptionPane.showMessageDialog(null, "Room deleted successfully.", "Success",
	                                        JOptionPane.INFORMATION_MESSAGE);
	                            } else {
	                                JOptionPane.showMessageDialog(null, "Cannot delete room. Minimum room limit reached.",
	                                        "Error", JOptionPane.ERROR_MESSAGE);
	                            }
	                        } else {
	                            cardlayout.show(rootPanel, "Panel Four");
	                        }
	                    }
	                });
	                panelFifteen_RoomButtons.add(roomButton);
	            }
	        }
	        panelFifteen_RoomButtons.revalidate();
	        panelFifteen_RoomButtons.repaint();
	    }

	 private void updatePanelSixteen() {
		    panelSixteen_ReservationButtons.removeAll();
		    if (selectedHotel != null) {
		        for (Reservation reservation : selectedHotel.getReservations()) {
		            JButton reservationButton = new JButton(reservation.getGuestName());
		            reservationButton.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    int confirm = JOptionPane.showConfirmDialog(null,
		                            "Are you sure you want to delete the reservation for: " + reservation.getGuestName() + "?",
		                            "Confirm Deletion", JOptionPane.YES_NO_OPTION);
		                    if (confirm == JOptionPane.YES_OPTION) {
		                        selectedHotel.removeReservation(reservation.getGuestName());
		                        updatePanelSixteen(); // Refresh the panel after deletion
		                        updateHotelInfoPanels(); 
		                        JOptionPane.showMessageDialog(null, "Reservation deleted successfully.", "Success",
		                                JOptionPane.INFORMATION_MESSAGE);
		                    } else {
		                        cardlayout.show(rootPanel, "Panel Four");
		                    }
		                }
		            });
		            panelSixteen_ReservationButtons.add(reservationButton);
		        }
		    }
		    panelSixteen_ReservationButtons.revalidate();
		    panelSixteen_ReservationButtons.repaint();
		}

	 
	 private void updatePanelEight() {
	        panelEight_RoomButtons.removeAll();
	        if (selectedHotel != null) {
	            for (Room room : selectedHotel.getRooms()) {
	                JButton roomButton = new JButton(room.getName());
	                roomButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        selectedRoom = room;
	                        cardlayout.show(rootPanel, "Panel Eighteen");
	                    }
	                });
	                panelEight_RoomButtons.add(roomButton);
	            }
	        }
	        panelEight_RoomButtons.revalidate();
	        panelEight_RoomButtons.repaint();
	    }
	    
	    private void updatePanelNine() {
	        panelNine_HotelButtons.removeAll();
	        for (Hotel hotel : hotels) {
	            JButton hotelButton = new JButton(hotel.getHotelName());
	            hotelButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    selectedHotel = hotel;
	                    updateHotelInfoPanels();
	                    cardlayout.show(rootPanel, "Panel One");
	                }
	            });
	            panelNine_HotelButtons.add(hotelButton);
	        }
	        panelNine_HotelButtons.revalidate();
	        panelNine_HotelButtons.repaint();
	    }
	    
	    private void updatePanelSeventeen() {
	        panelSeventeen_DayButtons.removeAll();
	        for (int i = 1; i <= 31; i++) {
	            int day = i;
	            JButton dayButton = new JButton("Day " + day + ": " + (int)(selectedHotel.getDateModifier()[day - 1] * 100) + "%");
	            dayButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    String newMultiplierText = JOptionPane.showInputDialog("Enter new price multiplier percentage for Day " + day + ":");
	                    try {
	                        double newMultiplier = Double.parseDouble(newMultiplierText) / 100;
	                        int confirm = JOptionPane.showConfirmDialog(null,
	                                "Are you sure you want to change the price multiplier for Day " + day + " to " + (newMultiplier * 100) + "%?",
	                                "Confirm Update", JOptionPane.YES_NO_OPTION);
	                        if (confirm == JOptionPane.YES_OPTION) {
	                            selectedHotel.changeDateModifier(day, newMultiplier);
	                            dayButton.setText("Day " + day + ": " + (int)(newMultiplier * 100) + "%");
	                            JOptionPane.showMessageDialog(null, "Price multiplier for Day " + day + " changed successfully.", "Success",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                        }
	                    } catch (NumberFormatException ex) {
	                        JOptionPane.showMessageDialog(null, "Please enter a valid number for the price multiplier.", "Input Error",
	                                JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            });
	            panelSeventeen_DayButtons.add(dayButton);
	        }
	        panelSeventeen_DayButtons.revalidate();
	        panelSeventeen_DayButtons.repaint();
	    }
	    
	    
	    
	 
	    // Method to update panels with the selected hotel's high level info
	    private void updateHotelInfoPanels() {
	        if (selectedHotel != null) {
	            hotelNameLabel.setText("Hotel Name: " + selectedHotel.getHotelName());
	            totalRoomsLabel.setText("Total Rooms: " + selectedHotel.getHotelRoomNum());
	            estimatedEarningsLabel.setText(String.format("Estimated Earnings: Php %.2f", selectedHotel.getEstimatedEarnings()));
	        }
	    }
	
}