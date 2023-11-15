package question3;

/**
 * defines a Deque, or double ended queue
 * A queue that can enqueue, dequeue, and read from both the front and rear
 *
 * @param <T>
 */

public interface Deque <T> {

    /**
     * adds an element to the front
     *
     * @param input
     */
    public void frontEnqueue (T input);

    /**
     * adds an element to the back
     *
     * @param input
     */
    public void rearEnqueue (T input);

    /**
     *
     * @return the front most element
     */
    public T frontRead ();

    /**
     *
     * @return the rear most element
     */
    public T rearRead ();

    /**
     * removes the front most element
     */
    public void frontDequeue ();

    /**
     * removes the rear most element
     */
    public void rearDequeue ();

}
