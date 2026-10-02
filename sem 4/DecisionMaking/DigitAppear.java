package DecisionMaking;

public class DigitAppear {

    public static int countDigit(int n, int digit) {

        int count = 0;

        while (n > 0) {
            if (n % 10 == digit)
                count++;

            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countDigit(53843, 3));
    }
}