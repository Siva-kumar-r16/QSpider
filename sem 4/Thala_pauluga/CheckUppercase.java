package Thala_pauluga;

import java.util.Scanner;

public class CheckUppercase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Character: ");
        char ch = sc.next().charAt(0);

        if(ch >= 65 && ch <= 90)
            System.out.println("Uppercase letter");
    }
}