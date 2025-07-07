//linkedlist with head, middle and last node and size of nodes, with dynamic memory allocation use malloc and assign value to each node
public class LinkedListExample {

    // ✅ Step 1: Define a Node class (equivalent to struct node in C)
    static class Node {
        int data;     // holds the value of the node
        Node next;    // reference to the next node in the list

        // Constructor to initialize node data
        Node(int data) {
            this.data = data;
            this.next = null; // initially, next is null
        }
    }

    public static void main(String[] args) {

        // ✅ Step 2: Create three nodes using the constructor
        Node head = new Node(10);    // First node (like malloc + assignment in C)
        Node middle = new Node(20);  // Second node
        Node last = new Node(30);    // Third node

        // ✅ Step 3: Link the nodes together (like setting next pointers in C)
        head.next = middle;   // first node points to second
        middle.next = last;   // second node points to third
        last.next = null;     // last node points to null (end of list)

        // ✅ Step 4: Traverse and print the linked list (like using a temp pointer in C)
        Node temp = head;  // temp starts at the head node
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> "); // print current node's data
            temp = temp.next; // move to the next node
        }
        System.out.println("NULL");

        /*
         🧠 Key Differences from C:
         - No malloc: Java uses 'new' keyword and handles memory allocation.
         - No need for free(): Java has automatic garbage collection.
         - 'struct node*' in C becomes 'Node' object references in Java.
        */
    }
}
