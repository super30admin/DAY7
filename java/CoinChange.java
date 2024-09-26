322.Coin Change Problem
        You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

        Return the fewest number of coins that you need to make up that amount.If that amount of money cannot be made up by any combination of the coins,return-1.

        You may assume that you have an infinite number of each kind of coin.

        Example 1:
        Input:coins=[1,2,5],amount=11
        Output:3
        Explanation:11=5+5+1

        Example 2:
        Input:coins=[2],amount=3
        Output:-1

        Example 3:
        Input:coins=[1],amount=0
        Output:0

        Constraints:

        1<=coins.length<=12
        1<=coins[i]<=231-1
        0<=amount<=104


Approach 1-----------------------------------------
// Time Complexity : O(M*N)  --> where M = amount, N = denominations/coins
// Space Complexity : O(MN)--> where M = amount, N = denominations/coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*here coins and amount keep changing so hence we can store them in 2D matrix and for each denomination we can check if
it amount< denomination, then we can get previous of coins(row) and amount (column)
At each step we get to choose or dont choose the denomination, if we choose it we can take minimum of coins required by increasing the count by 1 for the coin chosed
calculated Result would be end of the matrix
* */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        //fill first row
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                //curr amount < denomination
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                    //choose, don't choose
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }
}




 Approach 2-----------------------------------------------------
// Time Complexity : O(2^(M+N)) 2 power M+N --> where M = amount, N = denominations/coins
// Space Complexity : O(M+N)--> where M = amount, N = denominations/coins
// Did this code successfully run on Leetcode : Yes (Brute Force Solution: Time limit exceeded)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
         Brute Force Solution:Time limit exceeded

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int index, int min) {
        //base case
        if (amount == 0)
            return min;
        if (amount < 0 || index >= coins.length)
            return -1;
        //choose
        int case1 = helper(coins, amount - coins[index], index, min + 1);

        //dont choose
        int case2 = helper(coins, amount, index + 1, min);
        if (case1 == -1) return case2;
        if (case2 == -1) return case1;
        return Math.min(case1, case2);

    }
}