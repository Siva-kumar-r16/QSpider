package array;

public class SecondSmallest {

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 2, 3};

        int result = secondSmallest(arr);

        if (result == -1)
            System.out.println("No second smallest number");
        else
            System.out.println("Second smallest: " + result);
    }

    static int secondSmallest(int[] arr) {

        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                second = min;
                min = arr[i];
            }
            else if (arr[i] > min && arr[i] < second) {
                second = arr[i];
            }
        }

        if (second == Integer.MAX_VALUE)
            return -1;
        else
            return second;
    }
}