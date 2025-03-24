class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            return(a[0]-b[0]);
        });
        int n=meetings.length;
        int e=1;
        int ans=0;
        // for(int[] arr: meetings){
        //     System.out.print(arr[0]+" "+arr[1]+",  ");
        // }
        //  System.out.println();
        ans+=meetings[0][0]-1;
        e=meetings[0][1];
        for(int i=1;i<n;i++){
            if(meetings[i][0]>e) ans+=meetings[i][0]-e-1;
            e=Math.max(e,meetings[i][1]);
            // System.out.println(e+" "+ ans);
        }
        // e=Math.max(e,meetings[n-1][1]);
        ans+=days-e;
        return ans;
    }
}