package pattern;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                if (j+i==n+1)
                    System.out.print("🦁 🏆 count->"+i);
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}