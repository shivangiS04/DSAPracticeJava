class GfG {
    boolean isCircular(Node head) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            if (temp == head) {
                return true;
            }
        }
        return false;
    }
}

