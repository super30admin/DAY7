/*
Time Complexity: O(m*n)

Space Complexity: O(m*n)

Did this code successfully run on Leetcode: Yes

As we are using Bottom-Up Approach {Tabular}, we can either use a Matrix or an array. So choosing wither of them depends
on the number of decision-making parameters available in an exhaustive tree.

Here in this problem, our decision will be based on coins and amount based on which we can find out the min no of
coins needed.

If we have 2 decision-making parameters available, we need to opt for DP matrix, we can later optimize it with a DP
array. If we directly opt for an array, it won't work.

Once we decide on DP matrix, we need to decide on the range of values in DP matrix, so the size of matrix will be
the length of two deciding parameters => m x n. so number of rows will be coins, and no of columns will be amount.
We can choose vice versa also.

Also point to highlight is because we are using Tabular approach, we will be going from right to left in an exhaustive
tree as it will be solving smaller sub problems first but if we go from left to right, it will give us subproblems
which are yet to be solved.

Note: Refer Notebook for matrix calculation

 */

public class CoinChangeUsingBottomUpMatrix
{
    public int coinChange(int[] coins, int amount) {

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1]; //extra row and column for 0
        //dp[0][0] = 0; by default value is 0 so we don't need to initialize it

        for(int j=1; j<=n; j++)
        {
            //Filling 0th row with bigger number
            dp[0][j] = 99999;
            /*
            If we take infinity, it will add 1 to it and we come to min range {negative no} so we choose bigger number
            Or
            dp[0][j] = amount+1 => all numbers greater than amount can act as infinity value
            */
        }

        //[2,1,5], we consider imaginary 0th row
        for(int i=1; i<=m; i++) //running the for loop from 2 in matrix (which is 1st row) and not considering 0th row
        {
            for(int j=0; j<=n; j++)
            {
                //[2,1,5] => Index [0,1,2]
                if(j < coins[i-1]) {  //0 < coins[0], 0 < 2, then choose case is not available
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    /*
                    no choose case => dp[i-1][j],
                    choose case => 1+dp[i][j-coins[i-1]]
                    */
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }

        }

        if(dp[m][n] >= 99999) // Or if(dp[m][n] >= amount+1)
            return -1;

        return dp[m][n];
    }
}
