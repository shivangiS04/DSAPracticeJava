import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int frq = 0, ele = nums.get(0), n = nums.size();

        // Step 1: Find the candidate for the dominant element using Boyer-Moore
        for (int num : nums) {
            if (frq == 0) {
                ele = num;
            }
            frq += (num == ele) ? 1 : -1;
        }

        // Step 2: Verify if `ele` is actually dominant
        frq = 0;
        for (int num : nums) {
            if (num == ele) {
                frq++;
            }
        }

        // Step 3: Find the minimum index where the array can be split
        int subfrq = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == ele) {
                subfrq++;

                // Check if both halves satisfy the dominance condition
                if (subfrq * 2 > (i + 1) && (frq - subfrq) * 2 > (n - (i + 1))) {
                    return i;
                }
            }
        }
        return -1;
    }
}