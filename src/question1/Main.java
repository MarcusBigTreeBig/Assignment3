package question1;

public class Main {
    public static void main (String[] args) {

        int[] numbers1 = {1, 1, 1, 2, 2, 3, 4, 4, 5};
        int[] numbers2 = {1, 1, 2, 4, 5, 6, 7};
        //printIntegerLinkedList(mergeLinkedLists(initializeIntegerLinkedList(numbers1), initializeIntegerLinkedList(numbers2)));

    }

    /**
     * merges 2 singly linked lists sorted based on a key into a new sorted doubly linked list
     * assumes the inputted linked lists are sorted
     *
     * @param list1 first singly linked list
     * @param list2 second singly linked list
     * @return sorted doubly linked list from merge
     */
    public static DoublyLinkedList mergeLinkedLists (SinglyLinkedList list1, SinglyLinkedList list2) {
        list1.goToHead();
        list2.goToHead();
        DoublyLinkedList mergedList = null;
        return mergedList;
    }

    /**
     *
     * @param numbers numbers that will be in the linked list
     * @return a SinglyLinkedList with the numbers in order of the order of the array
     */
    public static SinglyLinkedList initializeIntegerLinkedList(int[] numbers) {
        SinglyLinkedList list = new SinglyLinkedList(new IntegerNode(numbers[0]));
        for (int i = 1; i < numbers.length; i++) {
            list.addNode(new IntegerNode(numbers[i]));
            list.forward();
        }
        return list;
    }

    /**
     *
     * @param list the list that will be printed
     */
    public static void printIntegerLinkedList (LinkedList list) {
        list.goToHead();
        while (list.read() != null) {
            if (list.read() instanceof IntegerNode) {
                System.out.print(((IntegerNode) list.read()).getValue() + " ");
            }
            list.forward();
        }
        System.out.println();
    }

}
