class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int left = n-1, right = 0 , up = m-1, down = 0;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1){
                    left = Math.min(left,j);
                    right = Math.max(right,j);
                    up = Math.min(up,i);
                    down = Math.max(down,i);
                }
            }
        }
        int area = (down-up+1) * (right-left+1);
        return area;
    }
}