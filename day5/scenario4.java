//mr madhav encodes some information over the network,he wants to classify whether the given information is a character , or a special character or case sensitive character or numeric data generate a code to help madhav
public class scenario4 {
    public static void main(String[] args) {
        String input = "Hello World! 123";
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                System.out.println(c + " is a letter.");
            } else if (Character.isDigit(c)) {
                System.out.println(c + " is a digit.");
            } else if (Character.isWhitespace(c)) {
                System.out.println("'" + c + "' is a whitespace character.");
            } else {
                System.out.println(c + " is a special character.");
            }
        }
    }
}
