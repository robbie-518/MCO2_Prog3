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
    
    public double calculateReservationPrice(Hotel hotel) { 
    	
    	double price = 0;
    	
    	for (int i = this.checkInDate; i < this.checkOutDate; i++) {
    		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
    	}
    	
    	this.reservationPrice = price;
    	return price;
    }

    public double calculateReservationPriceDISCOUNT(Hotel hotel, String code) { 
    	
    	double price = 0;
    	
    	int lengthReservation = this.checkOutDate - this.checkInDate + 1;
    	
    	
    	if (code.equals("I_WORK_HERE")) {
    		for (int i = this.checkInDate; i < this.checkOutDate; i++) {
        		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
        	}
    		price *= 0.9;
    	}
    	
    	else if (code.equals("STAY4_GET1") && lengthReservation >= 5) {    
    		for (int i = this.checkInDate + 1; i < this.checkOutDate; i++) {
        		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
        	}    		 		
    	}
    	
    	else if (code.equals("PAYDAY")) {
    		
    		if ((isDateInRange(this.checkInDate, this.checkOutDate, 15)) || (isDateInRange(this.checkInDate, this.checkOutDate, 30))) {
    			for (int i = this.checkInDate; i < this.checkOutDate; i++) {
    	    		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
    	    	}
        		price *= 0.93;    			
    		}
    		
    	}
    	
    	else {
    		for (int i = this.checkInDate; i < this.checkOutDate; i++) {
        		price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
        	}
    	}
    		
    	
    	this.reservationPrice = price;    	
    	return price;
    }
    
    public boolean isDateInRange(int checkIn, int checkOut, int day) {
        return day >= checkIn && day < checkOut;
    }
    
    public double getReservationPrice() {
    	return this.reservationPrice;
    }


}
