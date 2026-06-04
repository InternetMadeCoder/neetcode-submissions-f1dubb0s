class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids) {
            boolean destroyed = false;


            // collision happens when one is moving right and the other is moving left
            while(!stack.isEmpty() && stack.peek()>0 && a<0) {
                int top = stack.peek();
                
                // if same size 
                if (Math.abs(a) == Math.abs(top)) { // both explode
                    destroyed = true; 
                    stack.pop();
                    break;
                }
                // if smaller
                else if(Math.abs(top) < Math.abs(a)) {
                    stack.pop();
                    // don't break, check further
                }
                else if(Math.abs(a) < Math.abs(top)) { 
                    destroyed = true; // current explodes
                    break;
                }
            }

            if(!destroyed) {
                stack.push(a);
            }
        }

        // convert stack to array
        int[] result = new int[stack.size()];
        for(int i=result.length-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}