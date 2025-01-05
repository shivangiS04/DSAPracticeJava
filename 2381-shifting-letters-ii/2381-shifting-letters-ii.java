class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int shiftarr[]=new int[s.length()];
        //without prefix sum O(n^2)
        //0 left shift -1;
        //1 right shift +1;
        // for(int shift[]:shifts){
        //     if(shift[2]==0){
        //         for(int i=shift[0];i<=shift[1];i++){
        //             shiftarr[i]-=1;
        //             shiftarr[i]%=26;
        //         }
        //     }
        //     else{
        //         for(int i=shift[0];i<=shift[1];i++){
        //             shiftarr[i]+=1;
        //             shiftarr[i]%=26;
        //         }
        //     }
            
        // }
        //using prefix sum method O(n)
        //do dry run nice logic
        for(int shift[]:shifts){
            int val=shift[2]==1?1:-1;
            shiftarr[shift[0]]+=val;
            if(shift[1]+1<s.length())shiftarr[shift[1]+1]-=val;
        }
        shiftarr[0]%=26;
        for(int i=1;i<shiftarr.length;i++){
            shiftarr[i]+=shiftarr[i-1];
            shiftarr[i]%=26;
        }
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch=(char)(s.charAt(i)+shiftarr[i]);
            if(ch-'a'>=0 && ch-'a'<=25) ans.append(ch);
            if(ch-'a'<0) ans.append((char)(ch+26));
            if(ch-'a'>25) ans.append((char)(ch-26));
        }
        return ans.toString();
    }
}