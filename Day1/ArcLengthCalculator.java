import java.util.Scanner;

public class ArcLengthCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get radius from user
        System.out.print("Enter radius (in cm): ");
        double r = sc.nextDouble();

        // Get angle in degrees from user
        System.out.print("Enter angle (in degrees): ");
        double theta = sc.nextDouble();

        // Calculate arc length using formula: (2 * π * r * θ) / 360
        double arcLength = (2 * 3.14 * r * theta) / 360;

        // Output result
        System.out.printf("Arc Length = %.2f cm\n", arcLength);

        sc.close();
    }
}

