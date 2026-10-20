import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Name: Jessica Hwang
 * Project: CS5004 Final
 * Semester: Spring 2024
 * Notes: Creates the LinkedList class, that uses an Iterable.
 * Iterable is an interface that collections can implement, which provides access to an interator.
 * Contains a nested, private class called LinkedListIterator that is used to conduct the iteration.
 */
public class LinkedList<T> implements Iterable<T>{
    private Node<T> root; // first node in the list
    private Node<T> last; // last node in the list

    /**
     * Constructor for LinkedList
     * Assigns root to a null to make an empty list
     */
    public LinkedList() {
        root = null;
        last = null;
    }

    /**
     * Constructor for LinkedList that takes in a Node
     * and assigns the Node as the root and the last element in the list
     * @param n Node
     */
    public LinkedList(Node<T> n){
        root = n;
        last = n;
        while (last.getNext() != null) {
            last = last.getNext();
        }
    }

    /**
     * Getter for root
     * @return root node
     */
    public Node<T> getRoot(){
        return this.root;
    }

    /**
     * Getter for last node in the list
     * @return last node
     */
    public Node<T> getLast(){
        return this.last;
    }

    /**
     * Define the iterator using the LinkedListIterator
     * and assign its pointer to the root node, so it knows
     * to start there first.
     * @return LinkedListIterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(root);
    }

    /**
     * Add more to the list
     * If the list is empty, then the new node is assigned as
     * both the first and last node in the list.
     * If the list is not empty, the new node is assigned as the last node in the list.
     * @param data
     */
    public void add(T data){
        Node<T> newNode = new DataNode<T>(data, null);
        // Case if the list is empty
        if (this.root == null) {
            this.root = newNode;
            this.last = newNode;
        }
        // Case if the list is not empty
        else{
            this.last.setNext(newNode); // update the pointer of the current last node
            this.last = newNode; // set newNode as the last node
        }
    }

    /**
     * This method is not supported.
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method is not supported.
     */
    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * Makes a nested LinkedListIterator class that is inside the LinkedList class.
     * Only LinkedList objects can construct instances of the LinkedListIterator.
     * No other code should need to talk about LinkedListIterators.
     * Note on why it's static:
         * If you want to make an instance of this, you would call LinkedList.LinkedListIterator().
         * If you make it static, it means the LinkedListIterator instances are disconnected from
         * the LinkedList instances. If it's not static, then LinkedListIterator instances
         * are directly associated with an instance of LinkedList - you don't want the iterator
         * to mess with the internal state of the LinkedList.
     * @param <T> generic data
     */
    private static class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> node;

        /**
         * Constructor for LinkedListIterator
         * @param node the node to start iterating at
         */
        public LinkedListIterator(Node<T> node){
            this.node = node;
        }

        /**
         * Checks whether the current node is empty.
         * @return true if the current node is not empty.
         */
        @Override
        public boolean hasNext() {
            return this.node != null;
        }

        /**
         * Returns the data stored in the current node AND
         * advances the iterator to the next node
         * @return the data stored in the current node
         */
        @Override
        public T next() {
            T currentData = this.node.getData();
            this.node = this.node.getNext();
            return currentData;
        }

        /**
         * This method is not supported.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * This method is not supported.
         * @param action The action to be performed for each element
         */
        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            throw new UnsupportedOperationException();
        }
    }
}
