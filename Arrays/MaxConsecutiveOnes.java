// time complexity= O(n)
// space complexity = 0(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Initialize variables
        int cnt = 0; // Count of consecutive ones
        int maxi = 0; // Maximum consecutive ones encountered so far

        // Loop through the array
        for(int i = 0; i < nums.length; i++) {
            // If the current element is 1
            if(nums[i] == 1) {
                cnt++; // Increment the consecutive ones count
            } else { 
                // If the current element is not 1 (i.e., 0)
                cnt = 0; // Reset the consecutive ones count
            }

            // Update the maximum consecutive ones count
            maxi = Math.max(maxi, cnt);
        }

        // Return the maximum consecutive ones count
        return maxi;
    }
}
