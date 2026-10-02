package array;

public class ArrayOperations {

    public static void swapOddWithNext(int[] arr) {

        for (int i = 1; i < arr.length - 1; i += 2) {

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        System.out.println("After swapping:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void findMaxOddIndex(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null");
            return;
        }

        if (arr.length < 2) {
            System.out.println("No odd index element");
            return;
        }

        int max = arr[1];  

        for (int i = 3; i < arr.length; i += 2) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Max in odd index = " + max);
    }

    public static void printSecondHalfReverse(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null");
            return;
        }

        int mid = arr.length / 2;

        System.out.println("Second half in reverse:");

        for (int i = arr.length - 1; i >= mid; i--) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void sumFirstHalf(int[] arr) {

        int mid = arr.length / 2;
        int sum = 0;

        for (int i = 0; i < mid; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of first half = " + sum);
    }
    
    public static void shiftByN(int[] arr, int n) {


    	int len = arr.length;

        for (int i = len - 1; i >= n; i--) {
        	arr[i] = arr[i - n];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
    

        System.out.println("After shifting with zeros:");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void rotateByN(int[] arr, int n) {

        int len = arr.length;

        n = n % len;

        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[(i + n) % len] = arr[i];
        }

        System.out.println("After rotation:");
        for (int i = 0; i < len; i++) {
            System.out.print(temp[i] + " ");
        }
    }
    
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60, 70};

        shiftByN(a, 2);
        rotateByN(a, 2);

    }
}