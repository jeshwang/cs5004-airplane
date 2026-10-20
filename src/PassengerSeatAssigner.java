import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the PassengerSeatAssigner class, which implements SeatAssigner interface.
 *  The PassengerSeatAssigner will:
     *  Sort a LinkedList of Passengers by their utility, and then their id
     *  Place each Passenger in an empty Seat using a greedy algorithm that maximizes the total
     *  collective utility experienced by passengers from getting (or not getting) their
     *  seat position of choice.
     *  In placing Passengers, it will take into account the Passenger's boarding group and
     *  their ability to handle exit row responsibilities as needs that must be met.
 *  Assume a full flight: no seats are left empty, and
 *  all passengers on the list make it on the plane.
 */

public class PassengerSeatAssigner implements SeatAssigner<Passenger> {

    // Lambda takes the place of a comparator here.
    private static final Comparator<Passenger> ID_COMPARATOR = (p1, p2) -> p1.getId() - p2.getId();
    private static final Comparator<Passenger> UTIL_COMPARATOR = (p1, p2) -> p2.getSeatPositionUtil() - p1.getSeatPositionUtil();

    /**
     * Assigns each passenger to a seat that matches their needs and preferences.
     * A passenger that gets assigned to their seat position of choice will have an actual utility
     * that matches the utility they reported to expect to receive.
     * A passenger that does NOT get assigned to their seat position of choice will have an actual utility
     * of zero.
     *
     * @param seats      a list of PassengerSeats
     * @param passengers a LinkedList of Passengers
     */
    public void createSeatingChart(List<Seat<Passenger>> seats, LinkedList<Passenger> passengers) {
        // Waitlist will store the list of passengers who did not get their preferred choice of seat position
        LinkedList<Passenger> waitlist = new LinkedList<>();

        // Go through every passenger in the list of passengers, and
        // either assign them to a seat if their preferred seat position is available, or
        // assign them on the waitlist
        for (Passenger p : passengers) {
            // Create a stream
            Stream<Seat<Passenger>> s = seats.stream();

            // Filter the stream to only empty seats
            s = s.filter(seat -> seat.getOccupant() == null);

            // If passenger can't handle exit row responsibilities,
            // filter the stream so only non-exit row seats are available for this passenger.
            if (!p.getHandleExitRow()) {
                s = s.filter(seat -> !seat.getIsExitRow());
            }

            s = s.filter(seat -> seat.getBoardingGroup() == p.getBoardingGroup());

            // Filter the stream to only seats with positions of this passenger's seat position of choice
            s = s.filter(seat -> seat.getSeatPosition() == p.getSeatPositionChoice());

            // Collect the stream into a new, filtered list of PassengerSeats
            List<Seat<Passenger>> filteredSeats = s.toList();

            // If the stream is empty, that means no positions of the passenger's seat position of choice are available.
            if (filteredSeats.isEmpty()) {
                waitlist.add(p); // Assign this passenger to the waitlist.
            }
            // Else, if there are still seats available, assign the passenger to the first available seat.
            else {
                for (Seat<Passenger> seat : filteredSeats) {
                    p.setActualUtil(p.getSeatPositionUtil());
                    seat.setOccupant(p);
                    break;
                }
            }
        }

        // For each passenger in the waitlist,
        // just assign them to a remaining empty seat that meets strict requirements
        // , and update the occupant in the seat.
        for (Passenger p : waitlist) {
            // Create a stream
            Stream<Seat<Passenger>> s = seats.stream();

            // Filter the stream to only empty seats
            s = s.filter(seat -> seat.getOccupant() == null);

            // If passenger can't handle exit row responsibilities,
            // filter the stream so only non-exit row seats are available for this passenger.
            if (!p.getHandleExitRow()) {
                s = s.filter(seat -> !seat.getIsExitRow());
            }

            s = s.filter(seat -> seat.getBoardingGroup() == p.getBoardingGroup());

            // Collect the stream into the list of PassengerSeats that are still empty
            List<Seat<Passenger>> filteredSeats = s.toList();

            // Assign passenger to an empty seat
            for (Seat<Passenger> seat : filteredSeats) {
                seat.setOccupant(p);
                break;
            }
        }
    }

    /**
     * Returns a String containing a formatted list of Seats,
     * each with its info and details about its occupant.
     * @param seats list of Seats containing Passenger objects
     * @return string containing information about each Seat in the list
     */
    public String displaySeats(List<Seat<Passenger>> seats) {
        StringBuilder builder = new StringBuilder();

        for (Seat<Passenger> s : seats) {
            builder.append(s.toString()).append("\n");
        }

        return builder.toString();
    }

    /**
     * Prints how many seats are taken up after the sorting algorithm is done.
     * @param seats list of Seats containing Passenger objects
     */
    public void printSeats(List<Seat<Passenger>> seats) {
        System.out.println("Total Available: " + Const.NUM_SEATS);

        // Create a stream
        Stream<Seat<Passenger>> s = seats.stream();

        // Filter the stream to occupied seats
        s = s.filter(seat -> seat.getOccupant() != null);
        List<Seat<Passenger>> seatsOccupied = s.toList();
        System.out.println("Total Seats Occupied: " + seatsOccupied.size());
    }


    /**
     * Sort a LinkedList of Passengers by their utility, and then their id
     * and return a sorted LinkedList.
     * @param unsortedPassengers LinkedList of Passengers that are not sorted
     * @return sorted LinkedList of Passengers
     */
    public LinkedList<Passenger> sortList(LinkedList<Passenger> unsortedPassengers) {
        // Create a new ArrayList
        ArrayList<Passenger> passengersArr = new ArrayList<>();

        // Create an iterator to turn the unsorted LinkedList of Passengers into
        // an ArrayList of Passengers to be sorted.
        Iterator<Passenger> it = unsortedPassengers.iterator();
        while (it.hasNext()) {
            passengersArr.add(it.next());
        }

        // Sort the ArrayList of Passengers by Seat Position Utility, then by ID.
        Collections.sort(passengersArr, UTIL_COMPARATOR.thenComparing(ID_COMPARATOR));

        // Change sorted ArrayList of Passengers back into a LinkedList
        // Create a new LinkedList containing a sorted list of Passengers
        LinkedList<Passenger> sortedPassengers = new LinkedList<>();

        // Create an iterator for the list using iterator() method
        Iterator<Passenger> itArr = passengersArr.iterator();
        while (itArr.hasNext()) {
            sortedPassengers.add(itArr.next());
        }

        return sortedPassengers;
    }
}