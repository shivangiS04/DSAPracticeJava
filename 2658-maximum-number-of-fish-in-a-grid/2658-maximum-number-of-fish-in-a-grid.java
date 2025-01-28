class Solution {
    public static int count=0;
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&&grid[i][j]>0){
                     count=0;
                    util(i,j,grid,vis);
                    max=Math.max(count,max);
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    public static int util(int r,int c,int grid[][],boolean vis[][]){
        if(grid[r][c]>0&&vis[r][c]!=true){
            vis[r][c]=true;
         count+=grid[r][c];
        int row[]={0,1,0,-1};
        int col[]={1,0,-1,0};
        for(int i=0;i<4;i++){
            int newr=r+row[i];
            int newc=c+col[i];
          if(newr>=0&&newr<grid.length&&newc>=0&&newc<grid[0].length&&grid[newr][newc]>0){
            util(newr,newc,grid,vis);
          }

        }
        }
return count;
    }
}