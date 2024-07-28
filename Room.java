import java.util.Arrays;

public class Room {
    private String name;
    private boolean[] availability;
    private RoomType type;
    private double roomRate;

    enum RoomType {
        STANDARD,
        DELUXE,
        EXECUTIVE
    }

    public Room(String name){
        this.type = RoomType.STANDARD;
        this.roomRate = 1;
        this.name = name;
        this.availability = new boolean[31]; //availability for all 31 days of the month
        Arrays.fill(this.availability, true);
    }
    
    public Room(String name, RoomType newType) {
    	this.type = newType;
        this.name = name;
        this.availability = new boolean[31]; //availability for all 31 days of the month
        Arrays.fill(this.availability, true);
        
        switch (type) {
        case DELUXE:
            this.roomRate = 1.2;
        case EXECUTIVE:
            this.roomRate = 1.35;
        case STANDARD:
        default:
            this.roomRate = 1;
        }
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

    public RoomType getType() {
    	return this.type;
    }
    
    public void setType(RoomType type) {
    	this.type = type;
    }
    
    public double getRoomRate() {
    	return this.roomRate;
    }
    
    
}
