class Solution {
    public boolean canConstruct(String s, int k) {
       int [] alp = new int [26];
       for(char ch : s.toCharArray()) {
        alp[ch-'a']++;
        }
       int uniqueChars = 0;
       for(int i : alp){
        if(i%2 == 1){
            uniqueChars++;
           }
        }
               // min count        // max count
        return k >= uniqueChars && k <= s.length() ;   
    }
}