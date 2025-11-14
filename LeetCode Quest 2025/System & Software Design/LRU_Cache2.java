class LFUCache {

    class Node {
        int key, value, freq;
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    private int capacity, minFreq = 0;
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Node>> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node);

        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(node);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;

        Node node = nodeMap.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // update existing
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        // evict LFU
        if (nodeMap.size() == capacity) {
            LinkedHashSet<Node> set = freqMap.get(minFreq);
            Node lfu = set.iterator().next();
            set.remove(lfu);

            if (set.isEmpty()) freqMap.remove(minFreq);

            nodeMap.remove(lfu.key);
        }

        // insert new node
        Node newNode = new Node(key, value);
        nodeMap.put(key, newNode);

        minFreq = 1;
        freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(newNode);
    }
}
