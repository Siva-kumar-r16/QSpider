package pec.sem_5.day2;

public class Program1 {
	public static void test() {
		System.out.println("Test is running");
	}
	
	public void run() {
		System.out.println("Running");
	}
	
	public static void main(String[] args) {
		test();
		//run(); can't non static method belongs to objects not to class
		
		Program1 obj=new Program1();
		obj.run();
	}
}
