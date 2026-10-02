package Thala_pauluga;

import java.util.Scanner;

public class DecisionPrograms {

    static Scanner sc = new Scanner(System.in);

    static void marksResult() {
        System.out.println("Enter Marks:");
        int marks = sc.nextInt();

        if (marks < 40)
            System.out.println("Fail");
        else if (marks <= 59)
            System.out.println("Pass");
        else if (marks <= 79)
            System.out.println("First Class");
        else
            System.out.println("Distinction");
    }

    static void fizzBuzz() {
        System.out.println("Enter Number:");
        int num = sc.nextInt();

        if (num % 3 == 0 && num % 5 == 0)
            System.out.println("FizzBuzz");
        else if (num % 3 == 0)
            System.out.println("Fizz");
        else if (num % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println("Normal Number");
    }

    static void rangeCheck() {
        System.out.println("Enter Number:");
        int num = sc.nextInt();

        if (num >= 1 && num <= 10)
            System.out.println("Small Range");
        else if (num >= 11 && num <= 50)
            System.out.println("Medium Range");
        else
            System.out.println("Large Range");
    }

    static void asciiCheck() {
        System.out.println("Enter ASCII value:");
        int ascii = sc.nextInt();

        if (ascii >= 65 && ascii <= 90)
            System.out.println("Uppercase");
        else if (ascii >= 97 && ascii <= 122)
            System.out.println("Lowercase");
        else if (ascii >= 48 && ascii <= 57)
            System.out.println("Digit");
        else
            System.out.println("Special Character");
    }

    static void multipleOfFive() {
        System.out.println("Enter Number:");
        int num = sc.nextInt();

        if (num % 5 == 0)
            System.out.println("Multiple of 5");
        else
            System.out.println("Other Number");
    }

    static void bitCategory() {
        System.out.println("Enter Number:");
        int num = sc.nextInt();

        int count = Integer.bitCount(num);

        if (count == 1)
            System.out.println("Power of Two");
        else if (count == 2)
            System.out.println("Two Bit Number");
        else
            System.out.println("Complex Bit Pattern");
    }

    static void attendanceCheck() {
        System.out.println("Enter Attendance Percentage:");
        int att = sc.nextInt();

        if (att >= 90)
            System.out.println("Excellent Attendance");
        else if (att >= 75)
            System.out.println("Good Attendance");
        else if (att >= 60)
            System.out.println("Average Attendance");
        else
            System.out.println("Low Attendance");
    }

    static void numberDifference() {
        System.out.println("Enter First Number:");
        int a = sc.nextInt();

        System.out.println("Enter Second Number:");
        int b = sc.nextInt();

        int diff = Math.abs(a - b);

        if (diff == 0)
            System.out.println("Equal Numbers");
        else if (diff < 10)
            System.out.println("Close Numbers");
        else
            System.out.println("Far Apart");
    }
    
    public static void main(String[] args) {

        marksResult();
        fizzBuzz();
        rangeCheck();
        asciiCheck();
        multipleOfFive();
        bitCategory();
        attendanceCheck();
        numberDifference();

    }
}