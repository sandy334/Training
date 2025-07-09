// Mr. Suresh is interested in a lexographic application that performs stack operations on non-consonants.
// This program demonstrates stack push, pop, and peek operations.

import java.util.*;


public class scenario1 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();//define the data type in <>
        String input = "Hello World"; // Example input string

        // Push non-consonants onto the stack
        for (char ch : input.toCharArray()) {
            if (!isConsonant(ch)) {
                stack.push(ch);
            }
        }

        // Pop elements from the stack and print them
        System.out.println("Popped elements from the stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // Peek at the top element of the stack (if any)
        if (!stack.isEmpty()) {
            System.out.println("\nTop element in the stack: " + stack.peek());
        } else {
            System.out.println("\nStack is empty.");
        }
    }

    // Method to check if a character is a consonant
    private static boolean isConsonant(char ch) {
        return Character.isLetter(ch) &&
               "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(ch) >= 0;//consonants
    }
}
