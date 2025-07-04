//Mr b and mr u are friends who have there residences at opposite lakes with door number 10 and 20 respectively during a rainy day they missed there lanes and U reached b’s destination help them to find there perfect ways by using functions and builtin functions
public class Assignment {
    public static void main(String[] args) {
        int doorNumberB = 10;
        int doorNumberU = 20;

        System.out.println("Mr. B's door number: " + doorNumberB);
        System.out.println("Mr. U's door number: " + doorNumberU);

        // Find the perfect ways for Mr. B and Mr. U
        findPerfectWay(doorNumberB, doorNumberU);
    }

    public static void findPerfectWay(int b, int u) {
        if (b < u) {
            System.out.println("Mr. B should go to Mr. U's residence at door number " + u);
        } else if (b > u) {
            System.out.println("Mr. U should go to Mr. B's residence at door number " + b);
        } else {
            System.out.println("Both are at the same door number: " + b);
        }
    }
}
