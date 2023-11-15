package question2;

public class Stack <T> {

    Node head;

    /**
     * adds the input to the stack
     * @param input
     */
    public void push (T input) {
        Node add = new Node<T>(input);
        add.next = head;
        head = add;
    }

    /**
     *
     * @return the visible input in the stack
     */
    public T top () {
        return (T) head.getValue();
    }

    /**
     * removes the top of the stack
     */
    public void pop () {
        head = head.next;
    }

    /**
     * Linked list node
     * @param <T>
     */
    private class Node <T> {
        Node next;
        T value;
        Node (T value) {
            this.value = value;
            next = null;
        }
        T getValue() {
            return value;
        }
        Node getNext() {
            return next;
        }
        void setValue(T value) {
            this.value = value;
        }
        void setNext(Node next) {
            this.next = next;
        }
    }
}
