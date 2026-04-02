class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = map.keySet().iterator();

        while(it.hasNext()) {
            int key = it.next();
            if(map.get(key) > nums.length/3) {
                result.add(key);
            }
        }

        return result;
    }
}