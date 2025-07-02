// Scenario: Mr kashyap is working as software engineer finalizing spirints(short meeting) for the banking projects, the patchup work of software has a timing deadline of 5 seconds and an alarm is setup using a counter to display the reverse counting of the timer generate a code help mr kashyap.
public class delay {
    public static void main(String[] args) throws InterruptedException {
        int seconds = 5; // Set the countdown time in seconds
        while (seconds >= 0) {
            System.out.println(seconds);
            Thread.sleep(1000); // Wait for 1 second
            seconds--; // Decrement the counter
        }
     
    }
}
