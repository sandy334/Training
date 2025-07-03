//Jennie is a chatbot that classifies neutral , non neg & neg values
//generate a code to help Jennie
import java.util.Scanner;
public class NeutralNegativeNonNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number = sc.nextDouble();

        if (number > 0) {
            System.out.println("The number is positive (non-negative).");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero (neutral).");
        }

        sc.close();
    }
}

//