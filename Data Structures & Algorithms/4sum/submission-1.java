class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Long, List<int[]>> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long sum = (long) nums[i] + nums[j];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long sum = (long) nums[i] + nums[j];

                if(map.containsKey((long) target-sum)) {
                    for(int[] pair : map.get((long) target-sum)) {
                        int a = pair[0];
                        int b = pair[1];

                        if(a != i && a != j && b != i && b != j) {
                            List<Integer> quad = Arrays.asList(
                                nums[a], nums[b], nums[i], nums[j]
                            );
                            Collections.sort(quad);
                            result.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}