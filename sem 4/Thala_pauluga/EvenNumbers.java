package Thala_pauluga;

public class EvenNumbers {

    public static void main(String[] args) {

        printEven();

    }

    static void printEven()
    {
        for(int i = 1; i < 100; i++){
            if(i % 2 == 0)
                System.out.println(i);
        }
    }
}