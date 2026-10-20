import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the Airplane class, containing a list of seats.
 */
public class Airplane {
    private List<Seat<Passenger>> seats;  // list of passenger seats

    /**
     * Constructor for Airplane
     */
    public Airplane(){
        this.seats = new ArrayList<>();
    }

    /**
     * Getter for seats
     * @return list of seats
     */
    public List<Seat<Passenger>> getSeats(){
        return seats;
    }

    /**
     * Create list of PassengerSeats sorted by their row. Within each row, they are sorted in alphabetical order (e.g., 3A, 3B, etc.)
     * Takes in the row numbers where first class begins and ends, and row numbers where economy class begins and ends
     * @return list of PassengerSeats for the entire plane.
     */
    public List<Seat<Passenger>> createSeats(int f_start, int f_end, int e_start, int e_end){

        // Stream will go through all the elements in order, and you can map, filter, or reduce on them.
        // IntStream is a shorthand for going through a list of integers to create the seat name.

        // Stream of all rows with first class seats.
            // This maps integers to rows, and then uses flatMap to create a flat list from a list of lists.
            // flatMap needs to get a stream of all the internal lists, so it calls Collection::stream.
            // For every row, call .stream on the list of seats in that row. Then flatMap appends all those
            // streams one after another.
        this.seats.addAll(IntStream.rangeClosed(f_start,f_end)
                .mapToObj(i -> createFirstClassRow(i)).flatMap(Collection::stream).toList());

        // Stream of all rows with economy seats
        List<PassengerSeat> economySeats = new ArrayList<PassengerSeat>();
        economySeats = IntStream.rangeClosed(e_start,e_end)
                .mapToObj(i -> createEconomyRow(i)).flatMap(Collection::stream).toList();

        // Add list of economy seats to the full list
        this.seats.addAll(economySeats);

        return seats;
    }

    /**
     * Helper method to create a row of PassengerSeats that are first class.
     * Note that there are only four seats per row (A, B, D, E).
     * @param i row number
     * @return a list of PassengerSeats that represent the rows in first class.
     */
    private List<PassengerSeat> createFirstClassRow(int i){
        List<PassengerSeat> seats = new ArrayList<PassengerSeat>();
        seats.add(new PassengerSeat(i + "A",
                SeatPosition.WINDOW,
                BoardingGroup.FIRST,
                false));
        seats.add(new PassengerSeat(i + "B",
                SeatPosition.AISLE,
                BoardingGroup.FIRST,
                false));
        seats.add(new PassengerSeat(i + "D",
                SeatPosition.AISLE,
                BoardingGroup.FIRST,
                false));
        seats.add(new PassengerSeat(i + "E",
                SeatPosition.WINDOW,
                BoardingGroup.FIRST,
                false));
        return seats;
    }

    /**
     * Helper method to create a row of PassengerSeats that are economy class.
     * Note that there are six seats per row (A through F);)
     * @param i row number
     * @return a list of PassengerSeats that represent the rows in economy class.
     */
    private List<PassengerSeat> createEconomyRow(int i){
        List<PassengerSeat> seats = new ArrayList<PassengerSeat>();
        seats.add(new PassengerSeat(i + "A",
                SeatPosition.WINDOW,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        seats.add(new PassengerSeat(i + "B",
                SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        seats.add(new PassengerSeat(i + "C",
                SeatPosition.AISLE,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        seats.add(new PassengerSeat(i + "D",
                SeatPosition.AISLE,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        seats.add(new PassengerSeat(i + "E",
                SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        seats.add(new PassengerSeat(i + "F",
                SeatPosition.WINDOW,
                BoardingGroup.ECONOMY,
                (i == Const.EXIT_ROW_START || i == Const.EXIT_ROW_END)));
        return seats;
    }
}