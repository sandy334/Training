//Lowercase to uppercase using ascii values

public class Lowecasetouppercase {
    public static void main(String[] args) {
        String input = "hello world"; 
        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Convert lowercase to uppercase using ASCII values
                char upperCaseChar = (char) (c - 32);
                output.append(upperCaseChar);
            } else {
                // Keep other characters unchanged
                output.append(c);
            }
        }

        System.out.println("Converted string: " + output.toString());
    }
}
