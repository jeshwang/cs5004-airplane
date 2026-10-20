import java.util.function.Predicate;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Create a class that represents a node containing a generic object.
 * This class can both represent a non-empty node, and an empty node.
 */
public class DataNode <T> implements Node <T>{
    private T data;
    private Node <T> next;

    /**
     * Constructor for DataNode object
     * @param data - the data to store
     * @param next - reference to the next node
     */
    public DataNode(T data, Node <T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Getter for data stored in the Node object
     * @return the data
     */
    @Override
    public T getData() {
        return this.data;
    }

    /**
     * Gets the next Node
     * @return Node object
     */
    @Override
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Sets the next node
     * @param next represent the next node to be set
     */
    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Recursively, finds the Node at a given index
     * @param index representing the position of the Node to be found in a linked list
     * @return Node at the given index
     */
    public Node<T> findAtIndex(int index){
        if (index == 0){
            return this;
        }
        else{
            return this.next.findAtIndex(index - 1);
        }
    }

    /**
     * Recursively, find the count of data in a list that satisfies a condition
     * @return count of data
     */
    public int countAll(Predicate<T> predicate){
        // Whether the current node satisfies the predicate
        // This will be added the count of the rest of the list
        int i = predicate.test(this.data) ? 1 : 0;

        // Whether the current node's next is not null
        // If it is null, then we've reached the end of the list
        // and we don't count the rest of the list
        int j = this.next == null ? 0 : this.next.countAll(predicate);

        return i + j;
    }

    /**
     * Recursively, return a string of the details of a list of DataNodes, separate by a line break
     * that satisfies a condition
     * @return string of DataNodes
     */
    public String getAll(Predicate<T> predicate){
        // Check if the current node satisfies the predicate
        if (predicate.test(this.data)) {
            if(this.next == null){
                return this.data.toString();
            }
            String s = this.next.getAll(predicate);
            if (s.isEmpty()){
                return this.data.toString();
            }
           return this.data.toString() + "\n" + s;
        }
        if(this.next == null){
            return "";
        }
        return this.next.getAll(predicate);
    }
}
