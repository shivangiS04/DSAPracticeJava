class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int nextIndex = (i + 1) % n; 
            int diff = Math.abs(nums[i] - nums[nextIndex]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
