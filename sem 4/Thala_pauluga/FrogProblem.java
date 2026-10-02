package Thala_pauluga;

public class FrogProblem {
    public static void main(String[] args) {
        double totalDistance = 500;
        double oneJump = 1.75;
        
        int noOfJumps = (int) (totalDistance / oneJump);
        System.out.println("total No of jumps to cover "+totalDistance+" if one jump is "+oneJump+" is "+ (noOfJumps+1));
    }
}