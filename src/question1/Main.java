package question1;

public class Main {

    /**
     * defines 2 sorted SinglyLinkedList's of integers, merges them into a sorted DoublyLinkedList, and prints the output
     *
     * @param args
     */
    public static void main (String[] args) {

        int[] numbers1 = {1, 1, 1, 2, 2, 3, 4, 4, 5, 9};
        int[] numbers2 = {1, 1, 2, 4, 5, 6, 7, 13};
        printIntegerLinkedList(mergeLinkedLists(initializeIntegerLinkedList(numbers1), initializeIntegerLinkedList(numbers2)));

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
        DoublyLinkedList mergedList;
        mergedList = new DoublyLinkedList(determineNode(list1, list2));
        Node node;
        //looking at next node instead of current one being read as to be able to remove the node being observed
        while (list1.read().getNext() != null || list2.read().getNext() != null) {//once both are null, have gone through entirety of both lists
            node = determineNode(list1, list2);
            if (node.getKey() != mergedList.read().getKey()) {//to avoid duplicates
                mergedList.addNode(node);
                mergedList.forward();
            }
        }
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

    /**
     * determines the node that should be added to the DoublyLinkedList
     * the node will be removed from the input list it belongs to, and will have it's forward pointer removed
     *
     * @param list1
     * @param list2
     * @return the node of smaller key, or the one that's not null between the 2 lists
     */
    private static Node determineNode (SinglyLinkedList list1, SinglyLinkedList list2) {
        Node node;
        Node next1 = list1.read().getNext();
        Node next2 = list2.read().getNext();
        if (next2 != null && (next1 == null || next1.getKey() > next2.getKey())) {//list 1 empty or key is larger than list 2
            node = list2.read().getNext();
            list2.removeNext();
        }else if (next1 != null && (next2 == null || next2.getKey() > next1.getKey())) { //list 2 empty or key is larger than list 1
            node = list1.read().getNext();
            list1.removeNext();
        }else { // keys are equal (to get to this point, nether list can read a null)
            node = list1.read().getNext();
            list1.removeNext();
            list2.removeNext();
        }
        node.setNext(null);
        return node;
    }

}
