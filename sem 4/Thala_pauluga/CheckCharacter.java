package Thala_pauluga;

import java.util.Scanner;

public class CheckCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Character : ");
        char ch = sc.next().charAt(0);

        if(ch >= 'A' && ch <= 'Z')
        {
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                System.out.println("Uppercase Vowel");
            else
                System.out.println("Uppercase Consonant");
        }
        else if(ch >= 'a' && ch <= 'z')
        {
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                System.out.println("Lowercase Vowel");
            else
                System.out.println("Lowercase Consonant");
        }
        else if(ch >= '0' && ch <= '9')
        {
            System.out.println("Numeric Character");
        }
        else  
        {
            System.out.println("Special Character");
        }
    }
}