package Thala_pauluga;
public class CalculateTotalAndAverageMarks{
	public static void main(String[] args) {
	
		double tamil=90,english=80,maths=80,science=94,socialScience=89;
		double totalMark=tamil+english+maths+science+socialScience;
		double avgMark=totalMark/5;
		double percentage = (totalMark*100)/500;
	
		System.out.println("Total Mark  : "+totalMark);
		System.out.println("Average Mark : "+avgMark);
		System.out.println("Percentage : "+percentage+"%");
	}
}
