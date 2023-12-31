package question1;

/**
 * LinkedList with pointers to other Nodes in only one direction
 */

public class SinglyLinkedList implements LinkedList{

    private Node head;
    private Node reading;

    /**
     * constructs a SinglyLinkedList with a head node
     *
     * @param head
     */
    public SinglyLinkedList (Node head) {
        this.head = head;
        reading = head;
    }

    public Node getHead () {
        return head;
    }
    public Node read () {
        return reading;
    }
    public void forward () {
        reading = reading.getNext();
    }
    public void goToHead () {
        reading = head;
    }
    public void addNode (Node node) {
        node.setNext(reading.getNext());
        reading.setNext(node);
    }
    public void removeNext () {
        if (reading.getNext() != null) {
            reading.setNext(reading.getNext().getNext());
        }
    }

}
