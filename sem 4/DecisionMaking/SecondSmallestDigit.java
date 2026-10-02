package DecisionMaking;

public class SecondSmallestDigit {

    static int secondSmallest(int n) {

        int s = 9, ss = 9;

        for (; n > 0; n /= 10) {
            int d = n % 10;
            if (d < s) { 
            	ss = s; 
            	s = d; 
            }
            else if (d < ss && d != s) 
            	ss = d;
        }

        return ss;
    }

    public static void main(String[] args) {
        System.out.println(secondSmallest(2222));
    }
}