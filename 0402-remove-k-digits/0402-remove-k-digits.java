import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each digit in num
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            
            // Remove characters from the stack if they are greater than the current digit
            while(!stack.isEmpty() && k > 0 && ch < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        // Remove additional digits if k is still greater than 0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        
        // Construct the number from stack
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If the resulting string is empty, return "0"
        return (sb.length() == 0) ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3)); // Expected output: "1219"
        System.out.println(solution.removeKdigits("10200", 1));   // Expected output: "200"
        System.out.println(solution.removeKdigits("10", 2));      // Expected output: "0"
    }
}
