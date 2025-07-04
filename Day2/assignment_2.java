//scenario 2 : mr.ravi is a production executive who inspects certain products that are with defects with a related product id's such 111,222,333,444. The products are absolette and unfit to be used if it contains a minimum even value at the star and at end.Write a prgm to help him  identify obselette product

public class assignment_2 {
    public static void main(String[] args) {
        int[] productIds = {111, 222, 333, 444};
        boolean isObsolete = false;

        for (int id : productIds) {
            if (isObsoleteProduct(id)) {
                isObsolete = true;
                System.out.println("Product ID " + id + " is obsolete.");
            }
        }

        if (!isObsolete) {
            System.out.println("No obsolete products found.");
        }
    }

    public static boolean isObsoleteProduct(int productId) {
        // Check if the first and last digits are even
        int firstDigit = Character.getNumericValue(Integer.toString(productId).charAt(0));
        int lastDigit = Character.getNumericValue(Integer.toString(productId).charAt(Integer.toString(productId).length() - 1));

        return (firstDigit % 2 == 0 && lastDigit % 2 == 0);
    }
}
