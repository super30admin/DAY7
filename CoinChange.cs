// time complexity - O(mn) where m= number of coins, m = amount
// space complexity - O(n) where n = amount
public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        int n = amount;
        int m = coins.Length;
        int[] matrix = new int[n + 1];
        matrix[0] = 0;
        for (int j = 1; j <= n; j++)
        {
            matrix[j] = 99999;
        }
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // to optimiza space complexity
                if (coins[i - 1] <= j)
                {
                    matrix[j] = Math.Min(matrix[j], 1 + matrix[j - coins[i - 1]]);
                }
                //till denominaton of coin< amount
                // if(coins[i-1]>j)
                // {
                //     // oth case
                //     matrix[i,j] = matrix[i-1,j];
                // }
                // else
                // {
                //     matrix[i,j] = Math.Min(matrix[i-1,j], 1+ matrix[i,j-coins[i-1]]);
                // }               
            }
        }
        int re = matrix[n];
        if (re >= amount + 1)
        {
            return -1;
        }
        return re;
    }
}