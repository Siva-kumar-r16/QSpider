package AcessingMembers;

class Beta {
    public static void main(String[] args) {
        
        System.out.println("Class name as reference: " + Alpha.x);

        Alpha obj = new Alpha();
        System.out.println("Object reference: " + obj.x);
    }
}