package pec.sem_5.day3;

public class Program2 {
    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Reversed Number: " + reverse(num));
    }
}