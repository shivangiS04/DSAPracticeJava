//time complexity = O(NlogN + m)
// space complexity = O(m) 
// m is the size of the hashmap
// N is the number of elements in the array
// m = n/2 +1
import java.util.HashMap;

class Solution {
    // Method to find the single number
    public int singleNumber(int[] nums) {
        // Create a HashMap to store the count of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Iterate through the array and count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Iterate through the HashMap to find the number with a count of 1
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        
        // Return -1 if no single number found (this should not happen based on the problem statement)
        return -1;
    }
}
