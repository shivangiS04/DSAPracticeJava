class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the head of even list

        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link to the next odd node
            odd = odd.next; // Move odd pointer forward

            even.next = even.next.next; // Link to the next even node
            even = even.next; // Move even pointer forward
        }

        odd.next = evenHead; // Link the end of odd list to the head of even list

        return head;
    }
}
