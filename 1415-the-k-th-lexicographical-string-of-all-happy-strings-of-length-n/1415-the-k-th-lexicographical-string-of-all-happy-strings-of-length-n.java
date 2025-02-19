class Solution {
    int count;
    String res;

    public String getHappyString(int n, int k) {
        count=0;
        res="";
        backtrack(0, new StringBuilder(), n, k);
        return res;
    }

    boolean backtrack(int idx, StringBuilder stB, int n, int k){
        if(idx==n){
            count++;
            if(count==k){
                res=stB.toString();
                return true;
            }
            else return false;
        }
        boolean ret=false;

        for(char ch='a';ch<='c';ch++) {
            if(idx==0 || stB.charAt(stB.length()-1)!=ch){
                stB.append(ch);
                ret=backtrack(idx+1, stB, n, k);
                stB.deleteCharAt(stB.length()-1);
            }
            
            if(ret) return true;
        }

        return ret;
    }
}