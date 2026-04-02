class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count frequency
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // make list based on frequency
        List<Integer> list = new ArrayList<>();

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
            list.add(it.next());
        }

        // sort list in descending
        Collections.sort(list, (a, b) -> map.get(b)-map.get(a));
        
        // return top k elements
        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
