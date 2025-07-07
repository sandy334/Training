//MR amal is a pharmacist who has a particular type of medicinal combinations that are measured in milli grams that may be classified into two types , type 1 : {0.23,0.44,0.74,0.83,0.37} type 2 : {4.67,4.83,3.14,4.24,5.31}
public static void main(String[] args) {
    double[] type1 = {0.23, 0.44, 0.74, 0.83, 0.37};
    double[] type2 = {4.67, 4.83, 3.14, 4.24, 5.31};

    double sumType1 = 0;
    double sumType2 = 0;

    for (double value : type1) {
        sumType1 += value;
    }

    for (double value : type2) {
        sumType2 += value;
    }

    System.out.println("Total for Type 1: " + sumType1 + " mg");
    System.out.println("Total for Type 2: " + sumType2 + " mg");
}
