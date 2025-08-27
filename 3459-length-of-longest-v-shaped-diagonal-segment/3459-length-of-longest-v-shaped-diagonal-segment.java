class Solution {
    int [][] directions = {{1,1},{1,-1},{-1,-1},{-1,1}};
    int m, n;
    int[][][][] t;

    private int nextVal(int v) {
        if (v == 1) return 2;
        if (v == 2) return 0;
        return 2;
    }

    private int solve(int i, int j, int d, int canTurn, int val, int[][] grid){
        int i_ = i + directions[d][0];
        int j_ = j + directions[d][1];
        if(i_ < 0 || i_ >= m || j_ < 0 || j_ >= n || grid[i_][j_] != val){
            return 0;
        } 
        if(t[i_][j_][d][canTurn] != -1){
            return t[i_][j_][d][canTurn];
        }

        int next = nextVal(val);
        int result = 0;

        int keepMoving = 1 + solve(i_, j_, d, canTurn, next, grid);
        result = Math.max(result, keepMoving);

        if (canTurn == 1) {
            int turnAndMove = 1 + solve(i_, j_, (d + 1) % 4, 0, next, grid);
            result = Math.max(result, turnAndMove);
        }

        return t[i_][j_][d][canTurn] = result;
    }

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        t = new int[m][n][4][2]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    for (int c = 0; c < 2; c++) {
                        t[i][j][d][c] = -1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        result = Math.max(result, 1 + solve(i, j, d, 1, 2, grid));
                    }
                }
            }
        }
        return result;        
    }
}
