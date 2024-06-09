//time=O(nlogn)
//space=O(n)


import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Create a frequency map to count the occurrences of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a list from the frequency map entries and sort it by the frequency in descending order
        List<Map.Entry<Character, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Build the resulting string based on the sorted list
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : frequencyList) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }
}
