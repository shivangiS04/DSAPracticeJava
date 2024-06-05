//time=O(logn)
//space= O(1)

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int[] copy = Arrays.copyOf(bloomDay, bloomDay.length);
        Arrays.sort(copy);
        int l=0;
        int h=copy.length-1;
        while(l<h){
            int mid=(l+h)/2;
            if(bouquets(bloomDay,copy[mid],k)>=m){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return copy[l];

    }
    
    public int bouquets(int[] bloomDay,int day,int k){
        int count=0;
        int noOfbouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            while(i<bloomDay.length && bloomDay[i]<=day){
                count++;
                i++;
            }
            noOfbouquets+=count/k;
            count=0;
        }
        return noOfbouquets;
    }
}
