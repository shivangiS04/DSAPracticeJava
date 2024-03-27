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
        // If both lists reach the end, they are identical
        if (head1 == null && head2 == null) {
            System.out.println("Identical");
            return true;
        } else {
            System.out.println("Not Identical");
            return false;
        }
    }
