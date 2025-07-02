// EOQ is the optimal quantity of stock (or inventory) that a company should order each time to minimize the combined costs of:

// Ordering costs (costs associated with placing and receiving an order)

// Holding costs (costs of storing unsold inventory)



import java.util.Scanner;

public class eoq {
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        double a_d_m = sc.nextDouble();//annual demand in units
        double c_m_p = sc.nextDouble(); //cost per unit
        double c_s_p = sc.nextDouble();//cost of storing per unit per year
        double eoq = Math.sqrt(2 * a_d_m * c_m_p / c_s_p);
        System.out.println(eoq);
        // EOQ with 10% increase in cost per unit and 10% decrease in storing cost
        double eoq_both = Math.sqrt(2 * a_d_m * (c_m_p * 1.1) / (c_s_p * 0.9));
        System.out.println(eoq_both);
        // Print the difference between the two EOQ values
        System.out.println(eoq_both - eoq);
        // Print the percentage difference
        double percent_diff = ((eoq_both - eoq) / eoq) * 100;
        System.out.println(percent_diff);
        sc.close();
    }
}
