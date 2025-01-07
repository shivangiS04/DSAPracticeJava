class Solution {
    public List<String> stringMatching(String[] words) {
        // Sort the words array by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>();

        // Use two pointers to check for substrings
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Check if words[i] is a substring of words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further for this word
                }
            }
        }

        return result;
    }
}
