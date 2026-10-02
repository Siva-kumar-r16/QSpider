package DecisionMaking;

public class NumberPrograms {

	static void sumOddEvenDigits(int n){

	    int reverse = 0;
	    while(n > 0){
	        reverse = reverse * 10 + n % 10;
	        n /= 10;
	    }

	    int odd = 0, even = 0, pos = 1;

	    while(reverse > 0){

	        int d = reverse % 10;

	        if(pos % 2 == 1)
	            odd += d;
	        else
	            even += d;

	        reverse /= 10;
	        pos++;
	    }

	    System.out.println("Odd position sum = " + odd);
	    System.out.println("Even position sum = " + even);
	}


    static int factorial(int n){

        int fact = 1;

        for(int i=1;i<=n;i++)
            fact *= i;

        return fact;
    }


    static void factors(int n){

        System.out.print("Factors : ");

        for(int i=1;i<=n;i++){
            if(n % i == 0)
                System.out.print(i + " ");
        }

        System.out.println();
    }


    static boolean perfectNumber(int n){

        int sum = 0;

        for(int i=1;i<=n/2;i++){
            if(n % i == 0)
                sum += i;
        }

        return sum == n;
    }


    public static void main(String[] args) {

        //sumOddEvenDigits(53842);

       // System.out.println("Factorial = " + factorial(5));

      //  factors(12);

        if(perfectNumber(6))
            System.out.println("Perfect Number");
        else
            System.out.println("Not Perfect Number");
    }
}