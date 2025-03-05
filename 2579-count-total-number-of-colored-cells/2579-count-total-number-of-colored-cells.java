class Solution {
    public long coloredCells(int n) {
        if( n == 0 || n == 1){
            return n;
        }
        long ans = 1;
        int i = 1;
        while(n-->1){
            ans += 4 * i;
            i++;
        }
        return ans;
    }
}