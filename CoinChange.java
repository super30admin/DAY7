// Time Complexity : n = rows = coins.length & m = coulm = amount O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;

        int dp[][] = new int[coins.length+1][amount+1];

        // initialize infinity
        for(int i = 1 ; i < amount+1 ; i ++)
        {
            dp[0][1] = amount+1; // infinity as we cannot main any amount with 0 coin value
        }

        for(int i = 1 ; i < coins.length +1 ; i++)
        {
            for(int j = 1; j < amount+1 ; j ++)
            {
                if(j < coins[i-1]) // do not select as selecting will give -ve amount
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1] + 1); // min(not selecting, selecting coin with this diff + current coin)
            }
        }

        if(dp[coins.length][amount] > amount)
            return 0; 

        return dp[coins.length][amount];
    }
}

// coin change recursive solution
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;

        return helper(coins, amount, 0, 0);
    }

    private int helper(int [] coins, int amount, int idx, int coinsUsed)
    {
        // base case
        if(amount == 0)
            return coinsUsed;
        if(amount < 0 || idx == coins.length)
            return -1;
        // recursive case
        int doNotSelect = helper(coins, amount, idx+1, coinsUsed);
        int select = helper(coins, amount - coins[idx], idx, coinsUsed+1);

        if(doNotSelect == -1)
            return select;
        if (select == -1)
            return doNotSelect;

        return Math.min(doNotSelect, select);
    }
}