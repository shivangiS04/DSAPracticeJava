class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();
        boolean[] inStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (inStack[c - 'a']) {
                continue;
            }

            while (stack.length() > 0 
                   && stack.charAt(stack.length() - 1) > c 
                   && lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                inStack[removed - 'a'] = false;
            }

            stack.append(c);
            inStack[c - 'a'] = true;
        }

        return stack.toString();
    }
}