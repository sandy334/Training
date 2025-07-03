import java.util.Scanner;

public class Statement4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] audience = new int[3];
        float[] rates = new float[3];
        String[] shows = {"first", "second", "third"};

        // Input: Number of people in each show
        for (int i = 0; i < 3; i++) {
            System.out.printf("Number of people in the %s show: ", shows[i]);
            audience[i] = sc.nextInt();
        }

        // Input: Rate for each show
        for (int i = 0; i < 3; i++) {
            System.out.printf("Rate of the %s show: ", shows[i]);
            rates[i] = sc.nextFloat();
        }

        // Calculate total earnings and total audience
        float totalEarnings = 0;
        int totalPeople = 0;
        for (int i = 0; i < 3; i++) {
            totalEarnings += audience[i] * rates[i];
            totalPeople += audience[i];
        }

        float averageEarningPerPerson = totalEarnings / totalPeople;

        // Output
        System.out.printf("Total earnings from all shows: ₹%.2f\n", totalEarnings);
        System.out.printf("Average earning per person: ₹%.2f\n", averageEarningPerPerson);

        sc.close();
    }
}
