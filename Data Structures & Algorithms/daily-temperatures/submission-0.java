class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // create result[] and initialize with 0
        int[] result = new int[temperatures.length];
        for(int i=0; i<result.length; i++) {
            result[i] = 0;
        }

        Stack<Integer> stack = new Stack<>(); // stores indices
        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
