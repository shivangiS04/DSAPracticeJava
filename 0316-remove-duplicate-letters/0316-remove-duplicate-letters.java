class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        StringBuilder stack = new StringBuilder();
        Set<Character> inStack = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (inStack.contains(c)) {
                continue;
            }

            while (stack.length() > 0
                   && stack.charAt(stack.length() - 1) > c
                   && lastIndex.get(stack.charAt(stack.length() - 1)) > i) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                inStack.remove(removed);
            }

            stack.append(c);
            inStack.add(c);
        }

        return stack.toString();
    }
}