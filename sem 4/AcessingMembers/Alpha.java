package AcessingMembers;

public class Alpha {
    public static int x = 10;

    public static void main(String[] args) {
    	
        System.out.println("Direct access : " +x); 

        System.out.println("class name as reference : "+Alpha.x);

        Alpha obj = new Alpha();
        System.out.println("object reference : "+obj.x);
    }
}