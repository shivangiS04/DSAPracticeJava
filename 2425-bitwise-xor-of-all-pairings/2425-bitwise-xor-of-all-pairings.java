class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        int m = nums1.length;
        int n = nums2.length;

        if(m%2!=0){
            for(int num2:nums2){
                res ^= num2;
            }
        }
        if(n%2!=0){
            for(int num1:nums1){
                res ^= num1;
            }
        }
            return res;
        
    }
}