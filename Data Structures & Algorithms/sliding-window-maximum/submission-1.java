class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // deque stores indices not values
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        // setup deque for first k elements
        for(int i=0; i<k; i++) {
            // remove all elements smaller from the back
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[0] = nums[deque.peekFirst()];

        // setup deque for the rest of the elements
        for(int i=k; i<n; i++) {
            // remove the first element if it slid out of the window
            if(deque.peekFirst() <= i-k) deque.pollFirst();

            // remove all elements smaller from the back
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // add current element's index
            deque.offerLast(i);

            result[i - k + 1] =nums[deque.peekFirst()];
        }
        return result;
    }
}
