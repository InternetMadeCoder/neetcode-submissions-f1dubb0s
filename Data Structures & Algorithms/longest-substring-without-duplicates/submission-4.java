class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();

        int result = 0;
        boolean[] visited = new boolean[256];

        int left = 0, right = 0;

        while(right < s.length()) {
            // if a char is visited, move left pointer forward
            // and mark all visited char as false
            while(visited[s.charAt(right)] == true) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true; // mark as visited
            result = Math.max(result, (right - left + 1));
            right++;
        }
        return result;
    }
}
