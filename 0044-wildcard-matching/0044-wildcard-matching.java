class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p == null || p.length() == 0) {
            return s.length() == 0;
        }
        
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Fill the first row for patterns starting with '*'
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) != '*') {
                    if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // '*' can match zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
