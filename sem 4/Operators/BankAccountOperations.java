package Operators;

public class BankAccountOperations {
	public static void main(String[] args) {
		int balance=5000;
		balance-=500;
		System.out.println("Trnafering 500...\nBalance :"+balance);
		balance+=700;
		System.out.println("\nCrediting 700...\nBalance :"+balance);
		balance-=1000;
		System.out.println("\nDebeting 1000...\nBalance :"+balance);
		balance-=750;
		System.out.println("\nRecharging 750...\nBalance :"+balance);
		System.out.println("\n\nFinal Balance"+balance);

		
	}

}
