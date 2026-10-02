package DecisionMaking;

public class AllDigitsEven {

    static boolean allEven(int n) {

        while (n > 0) {
            if ((n % 10) % 2 != 0)
                return false;

            n /= 10;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("125 is "+ allEven(125));
        System.out.println("226 is "+ allEven(226));
        
    }

}