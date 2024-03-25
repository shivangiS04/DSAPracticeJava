class solution {
    // Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data) {
        // Your code here
        Node newNode = new Node(data);
        Node temp = head_ref;
        
        if (head_ref == null) {
            head_ref = newNode;
            return;
        }
        
        if (pos == 0) {
            newNode.next = head_ref;
            head_ref.prev = newNode;
            head_ref = newNode;
            return;
        }
        
        int count = 1;
        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
}
