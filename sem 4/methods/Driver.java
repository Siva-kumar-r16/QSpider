package methods;

public class Driver {
    
    public static void ThirdSemGrade() {
        System.out.println("3rd Semester Grades");
        System.out.println("DM: C");
        System.out.println("DS: A+");
        System.out.println("OOSE: A+");
        System.out.println("DPCA: B");
        System.out.println("DBMS: B+");
        System.out.println("");
        System.out.println("GPA: 7.9");
    }
    
    public static void BioData(String name, String mailid, String favHero, String favFood) {
        System.out.println("My BioData");
        System.out.println("Name: " + name);
        System.out.println("Email: " + mailid);
        System.out.println("Favorite Hero: " + favHero);
        System.out.println("Favorite Food: " + favFood);
    }
    
    public void car() {
        System.out.println("Volkswagen");
    }

    public static void main(String[] args) {
        ThirdSemGrade();
        
        System.out.println(); 
        
        BioData("Siva kumar", "sirsivakumar@outlook.com", "Loki", "Parotta");
        
        Driver d = new Driver();
        d.car();
    }
}