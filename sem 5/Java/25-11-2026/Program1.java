package pec.sem_5.day3;


public class Program1 {
    public static boolean primeNumber(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        if (primeNumber(n)) 
            System.out.println("Prime Number");
            
        else
            System.out.println("Not Prime Number");
        
    }
} 