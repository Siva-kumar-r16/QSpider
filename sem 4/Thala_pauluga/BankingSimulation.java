package Thala_pauluga;

import java.util.Scanner;

public class BankingSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double savingBalance = 1000;
        double currentBalance = 2000;

        int choice, account;
        double amount;

        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("1. Saving Account");
                System.out.println("2. Current Account");
                System.out.print("Select Account: ");
                account = sc.nextInt();

                switch(account)
                {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        amount = sc.nextDouble();
                        savingBalance += amount;
                        System.out.println("Deposited into Saving Account");
                        System.out.println("Saving Balance: " + savingBalance);
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        amount = sc.nextDouble();
                        currentBalance += amount;
                        System.out.println("Deposited into Current Account");
                        System.out.println("Current Balance: " + currentBalance);
                        break;
                }
                break;

            case 2:
                System.out.println("1. Saving Account");
                System.out.println("2. Current Account");
                System.out.print("Select Account: ");
                account = sc.nextInt();

                switch(account)
                {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        amount = sc.nextDouble();

                        if(amount <= savingBalance)
                        {
                            savingBalance -= amount;
                            System.out.println("Withdrawn from Saving Account");
                            System.out.println("Saving Balance: " + savingBalance);
                        }
                        else
                        {
                            System.out.println("Insufficient Balance");
                        }
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        amount = sc.nextDouble();

                        if(amount <= currentBalance)
                        {
                            currentBalance -= amount;
                            System.out.println("Withdrawn from Current Account");
                            System.out.println("Current Balance: " + currentBalance);
                        }
                        else
                        {
                            System.out.println("Insufficient Balance");
                        }
                        break;
                }
                break;

            case 3:
                System.out.println("1. Saving Account");
                System.out.println("2. Current Account");
                System.out.print("Select Account: ");
                account = sc.nextInt();

                switch(account)
                {
                    case 1:
                        System.out.println("Saving Account Balance: " + savingBalance);
                        break;

                    case 2:
                        System.out.println("Current Account Balance: " + currentBalance);
                        break;
                }
                break;

            case 4:
                System.out.println("Thank you for using the banking system.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}