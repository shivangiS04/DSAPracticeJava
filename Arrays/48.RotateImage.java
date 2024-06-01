
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n + 1) / 2; i++){
            for(int j = 0; j < n / 2; j++){
                // start 4 way swaps
                // temp = top left
                int temp = matrix[i][j];
                // top left = bottom left
                matrix[i][j] = matrix[n - j - 1][i];
                // bottom left = bottom right
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                // bottom right = top right
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                // top right = top left
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
