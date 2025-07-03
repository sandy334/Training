import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, temp;
        int[] a = new int[10];  // Create array of size 10

        System.out.println("Enter 10 integers:");
        for (i = 0; i < 10; i++) {
            a[i] = sc.nextInt();  // Read each element individually
        }

        // Simple selection sort logic
        for (i = 0; i < 10; i++) {
            for (j = i + 1; j < 10; j++) {
                if (a[j] < a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        // Output sorted array
        System.out.println("Printing Sorted Element List...");
        for (i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}
//Traversal of array is unidirectional, meaning we can only traverse from the first element to the last element.
//movement of element in array will be element to element, meaning we can only move from one element to the next.
