public static Node reverseDLL(Node  head)
{
    //Your code here
     Node  curr = head ; 
      Node prev = null ; 
       Node next ; 
        while(curr != null){
             next = curr.next ; 
              curr.next = prev ; 
              curr.prev = next ; 
               
                prev = curr ; 
                curr = next ; 
        } 
         head = prev ; 
         return head ; 
}
