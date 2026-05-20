class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;

        for(int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }

        while(minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;

            if(canShipInTime(weights, days, mid)) {
                maxCapacity = mid;
            } 
            else {
                minCapacity = mid + 1;
            }
        }
        return minCapacity;
    }

    public boolean canShipInTime(int[] weights, int days, int minCapacity) {
        int day = 1;
        int sum = 0;

        for(int weight : weights) {
            if(sum + weight > minCapacity) {
                day++;
                sum = 0;
            }
            sum += weight;
        }
        return day <= days;
    }
}