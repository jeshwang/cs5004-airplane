import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the PassengerSeatAssigner class.
 */

public class PassengerSeatAssignerTest {
    PassengerSeatAssigner a;
    List<Seat<Passenger>> seats;
    Seat<Passenger> s_first_aisle_notExit;
    Seat<Passenger> s_econ_middle_notExit;
    Seat<Passenger> s_econ_middle_Exit;
    LinkedList<Passenger> passengers;
    Passenger p_first_aisle_handleExit;
    Passenger p_econ_middle_notHandleExit;
    Passenger p_econ_aisle_handleExit;

    /**
     * This is the setUp method for unit tests
     */
    @Before
    public void setUp(){
        p_first_aisle_handleExit = new Passenger(1,
                "Timothy", "Tulip",
                BoardingGroup.FIRST, SeatPosition.AISLE, 3,
                true);

        p_econ_middle_notHandleExit = new Passenger(2,
                "Grassy", "Grog",
                BoardingGroup.ECONOMY, SeatPosition.MIDDLE, 2,
                false);

        p_econ_aisle_handleExit = new Passenger(3,
                "Nigel", "Bean",
                BoardingGroup.ECONOMY, SeatPosition.AISLE, 5,
                true);

        s_first_aisle_notExit = new PassengerSeat("7B",
                SeatPosition.AISLE, BoardingGroup.FIRST,
                false);

        s_econ_middle_notExit = new PassengerSeat("20E",
                SeatPosition.MIDDLE, BoardingGroup.ECONOMY,
                false);

        s_econ_middle_Exit = new PassengerSeat("36E",
                SeatPosition.MIDDLE, BoardingGroup.ECONOMY,
                true);

        a = new PassengerSeatAssigner();
        seats = new ArrayList<>();
        passengers = new LinkedList<>();
    }

    /**
     * Tests createSeatingChart when all passengers receive their seat position of choice
     */
    @Test
    public void testCreateSeatingChart_allPassengersInSeatPositionsOfChoice(){
        // Create lists of seats and passengers
        seats.add(s_first_aisle_notExit);
        seats.add(s_econ_middle_notExit);
        passengers.add(p_first_aisle_handleExit);
        passengers.add(p_econ_middle_notHandleExit);

        // Call createSeatingChart
        a.createSeatingChart(seats, passengers);

        // Check passengers are placed correctly
        assertEquals(p_first_aisle_handleExit, s_first_aisle_notExit.getOccupant());
        assertEquals(p_econ_middle_notHandleExit, s_econ_middle_notExit.getOccupant());

        // Check utility values are as expected
        assertEquals(3, s_first_aisle_notExit.getOccupant().getActualUtil());
        assertEquals(2, s_econ_middle_notExit.getOccupant().getActualUtil());
    }

    /**
     * Tests createSeatingChart when all passengers receive their seat position of choice
     */
    @Test
    public void testCreateSeatingChart_allPassengersNotInSeatPositionsOfChoice(){
        // Create lists of seats and passengers
        seats.add(s_first_aisle_notExit);
        seats.add(s_econ_middle_notExit);
        passengers.add(p_first_aisle_handleExit);
        passengers.add(p_econ_aisle_handleExit);

        // Call createSeatingChart
        a.createSeatingChart(seats, passengers);

        // Check passengers are placed correctly
        assertEquals(p_first_aisle_handleExit, s_first_aisle_notExit.getOccupant());
        assertEquals(p_econ_aisle_handleExit, s_econ_middle_notExit.getOccupant());

        // Check utility values are as expected
        assertEquals(3, s_first_aisle_notExit.getOccupant().getActualUtil());
        assertEquals(0, s_econ_middle_notExit.getOccupant().getActualUtil());
    }

    /**
     * Tests createSeatingChart when seat does not match passenger's exit row handling ability
     */
    @Test
    public void testCreateSeatingChart_exitRowConditionNotMet(){
        // Create lists of seats and passengers
        seats.add(s_econ_middle_Exit);
        passengers.add(p_econ_middle_notHandleExit);

        // Call createSeatingChart
        a.createSeatingChart(seats, passengers);

        // Check passengers are placed correctly
        assertNull(s_econ_middle_Exit.getOccupant());
    }

    /**
     * Tests createSeatingChart when boarding group does not match passenger's boarding group
     */
    @Test
    public void testCreateSeatingChart_boardingGroupConditionNotMet(){
        // Create lists of seats and passengers
        seats.add(s_econ_middle_Exit);
        passengers.add(p_first_aisle_handleExit);

        // Call createSeatingChart
        a.createSeatingChart(seats, passengers);

        // Check passengers are placed correctly
        assertNull(s_econ_middle_Exit.getOccupant());
    }

    /**
     * Tests displaySeats
     */
    @Test
    public void testDisplaySeats(){
        s_first_aisle_notExit.setOccupant(p_first_aisle_handleExit);
        s_econ_middle_notExit.setOccupant(p_econ_middle_notHandleExit);
        seats.add(s_first_aisle_notExit);
        seats.add(s_econ_middle_notExit);

        String expected = "Number: 7B, Seat Position: AISLE, Boarding Group: FIRST, Is Exit Row: false, " +
                "Passenger: ID: 1, First Name: Timothy, Last Name: Tulip, Boarding Group: FIRST, Seat Position Choice: AISLE, Utility If Given Seat Position Choice: 3, Can Handle Exit Row: true, Actual Utility Once Seated: 0\n" +
                "Number: 20E, Seat Position: MIDDLE, Boarding Group: ECONOMY, Is Exit Row: false, " +
                "Passenger: ID: 2, First Name: Grassy, Last Name: Grog, Boarding Group: ECONOMY, Seat Position Choice: MIDDLE, Utility If Given Seat Position Choice: 2, Can Handle Exit Row: false, Actual Utility Once Seated: 0\n";
        assertEquals(expected, a.displaySeats(seats));
    }

    /**
     * Tests sortList
     */
    @Test
    public void testSortList(){
        // Create unsorted list of passengers
        passengers.add(p_econ_middle_notHandleExit);
        passengers.add(p_first_aisle_handleExit);
        passengers.add(p_econ_aisle_handleExit);

        LinkedList<Passenger> sortedList = a.sortList(passengers);

        assertEquals(p_econ_aisle_handleExit, sortedList.getRoot().getData());
        assertEquals(p_econ_middle_notHandleExit, sortedList.getLast().getData());
    }
}
