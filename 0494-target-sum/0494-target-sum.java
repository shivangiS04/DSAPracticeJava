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

        // Create a DP array to store subproblem results
        // dp[i][j] means the number of ways to achieve sum j at index i
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        
        // Offset for handling negative sums, so sum can be stored in dp
        int offset = sum;
        
        // Initialize the base case: There's one way to get sum 0 (do nothing)
        dp[0][offset] = 1;
        
        // Fill the dp array
        for (int i = 0; i < nums.length; i++) {
            for (int curSum = -sum; curSum <= sum; curSum++) {
                int dpIndex = curSum + offset;
                if (dp[i][dpIndex] > 0) {
                    // If we can reach the current sum at index i, update the next index for +nums[i] and -nums[i]
                    dp[i + 1][dpIndex + nums[i]] += dp[i][dpIndex]; // Adding nums[i]
                    dp[i + 1][dpIndex - nums[i]] += dp[i][dpIndex]; // Subtracting nums[i]
                }
            }
        }
        
        // The answer is the number of ways to reach the target sum at the last index
        return dp[nums.length][target + offset];
    }
}
