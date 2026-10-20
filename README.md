This project belongs to Jessica Hwang for the purpose of completing course CS5004, Object Oriented Design, as a requirement of the Masters in Computer Science program at Northeastern University. 
The course was taught by Professor Molly Domino in the Spring Semester 2024. 

This project was self-designed by Jessica Hwang. The purpose is to demonstrate understanding of:
	• Typical object-oriented concepts such as information hiding, encapsulation and various forms of polymorphism. 
	• The use of inheritance and composition as dual techniques for software reuse. 
	• Gain a deeper understanding of object-oriented design using the use of graphical design notations such as UML and object-oriented design patterns.
	• Examine the relationship between algorithms and data structures, as well as basic techniques for analyzing algorithm complexity.
	• Unit testing.

STATEMENT OF INTEGRITY
No AI was used to write any part of this project, as it was designed and coded by me in April 2024. 
I did not rely on any existing work on the Internet to design this project.

PROJECT DETAILS
The main application is an application that analyzes passenger data and decides how to seat passengers on a set of seats in a plane. To model the seats, I referenced a Boeing 737-8 with 146 total passenger seats (excluding seats for flight staff). 

The application:
1.	Reads a csv file containing data on passengers, where each row contains information about a passenger’s identifying information (unique ID number, first name, and last name), their strict requirements (boarding group and whether they can handle exit row responsibilities), their reported preferred seat position, and the level of expected utility experienced by the passenger if they are seated in their reported preferred seat position.
   a. The application makes use of a CsvReader application that uses a Scanner object to read a .csv file and outputs a LinkedList of Passenger objects.
   b. Instead of using Java’s built-in LinkedList class, I defined my own LinkedList class that uses an Iterator design pattern.
2.  Reads in a list of seats available on the plane, where each seat contains information about the seat number, boarding group (first class or economy), seat position (aisle, middle, or window), whether the seat is in an exit row, and who/what is occupying the seat.
   a. The application makes use of a Plane application that uses declared specifications of the plane to build a seating chart with empty PassengerSeat objects, each representing a seat on the plane.
3.	Analyzes both lists and uses a greedy algorithm to sort passengers into seats, in a manner that results in the maximum total utility experienced by passengers.
   a. The application makes use of a PassengerSeatAssigner application that assigns each passenger on the list to an available seat.
4.	Creates and prints the final seating chart.
5.	Produces utility metrics showing actual utility achieved from the final seating chart, total possible utility from reported levels of expected utility from passengers, and the percentage of total possible utility achieved from the final seating chart.
  a. The application makes use of a helper method to calculate utility metrics.

