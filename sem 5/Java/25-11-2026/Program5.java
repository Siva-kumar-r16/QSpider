package pec.sem_5.day3;

public class Program5 {
    public static boolean isNeonNumber(int n) {
        int sq = n * n, sum = 0; // Changed sum from 1 to 0
        
        while (sq != 0) {
            int digit = sq % 10;
            sum += digit;
            sq /= 10;
        }
        
        return sum == n;
    }
    public static void main(String[] args) {
		int n=7;
		if(isNeonNumber(n))
			System.out.print(n+" is Neon Number");
		else
			System.out.print(n+" is not Neon Number");
	}
}