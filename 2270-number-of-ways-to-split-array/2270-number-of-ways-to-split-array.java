class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long sumC = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            sumC += nums[i];
            long sumR = totalSum - sumC;
            if (sumC >= sumR) {
                count++;
            }
        }
        
        return count;
    }
}
