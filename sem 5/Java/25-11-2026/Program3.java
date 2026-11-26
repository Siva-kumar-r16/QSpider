package pec.sem_5.day3;

public class Program3 {
	
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
	
	public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }
	
	public static boolean emirp(int n) {
		int rev=reverse(n);
		
		if (n==rev)
			return false;
		
		else if(isPrime(n)==isPrime(rev)&& isPrime(rev))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		int n=25;
		if (emirp(n))
			System.out.print("Emirp number");
		else
			System.out.print("Not Emirp number");

	}
	

}
