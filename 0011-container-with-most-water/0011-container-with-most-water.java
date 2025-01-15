class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the area and update max
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            // Move the pointer pointing to the shorter line inward
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max; // Return the maximum area
    }
}
