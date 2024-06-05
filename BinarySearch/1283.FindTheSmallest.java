//time= O(logn)
//space=O(1)

class Solution {
    public boolean isPossible(int []nums,int val,int threshold){
        int cnt=0;
        for(int x:nums){
            if(x%val==0) cnt+=(x/val);
            else cnt+=((x/val)+1);
            if(cnt>threshold) return false; // early exit
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for(int x:nums) maxi = Math.max(maxi,x);
        int start=1,end=maxi,mid=0;
        while(start<=end){
            mid = (start+end)/2;
            if(isPossible(nums,mid,threshold)) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
}
