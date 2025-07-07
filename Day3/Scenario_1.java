//Generate a small code in hospital management system to differentiate parameter and argument  
package Day3;

import java.util.Scanner;

public class Scenario_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String patientName = sc.nextLine();
        int patientAge = sc.nextInt();
        // Call the method with parameters
        registerPatient(patientName, patientAge);
    }

    // Method with parameters
    public static void registerPatient(String name, int age) {
        // Arguments are passed to the parameters
        System.out.println("Registering patient:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
}
// This code demonstrates the difference between parameters and arguments in a method.

