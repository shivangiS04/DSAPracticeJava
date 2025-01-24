/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast;
        
        while (curr != null) { // Traverse the list
            fast = curr.next;  // Save the next node
            curr.next = prev;  // Reverse the link
            prev = curr;       // Move prev to the current node
            curr = fast;       // Move curr to the next node
        }
        
        return prev; // prev will be the new head of the reversed list
    }
}
