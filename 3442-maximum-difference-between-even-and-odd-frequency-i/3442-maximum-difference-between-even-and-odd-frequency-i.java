import java.util.HashMap;

class Solution {
    public int maxDifference(String s) {
        // Step 1: Count frequencies using a HashMap
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find max odd frequency and min even frequency
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int freq : freqMap.values()) {
            if (freq % 2 == 1) { // Odd
                maxOdd = Math.max(maxOdd, freq);
            } else { // Even
                minEven = Math.min(minEven, freq);
            }
        }

        // Step 3: Return the difference
        return maxOdd - minEven;
    }
}
