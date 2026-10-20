import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Test the DataNode class.
 */

public class DataNodeTest {
    Passenger p1;
    Passenger p2;
    DataNode<Passenger> d1;
    DataNode<Passenger> d2;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp(){
        p1 = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                true);

        p2 = new Passenger(2,
                "Grassy", "Grog",
                BoardingGroup.ECONOMY, SeatPosition.MIDDLE, 2,
                false);

        d1 = new DataNode<Passenger>(p1, null);
        d2 = new DataNode<Passenger>(p2, null);
    }

    /**
     * Tests the constructor for DataNode and getters for its attributes
     */
    @Test
    public void testConstructorAndGetter(){
        DataNode<Passenger> test = new DataNode<Passenger>(p1, null);
        assertEquals(p1,test.getData());
        assertNull(test.getNext());
    }

    /**
     * Tests the setNext method
     */
    @Test
    public void testSetNext(){
        d1.setNext(d2);
        assertEquals(d2, d1.getNext());
    }

    /**
     * Tests the findAtIndex method
     */
    @Test
    public void testFindAtIndex(){
        assertEquals(d1,d1.findAtIndex(0));
    }

    /**
     * Test the countAll method
     */
    @Test
    public void testCountAll(){
        d1.setNext(d2);
        // Define a predicate to count all passengers and add as parameter to countAll
        assertEquals(2, d1.countAll(passenger -> true));
    }

    /**
     * Tests the getAll method
     */
    @Test
    public void testGetAll_printAllPassengers() {
        d1.setNext(d2);
        String expected = "ID: 1, First Name: Timothy, Last Name: Tulip, " +
                "Boarding Group: FIRST, Seat Position Choice: AISLE, Utility If Given Seat Position Choice: 3, " +
                "Can Handle Exit Row: true, Actual Utility Once Seated: 0" + "\n" +
                "ID: 2, First Name: Grassy, Last Name: Grog, " +
                "Boarding Group: ECONOMY, Seat Position Choice: MIDDLE, Utility If Given Seat Position Choice: 2, " +
                "Can Handle Exit Row: false, Actual Utility Once Seated: 0";
        assertEquals(expected, d1.getAll(passenger -> true));
    }

    /**
     * Tests the getAll method
     */
    @Test
    public void testGetAll_printPassengersCannotHandleExitRow(){
        d1.setNext(d2);
        String expectedFilter = "ID: 2, First Name: Grassy, Last Name: Grog, " +
                "Boarding Group: ECONOMY, Seat Position Choice: MIDDLE, Utility If Given Seat Position Choice: 2, " +
                "Can Handle Exit Row: false, Actual Utility Once Seated: 0";
        assertEquals(expectedFilter, d1.getAll(passenger -> !passenger.getHandleExitRow()));
    }

    /**
     * Tests the getAll method
     */
    @Test
    public void testGetAll_printPassengersCanHandleExitRow(){
        d1.setNext(d2);
        String expectedFilter = "ID: 1, First Name: Timothy, Last Name: Tulip, " +
                "Boarding Group: FIRST, Seat Position Choice: AISLE, Utility If Given Seat Position Choice: 3, " +
                "Can Handle Exit Row: true, Actual Utility Once Seated: 0";
        assertEquals(expectedFilter, d1.getAll(passenger -> passenger.getHandleExitRow()));
    }
}
