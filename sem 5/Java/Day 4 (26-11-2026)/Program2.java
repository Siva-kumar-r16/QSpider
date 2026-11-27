package pec.sem_5.day4;

public class Program2 {
	
	int age;
	String name;
	
	void study() {
		System.out.println("Studing");
	}
	
	public static void main(String[] args) {
		Program2 s1 = new Program2();
		Program2 s2 = new Program2();

		System.out.println(s1.age);
		System.out.println(s1.name);
		System.out.println(s1==s2);//false
	}

}
