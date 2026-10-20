import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Creates the CsvReader class.
 * Takes in a .csv file.
 * For each row in the file, create a Passenger object, and
 * store the Passenger object into a linked list of Passenger objects.
 */
public class CsvReader{
    /**
     * Uses a Scanner object to read in a csv file and
     * stores each row as a Passenger object in a LinkedList of Passenger objects.
     * A Passenger object is created from a row ONLY if the row has complete information
     * about the passenger.
     * The output represents a list of passengers and their respective information.
     * @param file name of the csv file
     * @return LinkedList of Passenger objects
     * @throws FileNotFoundException
     */
    public static LinkedList<Passenger> read(File file) throws FileNotFoundException{
        // Create the LinkedList of passengers to store the passengers.
        LinkedList<Passenger> passengers = new LinkedList<>();

        // Scanner object helps iterate through each line of the file.
        // Will throw an exception if file is not found.
        Scanner sc = new Scanner(file);

        // Scanner sets the delimiter pattern: either a comma, or a carriage return + line break
        sc.useDelimiter(",|\\r\\n");

        // Scanner gets rid of our headers by skipping the first row in the .csv file
        sc.nextLine();

        // Create a new Passenger object for each complete row.
        // If a row is missing a passenger, or if the information for a passenger is incomplete,
        // skip the row and move on to the next row.
        while (sc.hasNextLine()) { // hasNextLine() determines if there's another line and returns a boolean value
            Passenger p = readPassengerFromLine(sc);
            if(p != null) {
                passengers.add(p);
            }
            else {
                sc.nextLine();
            }
        }
        sc.close();
        return passengers;
    }

    /**
     * Creates a Passenger object from a line in a csv file.
     * Prints out the details of the Passenger object added to the list.
     * @param sc Scanner object
     * @return Passenger object if the row is complete, or
     * null if the row is incomplete or does not have the right types.
     */
    private static Passenger readPassengerFromLine(Scanner sc){
        if (!sc.hasNextInt()) return null;
        int id = sc.nextInt();

        if(!sc.hasNext()) return null;
        String firstName = sc.next().trim();

        if(!sc.hasNext()) return null;
        String lastName = sc.next().trim();

        BoardingGroup boardingGroup; // initializes to null
        if(!sc.hasNext()) return null;
        try{
            boardingGroup = BoardingGroup.valueOf(sc.next().trim());
        }catch(IllegalArgumentException e){
            return null;
        }

        SeatPosition seatPositionChoice; // initializes to null
        if(!sc.hasNext()) return null;
        try {
            seatPositionChoice = SeatPosition.valueOf(sc.next().trim());
        }catch(IllegalArgumentException e){
            return null;
        }

        if (!sc.hasNextInt()) return null;
        int seatPositionUtil = sc.nextInt();

        // 0 means they cannot handle the exit row
        // 1 means they can
        // all integers other than 0 and 1 means they cannot handle the exit row
        if (!sc.hasNextInt()) return null;
        boolean handleExitRow = (sc.nextInt() == 1);

        System.out.println("Passenger added to list: " +
                id + " " + firstName + " " + lastName + " " +
                boardingGroup + " " + seatPositionChoice + " " +
                seatPositionUtil + " " + handleExitRow);

        return new Passenger(id, firstName, lastName, boardingGroup, seatPositionChoice,
                seatPositionUtil, handleExitRow);
    }
}
