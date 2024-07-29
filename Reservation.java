public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private double reservationPrice;

    private Room room;


    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;  
    }

    public int getCheckInDate() {
        return this.checkInDate;
    }

    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    public Room getRoom(){
        return this.room;
    }

    public String getGuestName(){
        return this.guestName;
    }
    
    public double calculateReservationPrice(Hotel hotel) { // calculate reservation price
    	
    	double price = 0;
    	
    	for (int i = this.checkInDate; i < this.checkOutDate; i++) {
    		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
    	}
    	
    	return price;
    }
    
    public void updateReservationPrice(Hotel hotel) { // update price without discount code
    	this.reservationPrice = calculateReservationPrice(hotel);
    }

    public void updateReservationPriceDISCOUNT(Hotel hotel, String code) {  // update reservation price with discount
    	
    	double price = 0;
    	
    	int lengthReservation = this.checkOutDate - this.checkInDate + 1;
    	
    	
    	if (code.equals("I_WORK_HERE")) {
    		price = calculateReservationPrice(hotel);
    		price *= 0.9;
    	}
    	
    	else if (code.equals("STAY4_GET1") && lengthReservation >= 5) {    
    		for (int i = this.checkInDate + 1; i < this.checkOutDate; i++) {
        		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
        	}    		 		
    	}
    	
    	else if (code.equals("PAYDAY")) {    		
    		if ((isDateInRange(this.checkInDate, this.checkOutDate, 15)) || (isDateInRange(this.checkInDate, this.checkOutDate, 30))) {
    			price = calculateReservationPrice(hotel);
        		price *= 0.93;    			
    		}    		
    	}
    	
    	else {
    		price = calculateReservationPrice(hotel);
    	}
    		
    	
    	this.reservationPrice = price;
    }
    
    public boolean isDateInRange(int checkIn, int checkOut, int day) {
        return day >= checkIn && day < checkOut;
    }
    
    public double getReservationPrice() {
    	return this.reservationPrice;
    }


}
