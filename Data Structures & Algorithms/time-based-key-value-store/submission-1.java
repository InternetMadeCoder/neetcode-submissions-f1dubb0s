class TimeStampedValue {
    public int timeStamp;
    public String value;

    public TimeStampedValue(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, ArrayList<TimeStampedValue>> map;

    public TimeMap() {
       map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timeStamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new TimeStampedValue(timeStamp, value));
    }
    
    public String get(String key, int timeStamp) {
        if(!map.containsKey(key)) return "";

        Optional<TimeStampedValue> ts = binarySearch(map.get(key), timeStamp);

        if(ts.isEmpty()) return "";

        return ts.get().value;
    }

    public Optional<TimeStampedValue> binarySearch(ArrayList<TimeStampedValue> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int matchIdx = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr.get(mid).timeStamp <= target) {
                low = mid + 1;
                matchIdx = mid;
            }
            else {
                high = mid - 1;
            }
        }

        if(matchIdx == -1) {
            return Optional.empty();
        }
        return Optional.of(arr.get(matchIdx));
    }
}
