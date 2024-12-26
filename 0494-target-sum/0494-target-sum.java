class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    public int helper(int[] nums, int index, int curSum, int target) {
        // Base case: If we have considered all numbers
        if (index == nums.length) {
            // If the current sum equals the target, return 1, otherwise return 0
            if (curSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        // Recursive case: Consider both adding and subtracting the current number
        int left = helper(nums, index + 1, curSum + nums[index], target);  // Add current number
        int right = helper(nums, index + 1, curSum - nums[index], target); // Subtract current number

        // Return the sum of both choices
        return left + right;
    }
}
