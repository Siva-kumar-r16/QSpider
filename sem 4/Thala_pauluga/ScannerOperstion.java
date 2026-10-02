package Thala_pauluga;

import java.util.Scanner;

public class ScannerOperstion {

    static double addAndSub(double a, double b, double c, char op) {
        return (op == '+') ? a + b + c : a - b - c;
    }

    static double avg(double a, double b, double c, int d, char e) {
        double sum = addAndSub(a, b, c, '+')+d+e;
        return sum / 5;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of A : ");
        double a = sc.nextDouble();

        System.out.print("Enter value of B : ");
        double b = sc.nextDouble();

        System.out.print("Enter value of C : ");
        double c = sc.nextDouble();

        System.out.print("Enter operation (+/-) : ");
        char op = sc.next().charAt(0);

        double sum = addAndSub(a, b, c, op);
        
        System.out.print("Enter value of D : ");
        int d = sc.nextInt();
        
        System.out.print("Enter the Characters E : ");
        char e = sc.next().charAt(0);
        
        double average = avg(a, b, c,d,e);

        System.out.println("Sum Result (A,B,C) : " + sum);
        System.out.println("Average (A,B,C,D,E) : " + average);
    }
}