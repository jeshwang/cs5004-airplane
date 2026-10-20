import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Iterator;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Tests the LinkedList class, that uses an Iterable.
 */

public class LinkedListTest {

    // Create a DataNode to test with
    // Private: you're only using it inside the test class
    // Static: don't need to have multiple instances of this test class
    // Final: this is never going to change
    private static final DataNode<Integer> d1 = new DataNode<>(1, null);

    /**
     * Tests the no-argument constructor that creates an empty list,
     * and tests the getters.
     */
    @Test
    public void testConstructorWithoutArgumentAndGetters() {
        LinkedList<Integer> test = new LinkedList<>();
        assertNull(test.getRoot());
        assertNull(test.getLast());
    }

    /**
     * Tests the constructor that takes in an argument that creates a
     * list with one node.
     */
    @Test
    public void testConstructorWithArgumentAndGetters() {
        LinkedList<Integer> test = new LinkedList<>(d1);
        assertEquals(d1, test.getRoot());
        assertEquals(d1, test.getLast());
    }

    /**
     * Tests the iterator on an empty list
     */
    @Test
    public void testIterator_emptyList() {
        // Made a new empty list
        LinkedList<Integer> test = new LinkedList<>();
        // Made an iterator object that will be used to go through the test list
        Iterator<Integer> it = test.iterator();

        // Test that the list is empty
        assertFalse(it.hasNext());
    }

    /**
     * Tests the Iterator on a non-empty list
     */
    @Test
    public void testIteratorAndAdd_nonEmptyList() {
        // Made a new empty list
        LinkedList<Integer> test = new LinkedList<>();

        // Add the integers to the list
        test.add(1);
        test.add(2);

        // Made an iterator object that will be used to go through the test list
        Iterator<Integer> it = test.iterator();

        // Test that the list is not empty and the first value is a 1
        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(1), it.next());  // pointer advances forward

        // Test that 2 is next in the list
        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(2), it.next()); // pointer advances forward

        // Test that 2 is the end of the list
        assertFalse(it.hasNext());
    }
}
