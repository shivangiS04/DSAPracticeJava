import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set to store banned numbers
        Set<Integer> bannedSet = new HashSet<>();
        for (int ban : banned) {
            bannedSet.add(ban);
        }

        int count = 0;    // To count valid numbers
        int currSum = 0;  // To keep track of the current sum

        // Iterate over numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip numbers that are banned
            if (bannedSet.contains(i)) {
                continue;
            }

            // Add the number if it doesn't exceed maxSum
            if (currSum + i <= maxSum) {
                currSum += i;
                count++;
            } else {
                // Stop if adding the number exceeds maxSum
                break;
            }
        }

        return count;
    }
}
