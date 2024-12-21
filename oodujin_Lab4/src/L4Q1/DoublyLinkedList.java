package L4Q1;

//importing the java.util libraries
import java.util.ArrayList;

public class DoublyLinkedList<E> {

    public static class Node<E> {
        private E element; //reference to the element stored at this node
        private Node<E> prev; //reference to the previous node in the list
        private Node<E> next; //reference ot the subsequent node in the list

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        //returns the element stored at the node
        public E getElement() {
            return element;
        }

        //returns the node that precedes this one (or null if no such node)
        public Node<E> getPrev() {
            return prev;
        }

        //returns the node that follows this one (or null if no such node)
        public Node<E> getNext() {
            return next;
        }

        //sets the node's previous reference to point to Node n
        public void setPrev(Node<E> p) {
            prev = p;
        }

        //sets the node's next reference to point to Node n
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    //instance variables of the DoublyLinkedList
    private Node<E> header; //header sentinel
    private Node<E> trailer; //trailer sentinel
    private int size = 0; //number of elements in the list

    //constructs a new empty list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); //create header
        trailer = new Node<>(null, header, null); //trailer is preceded by header
        header.setNext(trailer); //header is followed by trailer
    }

    //returns the number of elements in the linked list
    public int size() {
        return size;
    }

    //tests whether the linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //adds an element to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); //place just before the trailer
    }

    //adds an elements to the linked list in between the given nodes
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        //create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    //returns the node containing the element e (or null if empty)
    public Node<E> findNode(E e) {
        Node<E> current = header.getNext();
        while (current != trailer) {
            if (current.getElement().equals(e)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    //Override toString() method
    @Override
    //produces a string representation of the contents of the list.
    public String toString() {
        ArrayList<E> elements = new ArrayList<>();
        Node<E> current = header.getNext();
        while (current != trailer) {
            elements.add(current.getElement());
            current = current.getNext();
        }
        return elements.toString();
    }
}