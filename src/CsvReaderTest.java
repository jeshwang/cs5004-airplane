import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the CsvReader class.
 */

public class CsvReaderTest {
    LinkedList<Passenger> passengers;
    Passenger timothy;
    Passenger shimothy;
    Passenger mercedes;
    CsvReader reader;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp(){
        passengers = new LinkedList<>();

        timothy = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                false);

        shimothy = new Passenger(4,
                "Shimothy", "Shulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                false);

        mercedes = new Passenger(137,
                "Mercedes", "Johnson",
                BoardingGroup.ECONOMY, SeatPosition.WINDOW, 1, true);
    }

    /**
     * Tests read method
     * @throws FileNotFoundException
     */
    @Test
    public void testRead() throws FileNotFoundException{
        LinkedList<Passenger> expectedPassengers = new LinkedList<>();
        expectedPassengers.add(timothy);
        expectedPassengers.add(shimothy);

        // Load .csv file with test data of passengers and their information,
        // and saves info in a LinkedList of Passenger objects.
        File myFile = new File("test.csv");
        LinkedList<Passenger> passengers= CsvReader.read(myFile);

        assertEquals(timothy, passengers.getRoot().getData());
        assertEquals(shimothy, passengers.getLast().getData());
    }
}
