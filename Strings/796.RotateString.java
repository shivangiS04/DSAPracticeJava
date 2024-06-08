//time complexity-O(n)
//space complexity-O(n)
class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if the lengths of s and goal are equal.
        // If they are not equal, s cannot be rotated to become goal.
        // If they are equal, proceed to the next check.
        return (s.length() == goal.length() && 
                // Concatenate s with itself and check if the resulting string contains goal.
                // If goal is a rotation of s, it must appear as a substring within s+s.
                (s + s).contains(goal));
    }
}
