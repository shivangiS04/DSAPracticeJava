class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        
        int cs = 0;
        for (int i = 0; i < k; i++) {
            cs += nums[i];
        }
        sums[0] = cs;
        
        for (int i = 1; i < sums.length; i++) {
            cs += nums[i + k - 1] - nums[i - 1];
            sums[i] = cs;
        }
        
        int[] left = new int[sums.length];
        int[] right = new int[sums.length];
        
        int mi = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[mi]) {
                mi = i;
            }
            left[i] = mi;
        }
        
        mi = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[mi]) {
                mi = i;
            }
            right[i] = mi;
        }
        
        int ms = 0;
        int[] result = new int[3];
        
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - k];
            int r = right[i + k];
            int ts = sums[l] + sums[i] + sums[r];
            if (ts > ms) {
                ms = ts;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }
        
        return result;
    }
}