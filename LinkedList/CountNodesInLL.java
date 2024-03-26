class Solution {
    // Function to count nodes of a linked list.
    public static int getCount(Node head) {
        Node temp = head;
        int count = 0; // Changed initial count to 0 since there might be a case where head itself is null.
        while (temp != null) { // Corrected the condition here
            temp = temp.next;
            count++;
        }
        return count;
    }
}

    
