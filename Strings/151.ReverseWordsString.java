//time=O(n)
//space=O(n)
class Solution {
    public String reverseWords(String s) {
        // Split the string into words using one or more spaces as the delimiter
        String[] words = s.trim().split("\\s+");

        // Create a StringBuilder to build the reversed words string
        StringBuilder reversedString = new StringBuilder();

        // Iterate over the words array from the end to the beginning
        for (int i = words.length - 1; i >= 0; i--) {
            // Append each word to the StringBuilder
            reversedString.append(words[i]);
            // Add a space between words except after the last word
            if (i != 0) {
                reversedString.append(" ");
            }
        }

        // Convert the StringBuilder to a string and return it
        return reversedString.toString();
    }
}
