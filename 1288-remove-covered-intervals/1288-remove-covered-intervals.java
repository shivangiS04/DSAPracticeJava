import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        // Sort by start ascending.
        // If starts are the same, sort by end descending.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int maxEnd = -1;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                // Not covered
                count++;
                maxEnd = interval[1];
            }
            // Else: covered, so do nothing
        }

        return count;
    }
}