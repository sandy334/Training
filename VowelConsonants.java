//Scenario: Jack and k=jill are playing an alphabet game , jack is interested in tracing consonants, while jill is interested in tracing non consonants. Help jack and jill with appropriate code.
import java.util.Scanner;

public class VowelConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();

        int vowels = 0, consonants = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) >= 0)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Consonants: " + consonants);
        System.out.println("Vowels: " + vowels);

        System.out.print("ASCII values: ");
        input.chars().forEach(i -> System.out.print(i + " "));
        System.out.println();

        sc.close();
    }
}


