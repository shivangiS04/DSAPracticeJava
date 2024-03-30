class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Step 1: Create a new dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // Pointer to keep track of traversal in the new list

        // Step 2: Merge the lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next; // Move to the next node in list l1
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next; // Move to the next node in list l2
            }
            current = current.next; // Move the current pointer to the newly added node
        }

        // Step 3: Copy the remaining nodes of list1 or list2 if any
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Step 4: Return the head of the new list (excluding dummy node)
        return dummy.next;
    }
}
