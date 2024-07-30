public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private double reservationPrice;

    private Room room;


    public Reservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, Room room, String discountCode) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;  
        this.reservationPrice = calculateReservationPrice(hotel);
        updateReservationPriceDISCOUNT(hotel, discountCode);
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
    

    public void updateReservationPriceDISCOUNT(Hotel hotel, String code) {  // update reservation price with discount
    	

    	
    	int lengthReservation = this.checkOutDate - this.checkInDate + 1;
    	
    	
    	if (code.equals("I_WORK_HERE")) {
    		this.reservationPrice *= 0.9;
    	}
    	
    	else if (code.equals("STAY4_GET1") && lengthReservation >= 5) {    
    		double firstDayPrice = room.getPricePerNight(hotel) * hotel.getDateModifier()[this.checkInDate - 1];
            this.reservationPrice -= firstDayPrice;
    	}
    	
    	else if (code.equals("PAYDAY")) {    		
    		if ((isDateInRange(this.checkInDate, this.checkOutDate, 15)) || (isDateInRange(this.checkInDate, this.checkOutDate, 30))) {
        		this.reservationPrice *= 0.93; 			
    		}    		
    	}    		

    }
    
    public boolean isDateInRange(int checkIn, int checkOut, int day) {
        return day >= checkIn && day < checkOut;
    }
    
    public double getReservationPrice() {
    	return this.reservationPrice;
    }
    
    public String getPricePerNight(Hotel hotel, int checkInDate, int checkOutDate) {
        StringBuilder prices = new StringBuilder();
        
        for (int i = checkInDate; i < checkOutDate; i++) {
            double price = this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
            prices.append(String.format("- Day %d: Php %.2f\n", i, price));
        }
        
        return prices.toString();
    }
    
    public String getPriceBreakdown(Hotel hotel) {
        return "Price per night:\n" + getPricePerNight(hotel, this.checkInDate, this.checkOutDate) + 
               "\nTotal nights: " + (this.checkOutDate - this.checkInDate) + 
               "\nTotal price: " + this.reservationPrice;
    }


}
