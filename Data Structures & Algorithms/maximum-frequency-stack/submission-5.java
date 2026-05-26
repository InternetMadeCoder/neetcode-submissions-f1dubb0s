class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, freq);

        maxFreq = Math.max(freq, maxFreq);

        freqStack.putIfAbsent(freq, new Stack<>());
        freqStack.get(freq).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = new Stack<>();
        stack = freqStack.get(maxFreq);
        int top = stack.pop();

        if(stack.isEmpty()) maxFreq--;

        freqMap.put(top, freqMap.get(top)-1);

        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */