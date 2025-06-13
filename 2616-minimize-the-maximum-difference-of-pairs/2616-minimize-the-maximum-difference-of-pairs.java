import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);  // Step 1: Sort the array
        
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int ans = high;

        // Step 2: Binary search over the answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFormPairs(nums, p, mid)) {
                ans = mid;
                high = mid - 1;  // Try smaller max difference
            } else {
                low = mid + 1;   // Increase the allowed difference
            }
        }

        return ans;
    }

    // Step 3: Greedy check
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2;  // Skip the next index to avoid overlap
            } else {
                i++;
            }
            if (count >= p) return true;
        }

        return count >= p;
    }
}
