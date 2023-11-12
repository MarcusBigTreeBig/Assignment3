package question3;

public class LinkedListDeque <T> implements Deque <T>{

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedListDeque () {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void frontEnqueue(T input) {
        if (size == 0) {
            front = new Node<T>(input);
            rear = front;
        }else{
            Node add = new Node<>(input);
            add.backward = front;
            front.forward = add;
            front = add;
        }
        size++;
    }

    @Override
    public void rearEnqueue(T input) {
        if (size == 0) {
            front = new Node<T>(input);
            rear = front;
        }else{
            Node add = new Node<>(input);
            add.forward = rear;
            front.backward = add;
            rear = add;
        }
        size++;
    }

    @Override
    public T frontRead() {
        return front.getValue();
    }

    @Override
    public T rearRead() {
        return rear.getValue();
    }

    @Override
    public void frontDequeue() {
        front = front.backward;
        front.forward = null;
    }

    @Override
    public void rearDequeue() {
        rear = rear.forward;
        rear.backward = null;
    }

    private class Node <T> {
        Node forward;
        Node backward;
        T value;
        Node (T value) {
            this.value = value;
            forward = null;
            backward = null;
        }
       T getValue() {
            return value;
        }
        Node getForward() {
            return forward;
        }
        Node getBackward() {
            return backward;
        }
        void setValue(T value) {
            this.value = value;
        }
        void setForward(Node forward) {
            this.forward = forward;
        }
        void setBackward(Node backward) {
            this.backward = backward;
        }
    }

}
