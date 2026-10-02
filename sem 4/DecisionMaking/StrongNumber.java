package DecisionMaking;

public class StrongNumber {

    static int factorial(int n){
        int fact = 1;

        for(int i=1;i<=n;i++)
            fact *= i;

        return fact;
    }

    static boolean isStrong(int n){

        int sum = 0, temp = n;

        while(temp > 0){
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {

        if(isStrong(145))
            System.out.println("Strong Number");
        else
            System.out.println("Not Strong Number");
    }
}