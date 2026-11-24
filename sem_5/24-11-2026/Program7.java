package pec.sem_5.day2;
import java.util.Scanner;
public class Program7 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int arr[]={2,5,8,13,11};
		
		System.out.print("Enter the value to find index : ");
		int f=sc.nextInt(),found=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==f) {
				System.out.println("index of "+f+" is "+i);
				}
		}
		
		if(found==0)
			System.out.print("Number not Found!!");
		
		sc.close();
	}

}
