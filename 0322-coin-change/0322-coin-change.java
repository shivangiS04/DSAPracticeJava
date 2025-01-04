class Solution {
    int minCoins = Integer.MAX_VALUE; // To track the minimum coins needed
    
    public int coinChange(int[] coins, int amount) {
        // Base case: if coins array is null or empty, return -1
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        // Start the recursive function
        recurse(coins, amount, 0, 0);
        
        // If no valid combination found, return -1
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    
    private void recurse(int[] coins, int amount, int index, int coinsUsed) {
        // If the amount becomes zero, we found a valid combination
        if (amount == 0) {
            minCoins = Math.min(minCoins, coinsUsed); // Update the minimum coins needed
            return;
        }
        
        // If the amount becomes negative or we have processed all coins, return
        if (amount < 0 || index == coins.length) {
            return;
        }
        
        // Case 1: Skip the current coin
        recurse(coins, amount, index + 1, coinsUsed);
        
        // Case 2: Pick the current coin
        recurse(coins, amount - coins[index], index, coinsUsed + 1);
    }
}
