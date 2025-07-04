import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[100];
        int n, key;

        System.out.print("Enter size of the array: ");
        n = scanner.nextInt();

        System.out.println("Enter elements in array: ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the key: ");
        key = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                System.out.println("Element found");
                return; // exits the program
            }
        }

        System.out.println("Element not found");
    }
}
