class Solution {
   public boolean canBeValid(String s, String locked) {
       int n = s.length();
       int minOpen = 0;
       int maxOpen = 0;
       for (int i = 0; i < n; i++) {
           if (locked.charAt(i) == '0') {
               maxOpen++;
               if(minOpen==0){
                minOpen=1;
               }
               else{
                minOpen--;
               }
            
           } 
           else {
               if (s.charAt(i) == '(') {
                   minOpen++;
                   maxOpen++;
               } else {
                   maxOpen--;
                   minOpen = minOpen == 0 ? 1 : minOpen - 1;
                   if (minOpen > maxOpen) {
                       return false;
                   }
               }
           }
       }
       return minOpen == 0;
   }
}