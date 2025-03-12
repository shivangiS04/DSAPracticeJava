class Solution {
    public int maximumCount(int[] nums) {
        int count1=0;
        int count2=0;
        for (int num1 : nums) {
            if (num1 > 0) {
                count1++;
            }
        }
        for (int num2 : nums) {
            if (num2 < 0) {
                count2++;
            }
        }
        return Math.max(count1, count2);
    }
}