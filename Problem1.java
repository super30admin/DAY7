//Brute force

class Solution {
    public int coinChange(int[] coins, int amount) {
    int result = coinChange(coins, amount, 0);
    return result == Integer.MAX_VALUE ? -1 : result;
}

private int coinChange(int[] coins, int amount, int count) {
    if (amount == 0) {
        return count;
    }
    if (amount < 0) {
        return Integer.MAX_VALUE;
    }
    int minCount = Integer.MAX_VALUE;
    for (int coin : coins) {
        int res = coinChange(coins, amount - coin, count + 1);
        if (res < minCount) {
            minCount = res;
        }
    }
    return minCount;
    }
}

//Accepted with Dynamic Programming

class Solution {
    public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
    }
}
