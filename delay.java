// Scenario: Mr kashyap is working as software engineer finalizing spirints(short meeting) for the banking projects, the patchup work of software has a timing deadline of 5 seconds and an alarm is setup using a counter to display the reverse counting of the timer generate a code help mr kashyap.
public class delay {
    public static void main(String[] args) throws InterruptedException {
        int i = 5; // Starting from 5 seconds
        for(int sec= i; sec >= 0; sec--) {
            System.out.println("Time left: " + sec + " seconds");
            Thread.sleep(1000); // Wait for 1 second
        }   
    }
}
