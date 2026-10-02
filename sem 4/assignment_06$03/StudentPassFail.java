package assignment_06$03;

public class StudentPassFail {
    public static void main(String[] args) {
        int marks = 45;
        int attendance = 70;
        
        if (marks >= 40 && attendance >= 75) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}