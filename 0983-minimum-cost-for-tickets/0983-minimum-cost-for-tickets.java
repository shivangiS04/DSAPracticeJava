
class Solution {
    int[] cost;
    Integer[] dp;
    public int bs(int[] nums,int i,int x){
        int high=nums.length-1,low=i;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x) return mid;
            else if(nums[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int f(int[] days,int i){
        if(i>=days.length) return 0;
        if(dp[i]!=null) return  dp[i];
        int d=cost[0]+f(days,i+1);
        int w=cost[1]+f(days,bs(days,i+1,days[i]+7));
        int m=cost[2]+f(days,bs(days,i+1,30+days[i]));
        dp[i]=Math.min(d,Math.min(w,m));
        return dp[i];
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp=new Integer[days.length];
        cost=costs;
        return f(days,0);
    }
}