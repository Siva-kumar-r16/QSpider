package Thala_pauluga;

import java.util.Scanner;

public class NumberCheck {

    static int readNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        return sc.nextInt();
    }

    static int checkSquare(int n) {
        if(n > 50)
            return n * n;
        return n;
    }

    public static void main(String[] args) {

        int num = readNumber();
        int result = checkSquare(num);

        System.out.println(result);
    }
}