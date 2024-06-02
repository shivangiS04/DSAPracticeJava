//time-complexity=0(logn)
//space-complexity=0(1)
//based on binary search which works on the principle of divide and conquer principle 
//of the array by finding the mid index and comparing rest of array accordingly

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low; // Make sure to close the method properly.
    }
}
