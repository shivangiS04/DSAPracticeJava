class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // Row check
                if (!set.add(board[i][j] + " in row " + i)) {
                    return false;
                }
                // Column check
                if (!set.add(board[i][j] + " in col " + j)) {
                    return false;
                }
                // Sub-box check
                if (!set.add(board[i][j] + " in sub-box " + i / 3 + "-" + j / 3)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
