import java.math.BigInteger;
class Solution {
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return BigInteger.valueOf(min).gcd(BigInteger.valueOf(max)).intValue();
    }
}