package question1;

/**
 * Defines a node for a LinkedList
 */

public interface Node{

    public int getKey();
    public Node getNext ();
    public Node getPrevious ();

    public void setValue (int value);
    public void setNext(Node next);
    public void setPrevious(Node previous);

}
