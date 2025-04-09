class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        boolean[] seen = new boolean[101];
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] < k) {
                return -1;
            }

            if (seen[nums[i]] || nums[i] == k) {
                continue;
            }

            seen[nums[i]] = true;
            ++res;
        }

        return res;
    }
}