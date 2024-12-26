class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Calculate the sum of all elements
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the absolute target is greater than the total sum or the sum is not possible, return 0
        if (Math.abs(target) > sum) {
            return 0;
        }

        // Create a DP array to store subproblem results for the current sum
        int[] dp = new int[2 * sum + 1];
        
        // Offset for handling negative sums, so sum can be stored in dp
        int offset = sum;
        
        // Initialize the base case: There's one way to get sum 0 (do nothing)
        dp[offset] = 1;
        
        // Fill the dp array
        for (int num : nums) {
            // Create a new temporary array to store the updated dp results
            int[] nextDp = new int[2 * sum + 1];
            
            // For each possible sum, update the nextDp array
            for (int curSum = -sum; curSum <= sum; curSum++) {
                int dpIndex = curSum + offset;
                if (dp[dpIndex] > 0) {
                    nextDp[dpIndex + num] += dp[dpIndex]; // Adding num
                    nextDp[dpIndex - num] += dp[dpIndex]; // Subtracting num
                }
            }
            
            // Move to the next iteration, set dp to nextDp
            dp = nextDp;
        }
        
        // The answer is the number of ways to reach the target sum
        return dp[target + offset];
    }
}
