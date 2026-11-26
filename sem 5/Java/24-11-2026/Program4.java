package pec.sem_5.day2;

public class Program4 {
	
	public static void m1() {
		System.out.println("m1 is executing");
		m3();
	}
	
	public static void m2() {
		System.out.println("M2 is executing");
		m1();
		System.out.println("hi");
	}
	
	public static void m3() {
		System.out.println("M3 is executing");
	}
	
	public static void main(String[] args) {
		System.out.println("Program start");
		m2();
		System.out.println("Program ends");
	}

}