package Thala_pauluga;

import java.util.Scanner;

public class CheckNumber {

    static void checkPositive(int n) {
        if(n > 0)
            System.out.println("Positive");
        else
            System.out.println("Negative or Zero");
    }

    static void compareNumbers(int a, int b) {
        if(a > b)
            System.out.println("First is greater");
        else
            System.out.println("Second is greater or equal");
    }

    static void checkDivisibleBy6(int n) {
        if(n % 2 == 0 && n % 3 == 0)
            System.out.println("Divisible by 6");
        else
            System.out.println("Not divisible by 6");
    }

    static void checkDigit(char ch) {
        if(ch >= '0' && ch <= '9')
            System.out.println("Numeric character");
        else
            System.out.println("Non numeric character");
    }

    static void sumCheck(int x, int y) {
        if((x + y) % 2 == 0)
            System.out.println("Even sum");
        else
            System.out.println("Odd sum");
    }

    static void squareLimit(int n) {
        int sq = n * n;
        if(sq > 200)
            System.out.println("Square limit crossed");
        else
            System.out.println("Square within limit");
    }

    static void incrementCheck(int n) {
        if(n++ > 50)
            System.out.println("Increment triggered");
        else
            System.out.println("Still small");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number : ");
        int n = sc.nextInt();
        checkPositive(n);                 

        System.out.print("Enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        compareNumbers(a, b);             

        System.out.print("Enter number : ");
        int d = sc.nextInt();
        checkDivisibleBy6(d);             

        System.out.print("Enter character : ");
        char ch = sc.next().charAt(0);
        checkDigit(ch);                   

        System.out.print("Enter two numbers for sum : ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        sumCheck(x, y);                   

        System.out.print("Enter number for square check : ");
        int s = sc.nextInt();
        squareLimit(s);                   

        System.out.print("Enter number for increment check : ");
        int k = sc.nextInt();
        incrementCheck(k);                
    }
}