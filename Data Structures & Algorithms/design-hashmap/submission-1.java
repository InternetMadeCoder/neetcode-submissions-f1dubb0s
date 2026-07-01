class MyHashMap {
    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int size = 1000;
    private List<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[size];
        for(int i=0; i<size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        List<Node> bucket = buckets[index];

        for(Node node : bucket) {
            if(node.key == key) {
                node.value = value; // update
                return;
            }
        }
        bucket.add(new Node(key, value)); // insert
    }
    
    public int get(int key) {
        int index = hash(key);
        List<Node> bucket = buckets[index];

        for(Node node : bucket) {
            if(node.key == key) {
                return node.value;
            }
        }
        return -1; // not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Node> bucket = buckets[index];

        Iterator<Node> it = bucket.iterator();
        while(it.hasNext()) {
            if(it.next().key == key) {
                it.remove();
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */