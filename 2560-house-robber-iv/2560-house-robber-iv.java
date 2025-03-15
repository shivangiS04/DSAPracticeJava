class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canRobAtLeastK(nums, k, mid)) {
                right = mid; //LOWER CAPABILITY
            } else {
                left = mid + 1; //HIGHER CAPABILITY
            }
        }
        
        return left;
    }
    
    private boolean canRobAtLeastK(int[] nums, int k, int capability) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i++; //ADJACENT SKIP
            }
            i++;
        }
        
        return count >= k;
    }
}