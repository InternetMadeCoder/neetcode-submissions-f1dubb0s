class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();

        for(String s : strs) {
            int[] frequency = new int[26];
            
            for(int i=0; i<s.length(); i++) {
                frequency[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : frequency) {
                sb.append(i);
                sb.append("#");
            }
            String key = sb.toString();

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
