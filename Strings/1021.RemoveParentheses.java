//time complexity= O(n)
//space complexity= O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();// Initialize a stack to keep track of parentheses
        StringBuilder sb = new StringBuilder();// Initialize a StringBuilder to build the result string

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Only append the character if the stack is not empty
                // which means it's not an outermost '('
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
                st.push(ch);
            } else if (ch == ')') {
                st.pop();
                // Only append the character if the stack is not empty
                // which means it's not an outermost ')'
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
