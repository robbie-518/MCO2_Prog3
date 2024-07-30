import java.util.Arrays;

public class Room {
    private String name;
    private boolean[] availability;
    private String type;
    private double roomRate;


    public Room(String name) {
        this.type = "STANDARD";
        this.roomRate = 1;
        this.name = name;
        this.availability = new boolean[31]; //availability for all 31 days of the month
        Arrays.fill(this.availability, true);
    }

    public Room(String name, String newType) {
        this.name = name;
        this.availability = new boolean[31]; //availability for all 31 days of the month
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
    
    public void setAvailability(int day, boolean value) {
    	availability[day] = value;
    }
    
    public boolean setAvailability(int day) { // changes date availability, returns true if successful
        if (availability[day] == true) {
            availability[day] = false;
            return true;
        }
        else {
            return false;
        }        
    }

    public void updateAvailability(int checkIn, int checkOut) {
        for (int i = checkIn-1; i < checkOut-1; i++) {
            availability[i] = false;
        }
    }


    public boolean[] getAvailability() {
        return this.availability;        
    }


    public String getName(){
        return this.name;
    }

    public String getType() {
    	return this.type;
    }
    
    public double getRoomRate() {
    	return this.roomRate;
    }
    
    public boolean isAvailable(int day) {
    	if (availability[day - 1] == true)
    		return true;
    	else
    		return false;
    }
    
    public double getPricePerNight(Hotel hotel) {
    	return hotel.getBasePrice() * this.getRoomRate();
    }
    
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
    
    public boolean isCompletelyAvailable() {
        for (boolean dayAvailable : availability) {
            if (!dayAvailable) {
                return false;
            }
        }
        return true;
    }
    
}
