package arrayarrayarray;

public class ArrayOperations {

    public static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static double getAverage(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) getSum(arr) / arr.length;
    }

    public static int getLargest(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static int getSmallest(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public static int getCount(int[] arr) {
        return arr.length;
    }

    public static void printReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;
        for (int n : arr) {
            if (n % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + ", Odd: " + odd);
    }

    public static void countPosNeg(int[] arr) {
        int pos = 0, neg = 0;
        for (int n : arr) {
            if (n > 0) pos++;
            else if (n < 0) neg++;
        }
        System.out.println("Positive: " + pos + ", Negative: " + neg);
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) copy[i] = arr[i];
        return copy;
    }
}