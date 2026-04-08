class Solution {
    public int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = numbers.length-1;

        for(int i=0; i<numbers.length; i++) {
            int currSum = numbers[left] + numbers[right];
            if(currSum == target) {
                list.add(left+1);
                list.add(right+1);
                break;
            }
            else if(currSum < target) left++;
            else right--;
        }

        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
