//Queue application of encryption and decryption in network systems
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class scenario1 {
    public static void main(String[] args) {
        Queue<String> messageQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a message to encrypt (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String encryptedMessage = new StringBuilder(input).reverse().toString();
            messageQueue.add(encryptedMessage);
            System.out.println("Encrypted message added to queue: " + encryptedMessage);
            String decryptedMessage = new StringBuilder(encryptedMessage).reverse().toString();
            System.out.println("Decrypted message: " + decryptedMessage);
        }
        scanner.close();
    }
}