class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) { // Start from index 1, not 0
            if (nums[j] != nums[i]) { // Corrected comparison operator
                nums[++j] = nums[i];
            }
        }
        return j + 1; // Return the length of the new array
    }
}
