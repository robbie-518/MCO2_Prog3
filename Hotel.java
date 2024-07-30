import java.util.ArrayList;

public class Hotel {

    private String hotelName;
    private int numRoom = 0;
    private ArrayList<Room> rooms;
    private double basePrice = 1299.0;
    private double[] dateModifier;

    private ArrayList<Reservation> reservations;
    private int numReservations = 0;



    public Hotel(String name, int initialNumRoom) { 
        this.hotelName = name;
        this.rooms = new ArrayList<Room>();
        initializeRooms(initialNumRoom, rooms);
        this.reservations = new ArrayList<Reservation>();
        this.numRoom += initialNumRoom;
        
        dateModifier = new double[31];
        
        for (int i = 0; i < dateModifier.length; i++) {
            dateModifier[i] = 1.0;
        } 
    }

    public void changeHotelName(String newName){
        this.hotelName = newName;
    }


    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        this.numReservations++;
    }

    public void initializeRooms(int initialNumRoom, ArrayList<Room> rooms) {
        for (int i = 0; i < initialNumRoom; i++) {
            rooms.add(new Room("Room " + (i + 1)));
        }
    }

    
    public boolean addRoom(String roomName) {
        if (rooms.size() < 50) {
            this.rooms.add(new Room(roomName));
            this.numRoom++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addRoom(String roomName, String roomType) {
        if (rooms.size() < 50) {
            this.rooms.add(new Room(roomName, roomType));
            this.numRoom++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeRoom(String roomName) {
        Room roomToRemove = null;
        for (Room room : rooms) {
            if (room.getName().equals(roomName) && room.isCompletelyAvailable()) {
                roomToRemove = room;
                break;
            }
        }
        if (roomToRemove != null && rooms.size() > 5) {
            rooms.remove(roomToRemove);
            numRoom--;
            return true;
        }
        return false;
    }
    

    public void removeReservation(String guestName) {
        Reservation reservationToRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guestName)) {
                reservationToRemove = reservation;
                break;
            }
        }
        if (reservationToRemove != null) {
            reservations.remove(reservationToRemove);
            numReservations--;
        }
    }

    public String getHotelName(){
        return this.hotelName;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public int getHotelRoomNum(){
        return this.numRoom;
    }

    public void changePrice(double newPrice) {
        basePrice = newPrice;
    }

   
    public double getEstimatedEarnings() {    
    	
    	double estimatedEarnings = 0;        	
    	
        for (Reservation reservation : this.reservations) {
        	   	estimatedEarnings += reservation.getReservationPrice();
        }
        
		return estimatedEarnings;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public double getBasePrice(){
        return basePrice;
    }
    
    public void changeDateModifier(int dayIndex, double multiplier) {
    	this.dateModifier[dayIndex - 1] = multiplier / 100;
    }
    
    public double[] getDateModifier() {
    	return this.dateModifier;
    }
    
    
    public int getNumReservation() {
    	return this.numReservations;
    }
    
    public int getAvailableRooms(int day) {
        int availableRooms = 0;
        for (Room room : rooms) {
            if (room.isAvailable(day)) {
                availableRooms++;
            }
        }
        return availableRooms;
    }
    
    public int getBookedRooms(int day) {
        int bookedRooms = 0;
        for (Room room : rooms) {
            if (!room.isAvailable(day)) {
                bookedRooms++;
            }
        }
        return bookedRooms;
    }



}
