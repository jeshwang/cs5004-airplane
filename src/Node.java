import java.util.function.Predicate;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 *  Notes: Create the Node interface to work with generics.
 */
public interface Node <T> {

    /**
     * Getter for data stored in the Node object
     * @return the data
     */
    public T getData();

    /**
     * Gets the next Node
     * @return Node object
     */
    public Node <T> getNext();

    /**
     * Sets the next node
     * @param next represent the next node to be set
     */
    public void setNext(Node <T> next);

    /**
     * Recursively, finds the Node at a given index
     * @param index representing the position of the Node to be found in a linked list
     * @return Node at the given index
     */
    public Node <T> findAtIndex(int index);

    /**
     * Recursively, find the count of data in a list
     * @return count of data
     */
    public int countAll(Predicate<T> predicate);

    /**
     * Recursively, return a string of the details of a list of DataNodes, separate by a line break
     * @return string of DataNodes
     */
    public String getAll(Predicate<T> predicate);
}
