import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Clone and sort the array to get the top-k largest values
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Step 2: Store the frequency of top-k elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = sorted.length - k; i < sorted.length; i++) {
            freqMap.put(sorted[i], freqMap.getOrDefault(sorted[i], 0) + 1);
        }

        // Step 3: Traverse original array and pick k elements in order
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
            if (result.size() == k) break; // stop once k elements are picked
        }

        // Step 4: Convert result list to array
        int[] resArray = new int[k];
        for (int i = 0; i < k; i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}
