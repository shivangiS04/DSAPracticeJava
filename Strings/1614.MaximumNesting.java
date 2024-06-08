//time-complexity=O(n)
//space-complexity=O(m)

class Solution {
    public int maxDepth(String s) {
        int max = 0, curr = 0;

        // Iterate over each character in the string
        for (char ch : s.toCharArray()) {
            // If the character is an opening parenthesis, increment current depth
            if (ch == '(') {
                curr++;
                // Update max depth if current depth is greater than max depth
                if (curr > max) {
                    max = curr;
                }
            }
            // If the character is a closing parenthesis, decrement current depth
            else if (ch == ')') {
                curr--;
            }
        }
        
        // Return the maximum depth found
        return max;
    }
}
