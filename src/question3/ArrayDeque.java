package question3;

public class ArrayDeque<T> implements Deque<T>{

    private T[] memory;
    private int size;
    private int front;
    private int rear;

    /**
     * creates a Deque with an array
     *
     * @param max maximum amount of elements that can be contained in the dequeue
     */
    public ArrayDeque (int max) {
        memory = (T[]) new Object[max];
    }

    @Override
    public void frontEnqueue(T input) {
        if (size < memory.length) {
            if (size != 0) {
                if (front == memory.length-1) {
                    front = 0;
                }else{
                    front = front + 1;
                }
            }else{
                front = memory.length/2;
                rear = front;
            }
            memory[front] = input;
            size++;
        }
    }

    @Override
    public void rearEnqueue(T input) {
        if (size < memory.length) {
            if (size != 0) {
                if (rear == 0) {
                    rear = memory.length-1;
                }else{
                    rear = rear - 1;
                }
            }else{
                front = memory.length/2;
                rear = front;
            }
            memory[front] = input;
            size++;
        }
    }

    @Override
    public T frontRead() {
        return memory[front];
    }

    @Override
    public T rearRead() {
        return memory[rear];
    }

    @Override
    public void frontDequeue() {
        if (size > 0) {
            memory[front] = null;
            if (front == 0) {
                front = memory.length-1;
            }else{
                front = front - 1;
            }
            size--;
        }
    }

    @Override
    public void rearDequeue() {
        if (size > 0) {
            memory[rear] = null;
            if (rear == memory.length-1) {
                rear = 0;
            }else{
                rear = rear - 1;
            }
            size--;
        }
    }
}
