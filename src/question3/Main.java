package question3;

import question1.LinkedList;

public class Main {

    public static void main (String[] args) {
        Deque<String> arrQ = new ArrayDeque<String>(20);
        Deque<String> listQ = new LinkedListDeque<String>();
        System.out.println("Array:");
        testDeque(arrQ);
        System.out.println("\nLinked List:");
        testDeque(listQ);
    }

    public static void testDeque (Deque<String> q) {
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontEnqueue("This");
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontEnqueue("is");
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.rearEnqueue("a");
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontDequeue();
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.rearDequeue();
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontDequeue();
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontDequeue();
        System.out.println(q.frontRead() + " " + q.rearRead());
        q.frontEnqueue("Test");
        System.out.println(q.frontRead() + " " + q.rearRead());
    }

}
