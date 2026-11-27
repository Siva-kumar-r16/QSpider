package org.sem_5.day1;

public class Program1 {
	
	public static void main(String[] args) {
		int a=10;
		int b=20;
		if(a>b) {
			System.out.print(a+" is largest number");
		}
		else {
			System.out.print(b+" is largest number\n");
		}
		
		System.out.print(a>b?a:b);
	}
}
