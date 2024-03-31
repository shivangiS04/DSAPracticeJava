public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ArrayList<ListNode> arr1 = new ArrayList<>();
       ArrayList<ListNode> arr2 = new ArrayList<>();
       while(headA!=null){
           arr1.add(headA);
           headA = headA.next;
       }
       while(headB!=null){
           arr2.add(headB);
           headB= headB.next;
       }
       for(int i = 0;i<Math.min(arr1.size(),arr2.size());i++){
           if(arr1.size() > arr2.size()){
               if(arr1.contains(arr2.get(i))){
                   return arr2.get(i);
                }
           }
           else{
               if(arr2.contains(arr1.get(i))){
                   return arr1.get(i);
                }
           }
       }
       return null;
    }
