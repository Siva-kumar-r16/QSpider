package Thala_pauluga;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1 -> Addition");
            System.out.println("2 -> Subtraction");
            System.out.println("3 -> Multiplication");
            System.out.println("4 -> Exit");
            
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter two numbers: ");
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                if (choice == 1)
                    System.out.println("Result = " + (num1 + num2));
                else if (choice == 2)
                    System.out.println("Result = " + (num1 - num2));
                else 
                    System.out.println("Result = " + (num1 * num2));
               
            } else if (choice != 4) 
                System.out.println("Invalid choice, please try again.");
            

        } while (choice != 4);

    }
}