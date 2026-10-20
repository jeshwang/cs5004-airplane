import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the Airplane class.
 */
public class AirplaneTest {
    List<PassengerSeat> seats;
    Airplane a;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp() {
        seats = new ArrayList<>();
        a = new Airplane();
    }

    /**
     * Tests no-argument constructor and getters
     */
    @Test
    public void testConstructorAndGetters(){
        assertEquals(a.getSeats(), seats);
    }

    /**
     * Tests createSeats
     */
    @Test
    public void testCreateSeats(){
        // Add first class row
        PassengerSeat p_2a = new PassengerSeat("2A", SeatPosition.WINDOW,
                BoardingGroup.FIRST, false);
        PassengerSeat p_2b = new PassengerSeat("2B", SeatPosition.AISLE,
                BoardingGroup.FIRST, false);
        PassengerSeat p_2d = new PassengerSeat("2D", SeatPosition.AISLE,
                BoardingGroup.FIRST, false);
        PassengerSeat p_2e = new PassengerSeat("2E", SeatPosition.WINDOW,
                BoardingGroup.FIRST, false);
        seats.add(p_2a);
        seats.add(p_2b);
        seats.add(p_2d);
        seats.add(p_2e);

        // Add economy class rows
        PassengerSeat p_3a = new PassengerSeat("3A", SeatPosition.WINDOW,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_3b = new PassengerSeat("3B", SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_3c = new PassengerSeat("3C", SeatPosition.AISLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_3d = new PassengerSeat("3D", SeatPosition.AISLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_3e = new PassengerSeat("3E", SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_3f = new PassengerSeat("3F", SeatPosition.WINDOW,
                BoardingGroup.ECONOMY, false);
        seats.add(p_3a);
        seats.add(p_3b);
        seats.add(p_3c);
        seats.add(p_3d);
        seats.add(p_3e);
        seats.add(p_3f);

        PassengerSeat p_4a = new PassengerSeat("4A", SeatPosition.WINDOW,
                        BoardingGroup.ECONOMY, false);
        PassengerSeat p_4b = new PassengerSeat("4B", SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_4c = new PassengerSeat("4C", SeatPosition.AISLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_4d = new PassengerSeat("4D", SeatPosition.AISLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_4e = new PassengerSeat("4E", SeatPosition.MIDDLE,
                BoardingGroup.ECONOMY, false);
        PassengerSeat p_4f = new PassengerSeat("4F", SeatPosition.WINDOW,
                BoardingGroup.ECONOMY, false);
        seats.add(p_4a);
        seats.add(p_4b);
        seats.add(p_4c);
        seats.add(p_4d);
        seats.add(p_4e);
        seats.add(p_4f);

        assertEquals(seats, a.createSeats(2,2, 3,4));
    }
}
