// time complexity = O(n)
//space comeplexity = 0(n)
// rearrangement in the same array will make the space complexity of 0(1)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store rearranged elements, with the same length as the input array
        int arr[] = new int[nums.length];
        
        // Initialize two pointers to keep track of the even and odd indices in the new array
        int j = 0; // Pointer for even indices
        int k = 1; // Pointer for odd indices
        
        // Iterate through the elements of the input array
        for(int i = 0; i < nums.length; i++) {
            // Check if the current element is greater than 0 (positive)
            if(nums[i] > 0) {
                // If the current element is positive, place it at the even index in the new array
                arr[j] = nums[i];
                // Move the even index pointer by 2 positions to maintain even spacing
                j += 2; 
            } else {
                // If the current element is non-positive, place it at the odd index in the new array
                arr[k] = nums[i];
                // Move the odd index pointer by 2 positions to maintain odd spacing
                k += 2;
            }
        }
        
        // Return the rearranged array
        return arr;
    }
}
