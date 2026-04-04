class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();

        int num = 0; 

        for(char c : s.toCharArray()) {
            // build number
            if(Character.isDigit(c)) {
                num = (num * 10) + (c - '0');
            }
            // push the number when [ comes
            else if(c == '[') {
                numStack.push(num);
                num = 0;
                stringStack.push(c);
            }
            // normal character
            else if(c != ']') {
                stringStack.push(c);
            }
            // else decode
            else {
                // get the string inside []
                StringBuilder temp = new StringBuilder();
                while(stringStack.peek() != '[') {
                    temp.insert(0, stringStack.pop());
                }
                stringStack.pop(); // pop [

                // get the num from numStack
                int k = numStack.pop();
                // then repeat the string k times
                String repeated = temp.toString().repeat(k);
                // then push string back to stack
                for(char ch : repeated.toCharArray()) {
                    stringStack.push(ch);
                }
            }
        }

        // build final answer
        StringBuilder result = new StringBuilder();
        while(!stringStack.isEmpty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
}