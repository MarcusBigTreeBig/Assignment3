package question1;

public class DoublyLinkedList implements LinkedList {

    private Node head;
    private Node reading;

    /**
     * creates DoublyLinkedList with a head node
     *
     * @param head
     */
    public DoublyLinkedList (Node head) {
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
    public void backward () {
        reading = reading.getPrevious();
    }
    public void goToHead () {
        reading = head;
    }
    public void addNode (Node node) {
        node.setNext(reading.getNext());
        reading.setNext(node);
        node.setPrevious(reading);
        if (node.getNext() != null) {
            node.getNext().setPrevious(node);
        }
    }

}
