import java.util.List;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the SeatAssigner interface that assigns generic objects
 *  to Seats.
 */
public interface SeatAssigner <P> {

    /**
     * Assigns each object of a generic type to a Seat
     * by matching the generic object's attributes to those of the Seat.
     * @param seats a list of Seats containing occupants of a generic type
     * @param passengers a LinkedList of generic type
     */
    public void createSeatingChart(List<Seat<P>> seats, LinkedList<P> passengers);

    /**
     * Returns a String containing a formatted list of Seats,
     * each with its info and details about its occupant.
     * @param seats list of Seats containing generic objects as its occupants
     * @return string containing information about each Seat in the list
     */
    public String displaySeats(List<Seat<P>> seats);

    /**
     * Returns a LinkedList of generics objects that are sorted by certain criteria
     * @param unsortedPassengers LinkedList of generics that are unsorted
     * @return LinkedList of generics that are sorted by certain criteria
     */
    public LinkedList<P> sortList(LinkedList<P> unsortedPassengers);
}
