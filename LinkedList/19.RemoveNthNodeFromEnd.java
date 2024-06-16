class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0); // Initialize with a dummy value
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        // Move fast pointer n steps ahead
        for(int i = 1; i <= n; ++i) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the new head of the list
        return start.next;
    }
}
