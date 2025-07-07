//MR amal is a pharmacist who has a particular type of medicinal combinations that are measured in milli grams that may be classified into two types , type 1 : {0.23,0.44,0.74,0.83,0.37} type 2 : {4.67,4.83,3.14,4.24,5.31} ie addition of first type to second type will result in a new type of medicinal combination that is equal to the sum of the two types.

public class Scenario1 {
    public static void main(String[] args) {
        double[] type1 = {0.23, 0.44, 0.74, 0.83, 0.37};
        double[] type2 = {4.67, 4.83, 3.14, 4.24, 5.31};
        System.out.println("Resulting Medicinal Combinations:");
        for (int i = 0; i < type1.length; i++) {
            double result = type1[i] + type2[i];
            System.out.print(result + " ");

        }
    }
}
// Output: Resulting Medicinal Combinations: 4.9 5.27 3.88 5.07 5.68