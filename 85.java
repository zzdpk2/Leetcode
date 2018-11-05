import java.util.Arrays;

public class MaximalRectangle {

    // DP:(right[]-left[])*height[]
    public static void main(String[] args) {

    }

    public int MaximalRectangle(char[][] matrix) {
        int m = matrix.length;

        if (matrix == null || m == 0)
            return 0;
        int n = matrix[0].length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i <= n; i++)
            System.out.println(right[i]);

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            // height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
        }
    }

    public int MaximalRectangle2(char[][] matrix) {

    }

}