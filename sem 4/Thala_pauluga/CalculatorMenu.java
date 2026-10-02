package Thala_pauluga;

import java.util.Scanner;

public class CalculatorMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1 Add");
        System.out.println("2 Subtract");
        System.out.println("3 Multiply");
        System.out.println("4 Division");
        System.out.println("5 Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                addition();
                break;

            case 2:
                subtraction();
                break;

            case 3:
                multiplication();
                break;

            case 4:
                division();
                break;

            case 5:
                System.out.println("Program Exited");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    static void addition()
    {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Sum = " + (a + b));
    }

    static void subtraction()
    {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Difference = " + (a - b));
    }

    static void multiplication()
    {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Product = " + (a * b));
    }

    static void division()
    {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Quotient = " + (a / b));
    }
}