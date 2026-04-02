class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Index = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            nums1Index.put(nums1[i], i);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<result.length; i++) {
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int num : nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                int val = stack.pop();
                int index = nums1Index.get(val);
                result[index] = num;
            }
            if(nums1Index.containsKey(num)) {
                stack.push(num);
            }
        }

        return result;
    }
}