//about XOR operator 
//cases of XOR operator 
// A^A = 0(when same)
// 0^A = A(when not same)
// A^B^C = A^C 
//^ is used for XOR operator 

// best approach = XOR operator 
//Time-complexity = O(n)
// Space = O(1)
class Solution {
    public int singleNumber(int[] nums) {
        // Initialize sing with the first element of the array
        int sing = nums[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // XOR the current element with sing
            sing = sing ^ nums[i];
        }

        // Return the result which is the single number
        return sing;
    }
}
//second approach= brute force 
//The brute force approach involves comparing each element with every other element to check if it appears twice. 
//If it doesn’t appear twice, that is the single element.
//Time complexity = O(n^2)
//space complexity = O(1)

class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return -1; // This line should never be reached due to problem constraints
    }
}

//third approach 
//hashmap 
//The hash map approach uses a hash map (or dictionary) to count the occurrences of each element. 
//The element with a count of 1 is the single element.
//Time = O(n)
//space = O(n) (extra space is also used by)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // This line should never be reached due to problem constraints
    }
}
