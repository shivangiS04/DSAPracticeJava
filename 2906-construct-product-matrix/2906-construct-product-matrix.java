import java.util.Arrays;

public class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] Ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Ans[i][j] = 1;
            }
        }

        long Mul = 1; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Ans[i][j] = (int) (Ans[i][j] * Mul % mod); 
                Mul = Mul * grid[i][j] % mod; 
            }
        }

        Mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                Ans[i][j] = (int) (Ans[i][j] * Mul % mod); 
                Mul = Mul * grid[i][j] % mod; 
            }
        }

        return Ans; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] result = solution.constructProductMatrix(grid);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
