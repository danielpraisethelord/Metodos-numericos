public class PascalTriangle {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        int n = 20;
        int[][] pascal = new int[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j < n + i; j += 2) {
                if (j == n - i - 1 || j == n + i - 1) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (pascal[i][j] != 0) {
                    if (pascal[i][j] % 2 == 0) {
                        System.out.print(ANSI_RED + pascal[i][j] + ANSI_RESET);
                    } else {
                        System.out.printf("%4d", pascal[i][j]);
                    }
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}