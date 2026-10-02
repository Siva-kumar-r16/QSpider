package DecisionMaking;

public class LargestDigit {

    public static int largestDigit(int number) {

        int largest = 0;

        while (number > 0) {

            if ( (number % 10) > largest) 
                largest =number % 10;

            number = number / 10;
        }

        return largest;
    }

    public static void main(String[] args) {

        int result = largestDigit(53842);

        System.out.println("Largest Digit = " + result);
    }
}