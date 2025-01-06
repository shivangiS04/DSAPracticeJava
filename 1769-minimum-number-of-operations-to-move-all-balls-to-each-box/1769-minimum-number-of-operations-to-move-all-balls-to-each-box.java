class Solution {
    public int[] minOperations(String boxes) {
    int n = boxes.length();
    int[] left = new int[n];
    int[] right = new int[n];

    int countBoxes = 0;
    int sum = 0;

    // Calculate left moves
    for (int i = 0; i < n; i++) {
        left[i] = sum; // Store the current sum for left moves
        if (boxes.charAt(i) == '1') {
            countBoxes++;
        }
        sum += countBoxes; // Increment sum by the number of '1's seen so far
    }

    countBoxes = 0; // Reset count for right side
    sum = 0; // Reset sum for right side

    // Calculate right moves
    for (int i = n - 1; i >= 0; i--) {
        right[i] = sum; // Store the current sum for right moves
        if (boxes.charAt(i) == '1') {
            countBoxes++;
        }
        sum += countBoxes; // Increment sum by the number of '1's seen so far
    }

    // Combine left and right moves into the result array
    for (int i = 0; i < n; i++) {
        left[i] += right[i];
    }

    return left; // Return the combined result
    }
}