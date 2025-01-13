class Solution {
    public int minimumLength(String s) {
        if(s.length()<3){return s.length();}
        int count[] = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                if(count[i]%2==0){
                    count[i]=2;
                }else{count[i]=1;}
            }
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            ans= ans+count[i];
        }
        return ans;
    }
}