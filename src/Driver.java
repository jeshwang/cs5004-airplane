import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Creates the Driver class.
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        // Create an Airplane object that creates a list of Seat objects.
        Airplane airplane = new Airplane();
        List<Seat<Passenger>> seats = airplane.createSeats(Const.FIRST_CLASS_ROW_START, Const.FIRST_CLASS_ROW_END,
                Const.ECONOMY_CLASS_ROW_START, Const.ECONOMY_CLASS_ROW_END);

        // Load .csv file with data on passengers and their information,
        // and saves info in a LinkedList of Passenger objects.
        File myFile = new File("roster.csv");
        LinkedList<Passenger> passengers= CsvReader.read(myFile);

        // Create an Assigner object that creates a sorted list of all Passengers.
        PassengerSeatAssigner assigner = new PassengerSeatAssigner();
        LinkedList<Passenger> sortedPassengers = assigner.sortList(passengers);

        // Assigns each Passenger object to a Seat object based on
        // the passenger's needs and preferences.
        assigner.createSeatingChart(seats, sortedPassengers);
        System.out.println("*** SEATING CHART ***\n" + assigner.displaySeats(seats));
        assigner.printSeats(seats);

        // Print total utility achieved and compare to total utility possible.
        utilityCalculator(seats);
    }

    /**
     * Helper method that calculates and print utility metrics for the
     * seating chart produced.
     * @param seats list of seats with passengers as occupants
     */
    private static void utilityCalculator(List<Seat<Passenger>> seats){
        int totalUtil = seats.stream()
                .map(seat -> seat.getOccupant().getSeatPositionUtil())
                .reduce(0, Integer::sum);
        int actualUtil = seats.stream()
                    .map(seat -> seat.getOccupant().getActualUtil())
                    .reduce(0, Integer::sum);

        double percentOfTotalUtil = (double) actualUtil / totalUtil * 100;

        System.out.println("*** UTILITY CALCULATOR ***\n" +
                "Achieved utility: " + actualUtil + "\n" +
                "Possible utility: " + totalUtil);
        System.out.printf("Percent of possible utility achieved: %.2f%%", percentOfTotalUtil);
    }
}
