//time-O(logn)
//space=O(1)
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length < 2) { // Handle arrays with less than 2 elements
            return nums.length == 1 && nums[0] == target;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check for target at middle, first, or last element
            if (nums[mid] == target || nums[low] == target || nums[high] == target) {
                return true;
            }

            // Handle duplicates (skip duplicates while searching)
            while (low < mid && nums[low] == nums[mid]) {
                low++;
            }
            while (high > mid && nums[high] == nums[mid]) {
                high--;
            }

            // Decide which half to search based on sortedness and target value
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) { // Corrected condition
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
