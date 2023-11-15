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
        if (front != null) {
            return front.getValue();
        }else{
            return null;
        }
    }

    @Override
    public T rearRead() {
        if (rear != null) {
            return rear.getValue();
        }else{
            return null;
        }
    }

    @Override
    public void frontDequeue() {
        if (size > 0) {
            front = front.backward;
            if (front != null) {
                front.forward = null;
            }
            size--;
        }
    }

    @Override
    public void rearDequeue() {
        if (size > 0 && rear != null) {
            rear = rear.forward;
            if (rear != null) {
                rear.backward = null;
            }
            size--;
        }
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
