class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int totalOnes = 0;
        
        // Count total number of ones in the string
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }
        
        int leftZeros = 0;
        int rightOnes = totalOnes;
        int maxScore = 0;
        
        // Iterate through the string up to the second-to-last character
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            // Calculate the score and update the maximum score
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}