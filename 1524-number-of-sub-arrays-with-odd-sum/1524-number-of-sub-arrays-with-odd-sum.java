class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd = 0, even = 1; 
        int sum = 0, result = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) { 
                result = (result + odd) % MOD; 
                even++;
            } else { 
                result = (result + even) % MOD; 
                odd++;
            }
        }

        return result;
    }
}