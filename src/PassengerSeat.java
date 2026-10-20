/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the PassengerSeat class that implements the
 *  Seat interface, and holds a Passenger object.
 */
public class PassengerSeat implements Seat<Passenger>{
    private final String number;
    private final SeatPosition seatPosition;
    private final BoardingGroup boardingGroup;
    private final boolean isExitRow;
    private Passenger passenger;

    /**
     * Constructor for PassengerSeat
     * Creates a PassengerSeat that is empty (does not have a passenger).
     * @param number number of the seat, like "19B"
     * @param seatPosition position of the seat
     * @param boardingGroup what boarding group the seat belongs to
     * @param isExitRow whether the seat is in the exit row
     */
    public PassengerSeat(String number, SeatPosition seatPosition, BoardingGroup boardingGroup,
                boolean isExitRow){
        this.number = number;
        this.seatPosition = seatPosition;
        this.boardingGroup = boardingGroup;
        this.isExitRow = isExitRow;
        this.passenger = null;
    }

    /**
     * Getter for number
     * @return seat number
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * Getter for seat position
     * @return seat position
     */
    @Override
    public SeatPosition getSeatPosition() {
        return seatPosition;
    }

    /**
     * Getter for boarding group
     * @return boarding group
     */
    @Override
    public BoardingGroup getBoardingGroup() {
        return boardingGroup;
    }

    /**
     * Getter for isExitRow
     * @return whether the seat is in the exit row
     */
    @Override
    public boolean getIsExitRow() {
        return isExitRow;
    }

    /**
     * Getter for passenger
     * @return passenger object in the seat
     */
    @Override
    public Passenger getOccupant() {
        return passenger;
    }

    /**
     * Setter for passenger
     * @param p passenger to be seated in the seat
     */
    @Override
    public void setOccupant(Passenger p){
        this.passenger = p;
    }

    /**
     * Returns a string containing all the info per PassengerSeat object
     * @return string
     */
    @Override
    public String toString(){
        return String.format("Number: %s, Seat Position: %s, Boarding Group: %s, Is Exit Row: %b, Passenger: %s",
                number, seatPosition, boardingGroup, isExitRow, passenger);
    }

    /**
     * Checks if a PassengerSeat object contains the same contents in its attributes
     * as another PassengerSeat object.
     * @param o the PassengerSeat object to be compared with
     * @return true if attributes are the same, false if not
     */
    @Override
    public boolean equals(Object o){
        // Checks if the object is compared with itself
        // If so, returns true
        if (o == this){
            return true;
        }

        // Checks if the o is an instance of PassengerSeat
        // null instanceof [type] also returns false
        if (!(o instanceof PassengerSeat)){
            return false;
        }

        // Typecast o to PassengerSeat to compare data members
        PassengerSeat s = (PassengerSeat) o;

        // Compare the data members
        return this.getNumber().equals(s.getNumber()) &&
                this.getBoardingGroup() == s.getBoardingGroup() &&
                this.getSeatPosition() == s.getSeatPosition() &&
                this.getIsExitRow() == s.getIsExitRow() &&
                this.getOccupant() == s.getOccupant();
    }
}
