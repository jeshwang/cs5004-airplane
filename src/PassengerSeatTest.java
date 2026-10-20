import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the PassengerSeat class.
 */
public class PassengerSeatTest {
    PassengerSeat s1;
    Passenger p1;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp(){
        p1 = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3, false);

        s1 = new PassengerSeat("19B",
                SeatPosition.WINDOW, BoardingGroup.ECONOMY,
                false);
    }

    /**
     * Tests the constructor for PassengerSeat and getters for its attributes
     */
    @Test
    public void testConstructorAndGetters() {
        PassengerSeat test = s1;
        assertEquals("19B", test.getNumber());
        assertEquals(SeatPosition.WINDOW, test.getSeatPosition());
        assertEquals(BoardingGroup.ECONOMY, test.getBoardingGroup());
        assertFalse(test.getIsExitRow());
        assertNull(test.getOccupant());
    }

    /**
     * Tests setter for passenger
     */
    @Test
    public void testSetOccupant(){
        s1.setOccupant(p1);
        assertEquals(p1, s1.getOccupant());
    }

    /**
     * Tests toString
     */
    @Test
    public void testToString(){
        String expected =  "Number: 19B, Seat Position: WINDOW, Boarding Group: ECONOMY, Is Exit Row: false, Passenger: null";
        assertEquals(expected, s1.toString());

        // Add an occupant to the empty seat
        s1.setOccupant(p1);
        String expectedOccupied =  "Number: 19B, Seat Position: WINDOW, Boarding Group: ECONOMY, Is Exit Row: false, " +
                "Passenger: ID: 1, First Name: Timothy, Last Name: Tulip, Boarding Group: FIRST, Seat Position Choice: AISLE, Utility If Given Seat Position Choice: 3, Can Handle Exit Row: false, Actual Utility Once Seated: 0";
        assertEquals(expectedOccupied, s1.toString());
    }

    /**
     * Tests equals when a PassengerSeat object is compared with itself
     */
    @Test
    public void testEquals_reflexive_returnTrue(){
        assertTrue(s1.equals(s1));
    }

    /**
     * Tests equals when a PassengerSeat object is compared with an object of another type
     */
    @Test
    public void testEquals_anotherObject_returnFalse(){
        assertFalse(s1.equals(p1));
    }

    /**
     * Tests equals when a PassengerSeat object is compared with a null
     */
    @Test
    public void testEquals_null_returnFalse(){
        assertFalse(s1.equals(null));
    }

    /**
     * Tests equals when PassengerSeat object is compared with
     * another PassengerSeat object containing the same details.
     */
    @Test
    public void testEquals_samePassengerSeat_returnTrue(){
        PassengerSeat s2 = new PassengerSeat("19B",
                SeatPosition.WINDOW, BoardingGroup.ECONOMY,
                false);
        assertTrue(s1.equals(s2));
    }
}
