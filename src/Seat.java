/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the Seat interface that holds a generic object.
 */

public interface Seat <T>{

        /**
        * Getter for number
        * @return seat number
        */
        public String getNumber();

        /**
        * Getter for seat position
        * @return seat position
        */
        public SeatPosition getSeatPosition();

        /**
        * Getter for boarding group
        * @return boarding group
        */
        public BoardingGroup getBoardingGroup();

        /**
        * Getter for isExitRow
        * @return whether the seat is in the exit row
        */
        public boolean getIsExitRow();

        /**
        * Getter for occupant
        * @return object occupying the seat, null if empty
        */
        public T getOccupant();

        /**
        * Setter for occupant
        * @param occupant object to occupy the seat
        */
        public void setOccupant(T occupant);
}
