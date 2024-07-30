	import java.util.Arrays;
	
	/**
	 * The Room class represents a room in a hotel, including its name, availability, type, and rate.
	 */
	public class Room {
	    private String name;
	    private boolean[] availability;
	    private String type;
	    private double roomRate;
	
	    /**
	     * Constructs a new Room with the specified name and default type STANDARD.
	     *
	     * @param name the name of the room
	     */
	    public Room(String name) {
	        this.type = "STANDARD";
	        this.roomRate = 1;
	        this.name = name;
	        this.availability = new boolean[31]; // availability for all 31 days of the month
	        Arrays.fill(this.availability, true);
	    }
	
	    /**
	     * Constructs a new Room with the specified name and type.
	     *
	     * @param name the name of the room
	     * @param newType the type of the room (STANDARD, DELUXE, or EXECUTIVE)
	     */
	    public Room(String name, String newType) {
	        this.name = name;
	        this.availability = new boolean[31]; // availability for all 31 days of the month
	        Arrays.fill(this.availability, true);
	
	        switch (newType.toUpperCase()) {
	            case "DELUXE":
	                this.type = "DELUXE";
	                this.roomRate = 1.2;
	                break;
	            case "EXECUTIVE":
	                this.type = "EXECUTIVE";
	                this.roomRate = 1.35;
	                break;
	            case "STANDARD":
	            default:
	                this.type = "STANDARD";
	                this.roomRate = 1;
	                break;
	        }
	    }
	
	    /**
	     * Sets the availability of the room for a specific day.
	     *
	     * @param day the day to set availability
	     * @param value the availability value (true for available, false for unavailable)
	     */
	    public void setAvailability(int day, boolean value) {
	        availability[day] = value;
	    }
	
	    /**
	     * Changes the availability of the room for a specific day.
	     *
	     * @param day the day to change availability
	     * @return true if the availability was successfully changed, false otherwise
	     */
	    public boolean setAvailability(int day) {
	        if (availability[day] == true) {
	            availability[day] = false;
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	    /**
	     * Updates the availability of the room for a range of dates.
	     *
	     * @param checkIn the check-in date
	     * @param checkOut the check-out date
	     */
	    public void updateAvailability(int checkIn, int checkOut) {
	        for (int i = checkIn - 1; i < checkOut - 1; i++) {
	            availability[i] = false;
	        }
	    }
	
	    /**
	     * Gets the availability of the room for all days.
	     *
	     * @return an array of booleans representing the availability of each day
	     */
	    public boolean[] getAvailability() {
	        return this.availability;
	    }
	
	    /**
	     * Gets the name of the room.
	     *
	     * @return the name of the room
	     */
	    public String getName() {
	        return this.name;
	    }
	
	    /**
	     * Gets the type of the room.
	     *
	     * @return the type of the room
	     */
	    public String getType() {
	        return this.type;
	    }
	
	    /**
	     * Gets the rate of the room based on its type.
	     *
	     * @return the rate of the room
	     */
	    public double getRoomRate() {
	        return this.roomRate;
	    }
	
	    /**
	     * Checks if the room is available on a specific day.
	     *
	     * @param day the day to check availability
	     * @return true if the room is available, false otherwise
	     */
	    public boolean isAvailable(int day) {
	        return availability[day - 1];
	    }
	
	    /**
	     * Gets the price per night for the room based on the hotel's base price.
	     *
	     * @param hotel the hotel where the room is located
	     * @return the price per night for the room
	     */
	    public double getPricePerNight(Hotel hotel) {
	        return hotel.getBasePrice() * this.getRoomRate();
	    }
	
	    /**
	     * Gets a string of available dates for the room.
	     *
	     * @return a comma-separated string of available dates
	     */
	    public String getAvailableDates() {
	        StringBuilder sb = new StringBuilder();
	
	        int counter = 0;
	
	        for (int i = 0; i < availability.length; i++) { // if all are unavailable, return none
	            if (!availability[i]) {
	                counter++;
	            }
	        }
	
	        if (counter == 30) {
	            sb.append("None");
	            return sb.toString();
	        }
	
	        for (int i = 0; i < availability.length; i++) {
	            if (availability[i]) {
	                if (sb.length() > 0) {
	                    sb.append(", ");
	                }
	                sb.append(i + 1);
	            }
	        }
	        return sb.toString();
	    }
	
	    /**
	     * Gets a string of booked dates for the room.
	     *
	     * @return a comma-separated string of booked dates
	     */
	    public String getBookedDates() {
	        StringBuilder sb = new StringBuilder();
	
	        int counter = 0;
	
	        for (int i = 0; i < availability.length; i++) { // if all are available, return none
	            if (availability[i]) {
	                counter++;
	            }
	        }
	
	        if (counter == 31) {
	            sb.append("None");
	            return sb.toString();
	        }
	
	        for (int i = 0; i < availability.length; i++) {
	            if (!availability[i]) {
	                if (sb.length() > 0) {
	                    sb.append(", ");
	                }
	                sb.append(i + 1);
	            }
	        }
	        return sb.toString();
	    }
	
	    /**
	     * Checks if the room is completely available for all days.
	     *
	     * @return true if the room is completely available, false otherwise
	     */
	    public boolean isCompletelyAvailable() {
	        for (boolean dayAvailable : availability) {
	            if (!dayAvailable) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    /**
	     * Checks if the room has any reservations.
	     *
	     * @return true if the room has reservations, false otherwise
	     */
	    public boolean hasReservation() {
	        for (boolean available : availability) {
	            if (!available) {
	                return true;
	            }
	        }
	        return false;
	    }
	}
