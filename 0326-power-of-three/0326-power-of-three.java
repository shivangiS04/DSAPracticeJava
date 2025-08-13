class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double logVal = Math.log10(n) / Math.log10(3);
        return Math.abs(logVal - Math.round(logVal)) < 1e-10;
    }
}
