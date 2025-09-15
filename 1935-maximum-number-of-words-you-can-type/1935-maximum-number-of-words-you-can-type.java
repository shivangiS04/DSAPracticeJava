class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                for (char b : brokenLetters.toCharArray()) {
                    if ((int)c == (int)b) {
                        canType = false;
                        break;
                    }
                }
                if (!canType) break;
            }
            if (canType) count++;
        }
        return count;
    }
}
