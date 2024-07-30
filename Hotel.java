import java.util.ArrayList;

/**
 * The Hotel class represents a hotel with a name, rooms, and reservations.
 * It provides methods to manage the hotel's rooms and reservations, as well as
 * to get information about the hotel's earnings and availability.
 */
public class Hotel {

    private String hotelName;
    private int numRoom = 0;
    private ArrayList<Room> rooms;
    private double basePrice = 1299.0;
    private double[] dateModifier;
    private ArrayList<Reservation> reservations;
    private int numReservations = 0;

    /**
     * Constructs a new Hotel with the specified name and initial number of rooms.
     *
     * @param name the name of the hotel
     * @param initialNumRoom the initial number of rooms in the hotel
     */
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

    /**
     * Changes the name of the hotel.
     *
     * @param newName the new name of the hotel
     */
    public void changeHotelName(String newName) {
        this.hotelName = newName;
    }

    /**
     * Adds a reservation to the hotel.
     *
     * @param reservation the reservation to add
     */
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        this.numReservations++;
    }

    /**
     * Initializes the rooms in the hotel.
     *
     * @param initialNumRoom the initial number of rooms to add
     * @param rooms the list of rooms to initialize
     */
    public void initializeRooms(int initialNumRoom, ArrayList<Room> rooms) {
        for (int i = 0; i < initialNumRoom; i++) {
            rooms.add(new Room("Room " + (i + 1)));
        }
    }

    /**
     * Adds a room to the hotel with the specified name.
     *
     * @param roomName the name of the room to add
     * @return true if the room was added, false if the maximum number of rooms has been reached
     */
    public boolean addRoom(String roomName) {
        if (rooms.size() < 50) {
            this.rooms.add(new Room(roomName));
            this.numRoom++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a room to the hotel with the specified name and type.
     *
     * @param roomName the name of the room to add
     * @param roomType the type of the room to add
     * @return true if the room was added, false if the maximum number of rooms has been reached
     */
    public boolean addRoom(String roomName, String roomType) {
        if (rooms.size() < 50) {
            this.rooms.add(new Room(roomName, roomType));
            this.numRoom++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a room from the hotel with the specified name if it is completely available.
     *
     * @param roomName the name of the room to remove
     * @return true if the room was removed, false otherwise
     */
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

    /**
     * Removes a reservation from the hotel with the specified guest name.
     *
     * @param guestName the name of the guest whose reservation is to be removed
     */
    public void removeReservation(String guestName) {
        Reservation reservationToRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guestName)) {
                reservationToRemove = reservation;
                break;
            }
        }
        if (reservationToRemove != null) {
            for (int i = reservationToRemove.getCheckInDate() - 1; i < reservationToRemove.getCheckOutDate() - 1; i++) {
                reservationToRemove.getRoom().setAvailability(i, true);
            }
            reservations.remove(reservationToRemove);
            numReservations--;
        }
    }

    /**
     * Gets the name of the hotel.
     *
     * @return the name of the hotel
     */
    public String getHotelName() {
        return this.hotelName;
    }

    /**
     * Gets the list of reservations in the hotel.
     *
     * @return the list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    /**
     * Gets the number of rooms in the hotel.
     *
     * @return the number of rooms
     */
    public int getHotelRoomNum() {
        return this.numRoom;
    }

    /**
     * Changes the base price of the hotel rooms.
     *
     * @param newPrice the new base price
     */
    public void changePrice(double newPrice) {
        basePrice = newPrice;
    }

    /**
     * Gets the estimated earnings from all reservations in the hotel.
     *
     * @return the estimated earnings
     */
    public double getEstimatedEarnings() {
        double estimatedEarnings = 0;
        for (Reservation reservation : reservations) {
            estimatedEarnings += reservation.getReservationPrice();
        }
        return estimatedEarnings;
    }

    /**
     * Gets the list of rooms in the hotel.
     *
     * @return the list of rooms
     */
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    /**
     * Gets the base price of the hotel rooms.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Changes the date modifier for a specific day.
     *
     * @param dayIndex the index of the day (1-based)
     * @param multiplier the new multiplier for the date
     */
    public void changeDateModifier(int dayIndex, double multiplier) {
        this.dateModifier[dayIndex - 1] = multiplier;
    }

    /**
     * Gets the date modifiers for the hotel.
     *
     * @return the array of date modifiers
     */
    public double[] getDateModifier() {
        return this.dateModifier;
    }

    /**
     * Gets the number of reservations in the hotel.
     *
     * @return the number of reservations
     */
    public int getNumReservation() {
        return this.numReservations;
    }

    /**
     * Gets the number of available rooms for a specific day.
     *
     * @param day the day to check availability for
     * @return the number of available rooms
     */
    public int getAvailableRooms(int day) {
        int availableRooms = 0;
        for (Room room : rooms) {
            if (room.isAvailable(day)) {
                availableRooms++;
            }
        }
        return availableRooms;
    }

    /**
     * Gets the number of booked rooms for a specific day.
     *
     * @param day the day to check bookings for
     * @return the number of booked rooms
     */
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
