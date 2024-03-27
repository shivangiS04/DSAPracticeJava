class Solution {
    // Function to insert a node at the beginning of the linked list.
    public Node insertAtBeginning(Node head, int x) {
        Node new_node = new Node(x);
        new_node.next = head;
        head = new_node;
        return head;
    }

    // Function to insert a node at the end of the linked list.
    public Node insertAtEnd(Node head, int x) {
        Node new_node = new Node(x);
        if (head == null) {
            head = new_node;
            return head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
            return head;
        }
    }
}
