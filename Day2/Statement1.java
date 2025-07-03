//Scenario:Mr vimal is working as a plumber repairing tanks of spherical nature in an appartment.In an appartment he came across a tank that had a small slit through which water leaks as a result the tank is half empty.After fixing the issue he wants to access the macimum capacity of the tank.Guide him to write a code with a radius of 21cm for a tank as such.

public class Statement1 {
    public static void main(String[]args){
        double radius = 21;
        double pi = 3.14;
        double volume = (4/3)*pi*(radius*radius*radius);
        System.out.println("The maximum capacity of the tank is: " + volume );

    }
}

