package methods;

public class Swap {
    public void swap(int a, int b) {
        System.out.println("a : " + a + "\tb: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a : " + a + "\tb: " + b);
    }

    public static void avg(int a, int b, int c) {
        float avg = (float) (a + b + c) / 3;
        System.out.println("Average : " + avg);
    }

    public static void pow(int a) {
        System.out.println("Number : " + a + "\tSquare : " + (a * a) + "\tCube : " + (a * a * a));
    }

    public void upperToLower(char a) {
        System.out.print("Current : " + a + "\t");
        a = (char) (a + 32); 
        System.out.println("Updated : " + a);
    }

    public static void main(String[] args) {
        int a = 5, b = 7;
        Swap s = new Swap();
        
        s.swap(a, b);
        System.out.println();
        
        avg(a, b, 5);
        System.out.println();
        
        pow(a);
        System.out.println();
        
        s.upperToLower('A'); 
    }
}
