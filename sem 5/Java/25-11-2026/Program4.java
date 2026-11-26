package pec.sem_5.day3;

public class Program4{
    public static int[] revArray(int[] arr) {
        int[] revarr = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            revarr[j] = arr[i];
        }
        return revarr;
    }
    
    public static void revArrayFast(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        revArrayFast(arr);
        
        for(int i:arr)
        	System.out.println(i);
        
    }
}