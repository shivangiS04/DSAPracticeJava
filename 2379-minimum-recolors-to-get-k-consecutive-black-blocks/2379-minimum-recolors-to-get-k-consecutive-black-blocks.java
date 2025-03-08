class Solution {
    public int minimumRecolors(String blocks, int k) {

        int res=Integer.MAX_VALUE;
        int c=0;

        for(int i=0;i<blocks.length();i++){

            if(blocks.charAt(i)=='W'){
                c++;
            }

            if(i+1>=k){
                res=Math.min(res,c);
                if(blocks.charAt(i-k+1)=='W'){
                    c--;
                }
            }

        }

        return res;
        
    }
}