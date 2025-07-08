//mr vimal wants to prints a names of the coin in the chess board original order=king,queen,pawn,horse. expected=horse,pawn,queen,king in linked list
// help him to implement this in java using linked list
public class li {

    // ✅ Define the Node class inside or outside the main class
    static class Node {
        String data; // stores the name of the chess piece
        Node next;   // reference to the next node

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Linked List of Chess Pieces in Reverse Order:");

        // ✅ Step 1: Create nodes for each chess piece
        Node king = new Node("King");
        Node queen = new Node("Queen");
        Node pawn = new Node("Pawn");
        Node horse = new Node("Horse");

        // ✅ Step 2: Link the nodes together in reverse order
        horse.next = pawn;   // Horse → Pawn
        pawn.next = queen;   // Pawn → Queen
        queen.next = king;   // Queen → King
        king.next = null;    // King → null

        // ✅ Step 3: Traverse and print the linked list
        Node current = horse; // Start from the head (Horse)
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null"); // Indicate end of the list
    }
}
