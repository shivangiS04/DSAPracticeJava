 public boolean isIdentical(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                // If data of corresponding nodes are not equal, return false
                return false;
            }
            // Move to next nodes
            head1 = head1.next;
            head2 = head2.next;
        }
        
        // If one list is longer than the other, they are not identical
        return head1 == null && head2 == null;
    }
