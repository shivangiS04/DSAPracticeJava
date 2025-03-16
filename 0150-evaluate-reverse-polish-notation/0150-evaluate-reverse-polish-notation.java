class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a,b,token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
    public boolean isOperator(String token){
        return "+-*/".contains(token);
    }
    public int evaluate(int a, int b, String operator){
        switch(operator){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a/b;
            default: throw new IllegalArgumentException("Invalid Operator" + operator);
        }
    }
}