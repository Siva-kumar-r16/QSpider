package array;

public class ArrayMaster {

    public static void main(String[] args) {
        int[] myArray = {10, 3, 5, 8, 11, 4};
        
        System.out.print("Original Array: ");
        printArray(myArray);

        System.out.println("Sum of Even-Indexed Elements: " + sumEvenIndices(myArray));
        System.out.println("Sum of Prime Elements: " + sumPrimes(myArray));

        int[] reversedCopy = reverseWithNewArray(myArray);
        System.out.print("Reversed (New Array): ");
        printArray(reversedCopy);

        reverseInPlace(myArray);
        System.out.print("Reversed (In-Place): ");
        printArray(myArray);
    }

    public static int sumEvenIndices(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }

    public static int sumPrimes(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (isPrime(num)) sum += num;
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] reverseWithNewArray(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[i] = arr[arr.length - 1 - i];
        }
        return output;
    }

    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}