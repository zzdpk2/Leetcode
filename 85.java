import java.util.Arrays;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class MaximalRectangle {

    // DP:(right[]-left[])*height[]
    public static void main(String[] args) {

    }

    public int MaximalRectangle(char[][] matrix) {

        // left[],from left to right, the first coordinate of '1'
        // right[],from right to left, the last coordinate of '1'
        // height[], thickness
        // res: (right[j] - left[j]) * height[j]
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
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(curLeft, left[j]);
                else {
                    left[j] = 0;
                    curleft = j + 1;
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1')
                        right[j] = Math.min(curRight, right[j])
                    else{
                        right[j] = n;
                        curRight = j;
                    }
                }
                for(int j = 0; j < n; j++)
                    res = Math.max(res, ((right[j] - left[j]) * height[j])); 
            }
            return result;
        }
    }

    public int MaximalRectangle2(char[][] matrix) {

    }

}