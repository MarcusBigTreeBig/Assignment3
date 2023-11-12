package question1;

public class SinglyLinkedList implements LinkedList{

    private Node head;
    private Node reading;

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
