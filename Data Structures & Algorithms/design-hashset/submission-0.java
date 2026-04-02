class MyHashSet {
    private int size = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[size];
        for(int i=0; i<size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];

        if(!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];

        if(bucket.contains(key)) {
            bucket.remove((Integer) key);
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];

        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */