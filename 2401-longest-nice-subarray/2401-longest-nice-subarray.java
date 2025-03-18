class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int maxlen = 0;
        int bitMask =0;
        int n = nums.length;
        for(int end = 0; end<n;end++){
            while((bitMask & nums[end]) != 0){
                bitMask = bitMask ^ nums[start];
                start++;
            }
            bitMask = bitMask | nums[end];
            maxlen = Math.max(maxlen,end-start+1);
        }
        return maxlen;
        
    }
}