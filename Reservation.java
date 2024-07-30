/**
 * The Reservation class represents a reservation made by a guest for a specific room
 * in a hotel, including the guest's name, check-in and check-out dates, and the reservation price.
 */
public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private double reservationPrice;
    private Room room;

    /**
     * Constructs a new Reservation with the specified details.
     *
     * @param hotel the hotel where the reservation is made
     * @param guestName the name of the guest
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @param room the room reserved
     * @param discountCode the discount code applied
     */
    public Reservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, Room room, String discountCode) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;  
        this.reservationPrice = calculateReservationPrice(hotel);
        updateReservationPriceDISCOUNT(hotel, discountCode);
    }

    /**
     * Gets the check-in date of the reservation.
     *
     * @return the check-in date
     */
    public int getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Gets the check-out date of the reservation.
     *
     * @return the check-out date
     */
    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Gets the room reserved.
     *
     * @return the room reserved
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Gets the name of the guest.
     *
     * @return the guest's name
     */
    public String getGuestName() {
        return this.guestName;
    }
    
    /**
     * Calculates the total price of the reservation.
     *
     * @param hotel the hotel where the reservation is made
     * @return the total price of the reservation
     */
    public double calculateReservationPrice(Hotel hotel) {
        double price = 0;
        for (int i = this.checkInDate; i < this.checkOutDate; i++) {
            price += this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
        }
        return price;
    }

    /**
     * Updates the reservation price based on the discount code provided.
     *
     * @param hotel the hotel where the reservation is made
     * @param code the discount code applied
     */
    public void updateReservationPriceDISCOUNT(Hotel hotel, String code) {
        int lengthReservation = this.checkOutDate - this.checkInDate + 1;
        
        if (code.equals("I_WORK_HERE")) {
            this.reservationPrice *= 0.9;
        } else if (code.equals("STAY4_GET1") && lengthReservation >= 5) {    
            double firstDayPrice = room.getPricePerNight(hotel) * hotel.getDateModifier()[this.checkInDate - 1];
            this.reservationPrice -= firstDayPrice;
        } else if (code.equals("PAYDAY")) {    		
            if ((isDateInRange(this.checkInDate, this.checkOutDate, 15)) || (isDateInRange(this.checkInDate, this.checkOutDate, 30))) {
                this.reservationPrice *= 0.93; 			
            }    		
        }
    }
    
    /**
     * Checks if a specific day is within the range of the reservation dates.
     *
     * @param checkIn the check-in date
     * @param checkOut the check-out date
     * @param day the day to check
     * @return true if the day is within the range, false otherwise
     */
    public boolean isDateInRange(int checkIn, int checkOut, int day) {
        return day >= checkIn && day < checkOut;
    }

    /**
     * Gets the total price of the reservation.
     *
     * @return the total price of the reservation
     */
    public double getReservationPrice() {
        return this.reservationPrice;
    }

    /**
     * Gets the price per night for the reservation.
     *
     * @param hotel the hotel where the reservation is made
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @return a string representing the price per night
     */
    public String getPricePerNight(Hotel hotel, int checkInDate, int checkOutDate) {
        StringBuilder prices = new StringBuilder();
        for (int i = checkInDate; i < checkOutDate; i++) {
            double price = this.room.getRoomRate() * hotel.getBasePrice() * hotel.getDateModifier()[i - 1];
            prices.append(String.format("- Day %d: Php %.2f\n", i, price));
        }
        return prices.toString();
    }

    /**
     * Gets the price breakdown of the reservation.
     *
     * @param hotel the hotel where the reservation is made
     * @return a string representing the price breakdown
     */
    public String getPriceBreakdown(Hotel hotel) {
        return "Price per night:\n" + getPricePerNight(hotel, this.checkInDate, this.checkOutDate) + 
               "\nTotal nights: " + (this.checkOutDate - this.checkInDate) + 
               "\nTotal price: " + this.reservationPrice;
    }
}
