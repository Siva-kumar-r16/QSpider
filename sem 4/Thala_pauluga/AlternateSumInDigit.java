package Thala_pauluga;

public class AlternateSumInDigit {

    public static int alternateSumInDigit(int number) {

        int reverse = 0,sum = 0;

        for (int temp = number; temp > 0; temp /= 10)
            reverse = reverse * 10 + temp % 10;


        for (int temp = reverse; temp > 0; temp /= 100)
            sum += temp % 10;
		return sum;

    }

    public static void main(String[] args) {

        int result = alternateSumInDigit(1234);

        System.out.println("Sum = " + result);
    }
}