class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];       // dp[i] = size of largest subset ending at i
        int[] prev = new int[n];     // to reconstruct the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIdx = 0;              // index of the last element of the largest subset

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIdx >= 0) {
            result.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        Collections.reverse(result);
        return result;
    }
}