class Solution {
    public long maximumTripletValue(int[] nums) {
        long left = 0;
        long maxdiff = Long.MIN_VALUE;
        long max = 0;
        for(int num : nums)
        {
            max = Math.max(max,maxdiff*num);
            maxdiff = Math.max(maxdiff,left-num);
            left = Math.max(left,num);
        }
        return max;
        
    }
}