package Thala_pauluga;

import java.util.Scanner;

public class LargeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no : ");

        int n = sc.nextInt();
        n++;

        if(n> 100)
            System.out.println("Large number");
    }
}