package array;

public class arrayOperation {
	
    public static boolean checkPalindrome(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i])
                return false;
        }

        return true;
    }

    public static void printPairs(int[] arr, int target) {

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " " + arr[j]);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No pair");
    }

    public static int[] mergeArrays(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++)
            c[i] = a[i];

        for (int i = 0; i < b.length; i++)
            c[a.length + i] = b[i];

        return c;
    }

    public static int[] digitSumArray(int[] arr) {

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int n = arr[i];
            int sum = 0;

            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            res[i] = sum;
        }

        return res;
    }
    
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 2, 1};
        int[] b = {5, 4, 3};
        int[] d = {12, 305};

        System.out.println(checkPalindrome(a));

        int target = 4;
        printPairs(a, target);

        int[] c = mergeArrays(a, b);
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");

        System.out.println();

        int[] res = digitSumArray(d);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}