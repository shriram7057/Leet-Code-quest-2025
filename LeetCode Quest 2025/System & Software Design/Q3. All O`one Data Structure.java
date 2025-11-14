class AllOne {

    class Node {
        int count;
        Set<String> keys = new HashSet<>();
        Node prev, next;

        Node(int count) {
            this.count = count;
        }
    }

    private Node head, tail;
    private Map<String, Node> keyMap;

    public AllOne() {
        keyMap = new HashMap<>();

        head = new Node(Integer.MIN_VALUE); // dummy head
        tail = new Node(Integer.MAX_VALUE); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    private Node insertAfter(Node node, int count) {
        Node newNode = new Node(count);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        return newNode;
    }

    private void removeNodeIfEmpty(Node node) {
        if (!node.keys.isEmpty()) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!keyMap.containsKey(key)) {
            // add as count = 1
            Node first = head.next;
            if (first == tail || first.count > 1) {
                first = insertAfter(head, 1);
            }
            first.keys.add(key);
            keyMap.put(key, first);
        } else {
            Node curr = keyMap.get(key);
            int newCount = curr.count + 1;

            Node next = curr.next;
            if (next == tail || next.count > newCount) {
                next = insertAfter(curr, newCount);
            }

            next.keys.add(key);
            keyMap.put(key, next);

            curr.keys.remove(key);
            removeNodeIfEmpty(curr);
        }
    }

    public void dec(String key) {
        if (!keyMap.containsKey(key)) return;

        Node curr = keyMap.get(key);

        if (curr.count == 1) {
            // remove key entirely
            keyMap.remove(key);
            curr.keys.remove(key);
            removeNodeIfEmpty(curr);
            return;
        }

        int newCount = curr.count - 1;

        Node prev = curr.prev;
        if (prev == head || prev.count < newCount) {
            prev = insertAfter(curr.prev, newCount);
        }

        prev.keys.add(key);
        keyMap.put(key, prev);

        curr.keys.remove(key);
        removeNodeIfEmpty(curr);
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}
