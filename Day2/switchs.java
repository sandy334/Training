import java.util.Scanner;

public class switchs {
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rate a delivery person (1, 2, 3, 4 ,5): ");
        int x = scanner.nextInt();
        switch (x) {
            case 1:
                System.out.println("Worst service ever");
                break;
            case 2:
                System.out.println("Not satisfied with the service");
                break;
                 default:
                System.out.println("`Thank you for your feedback`");
            case 3:
                System.out.println("Average service");
                break;
            case 4:
                System.out.println("Good service");
                break;
            case 5:     
                System.out.println("Excellent service");
                break;
            
        }
}
}
