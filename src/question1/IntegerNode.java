package question1;

public class IntegerNode implements Node{

    private int value;
    private Node next;
    private Node previous;

    public IntegerNode (int value) {
        this.value = value;
        next = null;
        previous = null;
    }

    public int getValue () {
        return value;
    }
    public Node getNext () {
        return next;
    }
    public Node getPrevious () {
        return previous;
    }

    public void setValue (int value) {
        this.value = value;
    }
    public void setNext (Node next) {
        this.next = next;
    }
    public void setPrevious (Node previous) {
        this.previous = previous;
    }

    public int getKey () {
        return getValue();
    }

}
