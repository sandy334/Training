//Kalpana is an astronaut who measures atmospheric pressures and records them in a range such as v = 21,8,7,4,11 kindly help her to determine 
//The second largest value in the given range 
import java.util.Arrays;
import java.util.Scanner;

public class scenario1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter atmospheric pressures separated by commas (e.g., 21,8,7,4,11):");
        String input = scanner.nextLine();
        
        // Split the input string into an array of strings
        String[] pressureStrings = input.split(",");
        
        // Convert the string array to an integer array
        int[] pressures = new int[pressureStrings.length];
        for (int i = 0; i < pressureStrings.length; i++) {
            pressures[i] = Integer.parseInt(pressureStrings[i].trim());
        }
        
        // Find the second largest value
        int secondLargest = findSecondLargest(pressures);
        
        System.out.println("The second largest atmospheric pressure is: " + secondLargest);
    }

    private static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2]; // Return the second last element in the sorted array
    }
}
 