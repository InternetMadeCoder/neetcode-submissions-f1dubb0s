class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            // start only if it is the beginning of the sequence
            if(!set.contains(num-1)) {
                int curr = num;
                int length = 1;

                while(set.contains(curr+1)) {
                    length++;
                    curr++;
                }
                longestLength = Math.max(longestLength, length);
            }
        }

        return longestLength;
    }
}
