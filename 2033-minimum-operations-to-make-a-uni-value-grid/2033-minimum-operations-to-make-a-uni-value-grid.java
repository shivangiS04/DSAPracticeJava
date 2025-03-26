class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int rem = grid[0][0] % x;
        int k = 0;
        for(int i = 0; i < m; i++ ){
            for(int j=0; j<n; j++){
                if(grid[i][j]%x != rem) return -1;
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int med = arr[k/2];
        int op = 0;
        for(int i = 0; i<k; i++){
            int num = Math.abs(arr[i]-med);
            op += num/x;
        }
        
        return op;
    }
}