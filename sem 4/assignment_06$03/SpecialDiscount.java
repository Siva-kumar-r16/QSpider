package assignment_06$03;

public class SpecialDiscount {
    public static void main(String[] args) {
        int age = 22;
        boolean isStudent = true;
        
        if (age >= 60 || isStudent) {
            System.out.println("Eligible for Discount");
        } else {
            System.out.println("Not Eligible");
        }
    }
}