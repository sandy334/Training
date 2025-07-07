public class VowelLinkedList {

    // ✅ Node class representing each character in the linked list
    static class Node {
        char data;     // To store the vowel character
        Node next;     // Reference to the next node

        // Constructor to initialize node with data
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // ✅ Step 1: Create nodes for each vowel
        Node a = new Node('a');
        Node e = new Node('e');
        Node i = new Node('i');
        Node o = new Node('o');
        Node u = new Node('u');

        // ✅ Step 2: Link the vowels together in the order a -> e -> i -> o -> u
        a.next = e;
        e.next = i;
        i.next = o;
        o.next = u;
        u.next = null; // last node should point to null

        // ✅ Step 3: Traverse and print the vowel linked list
        Node temp = a; // start traversal from the head (a)
        System.out.print("Vowel Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; // move to the next node
        }
        System.out.println("NULL");

        /*
         🧠 Explanation:
         - Each vowel is stored in a node.
         - Nodes are linked one after another like a chain.
         - We use a loop to walk through the list and print each vowel.
         - In Java, memory is managed automatically, so no need for malloc/free.
        */
    }
}
