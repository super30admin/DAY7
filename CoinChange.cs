// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        int m = coins.Length;
        int n = amount;
        //we can optimize it wit 1D array
        // by removing all the ith indexes or rows as we need to track only colums
        //int[,] dp = new int[m+1,n+1];
        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++)
        {
            //dp[0,j] = amount + 1;  //amount+1 //9999
            dp[j] = amount + 1;  //amount+1 //9999

        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (j < coins[i - 1])
                {//if amount is less than the denomination of coin, no availability of choose case
                 //dp[i,j] = dp[i-1,j];
                    dp[j] = dp[j];

                }
                else
                {
                    //dp[i,j] = Math.Min(dp[i-1,j] , 1+dp[i,j-coins[i-1]]);
                    dp[j] = Math.Min(dp[j], 1 + dp[j - coins[i - 1]]);

                }
            }
        }
        if (dp[n] > amount) return -1;
        return dp[n];
    }


}

public class Program
{
    public static void Main()
    {
        Solution obj = new Solution();
        //int[] coins = new int[] { 1, 2, 5 };
        int[] coins = new int[] { 2,1, 5 }; //sorted array works fine too

        int amount = 11;
        //Output: 3
        int result = obj.CoinChange(coins, amount);
        Console.WriteLine(result);
    }
}