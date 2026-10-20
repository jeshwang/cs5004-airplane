/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Creates the Passenger class.
 * Each Passenger object represents a single passenger and their information.
 */

public class Passenger{
    private final int id;
    private final String firstName;
    private final String lastName;
    private final BoardingGroup boardingGroup;
    private final SeatPosition seatPositionChoice;
    private final int seatPositionUtil; // utility experienced by the passenger IF they get their choice of seat position
    private final boolean handleExitRow;
    private int actualUtil; // actual utility experienced by the passenger once seated

    /**
     * Constructor for Passenger object
     * @param id the order of the Passenger on the list in the input csv file, can represent a unique identifier
     * @param firstName first name of the Passenger
     * @param lastName last name of the Passenger
     * @param boardingGroup the boarding group of the Passenger
     * @param seatPositionChoice the seat position chosen by the Passenger as their preferred position
     * @param seatPositionUtil the utility experienced by the Passenger if they receive their preferred seat position
     * @param handleExitRow true if Passenger has the ability to hand exit row responsibilities
     *                      if false, Passenger is barred from sitting in a seat in an exit row.
     */
    public Passenger(int id, String firstName, String lastName, BoardingGroup boardingGroup,
                     SeatPosition seatPositionChoice, int seatPositionUtil,
                     boolean handleExitRow) throws IllegalArgumentException{

        // Throw illegal argument exception if utility reported is out of the range 1-5.
        if (seatPositionUtil > 5 || seatPositionUtil < 0){
            throw new IllegalArgumentException("getSeatPositionUtil must be between 1 and 5, inclusive.");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.boardingGroup = boardingGroup;
        this.seatPositionChoice = seatPositionChoice;
        this.seatPositionUtil = seatPositionUtil;
        this.handleExitRow = handleExitRow;
        this.actualUtil = 0;
    }

    /**
     * Getter for id.
     * @return integer representing the id of the Passenger
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for firstName.
     * @return String containing the first name of the Passenger
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for lastName.
     * @return String containing the last name of the Passenger
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for boardingGroup.
     * @return String containing the boarding group of the Passenger
     */
    public BoardingGroup getBoardingGroup() {
        return boardingGroup;
    }

    /**
     * Getter for seatPositionChoice
     * This only represents the Passenger's choice, not their final assignment.
     * Positions can be aisle, middle, or window.
     * @return String containing the seat position of choice of the Passenger
     */
    public SeatPosition getSeatPositionChoice() {
        return seatPositionChoice;
    }

    /**
     * Getter for seatPositionUtil.
     * @return integer representing the utility experienced by the Passenger
     * only if they are assigned their seat of choice
     */
    public int getSeatPositionUtil() {
        return seatPositionUtil;
    }


    /**
     * Getter for handleExitRow
     * Checks whether the Passenger can handle exit row responsibilities.
     * If true, the passenger can be seated in an exit row.
     * If false, the passenger is barred from being seated in an exit row.
     * @return true if passenger can be seated in an exit row, false otherwise.
     */
    public boolean getHandleExitRow() {
        return handleExitRow;
    }

    /**
     * Getter for the actual utility of the Passenger once they are assigned a seat
     * @return utility value between 0 and 5 (inclusive).
     */
    public int getActualUtil(){
        return actualUtil;
    }

    /**
     * Setter for actual utility of the Passenger once they are assigned a seat
     * @param util utility value between 0 and 5 (inclusive).
     */
    public void setActualUtil(int util){
        this.actualUtil = util;
    }

    /**
     * Returns a string containing all the info per Passenger object
     * @return string
     */
    @Override
    public String toString(){
        return String.format("ID: %d, First Name: %s, Last Name: %s, " +
                        "Boarding Group: %s, Seat Position Choice: %s, Utility If Given Seat Position Choice: %d, " +
                        "Can Handle Exit Row: %b, Actual Utility Once Seated: %d",
                id, firstName, lastName, boardingGroup, seatPositionChoice, seatPositionUtil, handleExitRow, actualUtil);
    }

    /**
     * Checks if a Passenger object contains the same contents in its attributes
     * as another Passenger object.
     * @param o the Passenger object to be compared with
     * @return true if attributes are the same, false if not
     */
    @Override
    public boolean equals(Object o){
        // Checks if the object is compared with itself
        // If so, returns true
        if (o == this){
            return true;
        }

        // Checks if the o is an instance of Passenger
        // null instanceof [type] also returns false
        if (!(o instanceof Passenger)){
            return false;
        }

        // Typecast o to Passenger to compare data members
        Passenger s = (Passenger) o;

        // Compare the data members
        return this.getId()==s.getId() &&
                this.getFirstName().equals(s.getFirstName()) &&
                this.getLastName().equals(s.getLastName()) &&
                this.getBoardingGroup() == s.getBoardingGroup() &&
                this.getSeatPositionChoice() == s.getSeatPositionChoice() &&
                this.getSeatPositionUtil() == s.getSeatPositionUtil() &&
                this.getHandleExitRow() == s.getHandleExitRow() &&
                this.getActualUtil() == s.getActualUtil();
    }
}
