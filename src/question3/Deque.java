package question3;

public interface Deque <T> {
    public void frontEnqueue (T input);
    public void rearEnqueue (T input);
    public T frontRead ();
    public T rearRead ();
    public void frontDequeue ();
    public void rearDequeue ();

}
