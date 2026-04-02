class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        for(String token : tokens) {
            // if token is not in operators
            if(operators.indexOf(token) == -1) {
                stack.push(Integer.parseInt(token));
            } 
            // if it is an operator
            else {
                int d1 = stack.pop();
                int d2 = stack.pop();
                int result = 0;

                switch(token) {
                    case "+":
                        result = d1 + d2;
                        break;
                    
                    case "-":
                        result = d2 - d1;
                        break;

                    case "*":
                        result = d1 * d2;
                        break;

                    case "/":
                        result = d2 / d1;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.peek();
    }
}
