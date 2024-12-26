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

        // Initialize a DP array to store the number of ways to reach a particular sum
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;  // There's one way to make a sum of 0 (by doing nothing)

        // Process each number in the input array
        for (int num : nums) {
            // We will update the dp array in reverse order to avoid overwriting values that we still need to use
            // Use a temporary array to store results for the current iteration
            int[] nextDp = new int[2 * sum + 1];
            
            // Traverse the dp array and calculate new sums
            for (int curSum = -sum; curSum <= sum; curSum++) {
                if (dp[curSum + sum] > 0) { // Check if current sum is achievable
                    // Add the number to the current sum
                    nextDp[curSum + num + sum] += dp[curSum + sum];
                    // Subtract the number from the current sum
                    nextDp[curSum - num + sum] += dp[curSum + sum];
                }
            }
            dp = nextDp; // Move to the next dp array
        }

        // Return the number of ways to reach the target sum
        return dp[target + sum];
    }
}
