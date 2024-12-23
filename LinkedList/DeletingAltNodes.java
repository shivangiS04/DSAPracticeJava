class Solution {
    
    public void deleteAlternate(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }
}
