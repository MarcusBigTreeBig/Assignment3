package question2;

import question3.LinkedListDeque;

public class Stack <T> {

    Node head;

    public void push (T input) {
        Node add = new Node<T>(input);
        add.next = head;
        head = add;
    }

    public T top () {
        return (T) head.getValue();
    }

    public void pop () {
        head = head.next;
    }

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
