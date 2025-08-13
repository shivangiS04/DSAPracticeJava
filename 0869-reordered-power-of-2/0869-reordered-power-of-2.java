class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] nArr = getDigit(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            int[] powerArr = getDigit(power);
            if (Arrays.equals(nArr, powerArr)) return true;
        }
        return false;
    }

    private int[] getDigit(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
}