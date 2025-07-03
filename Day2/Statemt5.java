import java.util.Scanner;

public class Statemt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt(); 

        String result = (age >= 18) ? "Eligible to vote" : "Not eligible to vote";
         System.out.println(result);

    }
}
