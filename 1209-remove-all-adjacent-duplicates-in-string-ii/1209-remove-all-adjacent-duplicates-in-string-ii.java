class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().getKey() == c){
                int newCount = stack.peek().getValue() + 1;
                stack.pop();
                if(newCount < k){
                    stack.push(new Pair<>(c, newCount));
                }
            }else{
                stack.push(new Pair<>(c,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair<Character, Integer> entry : stack){
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));

        }
        return sb.toString();
        
    }
}