public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        if (amount == 0)
        {
            return 0;
        }
        int[][] dp = new int[coins.Length + 1][];

        for (int i = 0; i <= coins.Length; i++)
        {
            dp[i] = new int[amount + 1];
        }

        for (int i = 1; i <= amount; i++)
        {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i <= coins.Length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.Min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        return dp[coins.Length][amount] == amount + 1 ? -1 : dp[coins.Length][amount];
    }
}