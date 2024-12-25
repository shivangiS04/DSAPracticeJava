class MyHashMap {

    // Define the structure for a node in the linked list
    private class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of buckets (linked list heads)
    private Node[] buckets;
    private final int SIZE = 1000; // Number of buckets

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getBucketIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node prev = null, curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update value if key exists
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(key, value); // Add new node at the end
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value; // Return value if key is found
            }
            curr = curr.next;
        }

        return -1; // Return -1 if key is not found
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        Node curr = buckets[index];

        if (curr == null) return;

        if (curr.key == key) {
            buckets[index] = curr.next; // Remove head node
            return;
        }

        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next; // Remove the node
                return;
            }
            prev = curr;
            curr = curr.next;
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