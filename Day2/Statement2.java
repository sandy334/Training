// | Product name  | Quantity  | Price | Value |
// | --- | --- | --- | --- |
// | A | ? | 5 | 180 |
// | B | 200 | ? | 1600 |
// | C | 750 | 3 | ? | find the missing values using java code from user input

import java.util.Scanner;

public class Statement2  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Product A
        System.out.println("Enter Quantity for Product A (enter -1 if unknown): ");
        int quantityA = scanner.nextInt();
        System.out.println("Enter Price for Product A: ");
        int priceA = scanner.nextInt();
        int valueA = 180;
        if (quantityA == -1) {
            quantityA = valueA / priceA;
        }
        System.out.println("Product A -> Quantity: " + quantityA + ", Price: " + priceA + ", Value: " + valueA);

        // Product B
        int quantityB = 200;
        System.out.println("Enter Price for Product B (enter -1 if unknown): ");
        int priceB = scanner.nextInt();
        int valueB = 1600;
        if (priceB == -1) {
            priceB = valueB / quantityB;
        }
        System.out.println("Product B -> Quantity: " + quantityB + ", Price: " + priceB + ", Value: " + valueB);

        // Product C
        int quantityC = 750;
        int priceC = 3;
        int valueC = quantityC * priceC;
        System.out.println("Product C -> Quantity: " + quantityC + ", Price: " + priceC + ", Value: " + valueC);

        scanner.close();
    }
}

