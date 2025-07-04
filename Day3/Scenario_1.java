//Generate a small code in hospital management system to differentiate parameter and argument in 
package Day3;

public class Scenario_1 {
    public static void main(String[] args) {
        String patientName = "John Doe";
        int patientAge = 30;

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
