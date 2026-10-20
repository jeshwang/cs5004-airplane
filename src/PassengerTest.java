import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the Passenger class.
 */

public class PassengerTest {
    Passenger p1;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp(){
        p1 = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                true);
    }

    /**
     * Tests the constructor for Passenger and getters for its attributes
     */
    @Test
    public void testConstructorAndGetters(){
        Passenger testPassenger = p1;
        assertEquals(p1.getId(), testPassenger.getId());
        assertEquals(p1.getFirstName(), testPassenger.getFirstName());
        assertEquals(p1.getLastName(), testPassenger.getLastName());
        assertEquals(p1.getBoardingGroup(), testPassenger.getBoardingGroup());
        assertEquals(p1.getSeatPositionChoice(), testPassenger.getSeatPositionChoice());
        assertEquals(p1.getSeatPositionUtil(), testPassenger.getSeatPositionUtil());
        assertEquals(p1.getHandleExitRow(), testPassenger.getHandleExitRow());
        assertEquals(p1.getActualUtil(), testPassenger.getActualUtil());
    }

    /**
     * Tests the constructor for Passenger if SeatPositionUtil is not between 1-5
     * Should throw IllegalArgumentException
     */
    @Test
    public void testConstructor_throwsIllegalArgumentException(){
        IllegalArgumentException eFromSeatPositionUtil = assertThrows(IllegalArgumentException.class,
                ()-> new Passenger(1,
                    "Timothy", "Tulip",
                    BoardingGroup.FIRST, SeatPosition.AISLE, 7,
                    true));

        assertEquals("getSeatPositionUtil must be between 1 and 5, inclusive.",
                eFromSeatPositionUtil.getMessage());
    }

    /**
     * Tests the toString method
     */
    @Test
    public void testToString(){
        String s = p1.toString();
        assertEquals(s, "ID: 1, First Name: Timothy, Last Name: Tulip, " +
                "Boarding Group: FIRST, Seat Position Choice: AISLE, Utility If Given Seat Position Choice: 3, " +
                "Can Handle Exit Row: true, Actual Utility Once Seated: 0");
    }

    /**
     * Tests equals when a Passenger object is compared with itself
     */
    @Test
    public void testEquals_reflexive_returnTrue(){
        assertTrue(p1.equals(p1));
    }

    /**
     * Tests equals when a Passenger object is compared with an object of another type
     */
    @Test
    public void testEquals_anotherObject_returnFalse(){
        assertFalse(p1.equals(1));
    }

    /**
     * Tests equals when a Passenger object is compared with a null
     */
    @Test
    public void testEquals_null_returnFalse(){
        assertFalse(p1.equals(null));
    }

    /**
     * Tests equals when Passenger object is compared with
     * another Passenger object containing the same details.
     */
    @Test
    public void testEquals_samePassenger_returnTrue(){
        Passenger p2 = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                true);
        assertTrue(p1.equals(p2));
    }
}