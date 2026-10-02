package array;

public class sumOfEvenIndices {
    public static void main(String[] args) {

        int[] a = {12, 9, -2, 4, 6, 8};

        int sum = 0;

        for (int i = 0; i < a.length; i += 2) {
            sum += a[i];
        }

        System.out.println("Sum of even indices = " + sum);
    }
}