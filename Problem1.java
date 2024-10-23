// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Exhaustive approach (Recursion)
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        // null check
        if(coins == null || coins.length == 0) return 0;
        return helper(coins, amount, 0, 0);
    }
    private int helper(int[] coins, int amt, int idx, int minCoins){
        // base
        if(amt < 0 || idx == coins.length) return -1; //Invalid path

        if(amt == 0) return minCoins;

        // case - 1 (choose)
        int case1 = helper(coins, amt - coins[idx], idx, minCoins + 1);
        // case - 0 (ignore)
        int case0 = helper(coins, amt, idx + 1, minCoins);

        if(case1 == -1) return case0;
        if(case0 == -1) return case1;

        return Math.min(case0, case1);

    }
}
*/
// Optimized 2D-DP solution
/*  DP = optimization of "repeated sub-problems".
 Firt step -> Check if a greedy solution would work.
 If not, you will understand that DP is the way.
 Step Two -> Identify the repeated sub-problems by creating a tree/flow of the problem.
 DP is of two types -> Bottom-up and Top-down
 This problem is an example of bottom up DP.    */

/* Time Complexity : O(M*N)
Space Complexity :O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, the code kept breaking on taking the dummy
value of the first row as Integer.MAX_VALUE. Need to find a workaround incorporating it.
*/


/*class Solution {
    public int coinChange(int[] coins, int amount) {
        // null check
        if(coins == null || coins.length == 0) return 0;
        // deciding factors
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        // first row fill with dummy values
        for(int i = 1; i < n+1; i++){
            dp[0][i] = n + 1;
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                // Until denomination is greater than amount
                // not choose case
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // Choose & Not choose cases
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                    //                  above           denom spaces left
                }
            }
        }
        int result = dp[m][n];
        return (result > amount)? -1 : result;
    }
}*/


/* Optimal 1-D DP solution
Time Complexity : O(M*N)
Space Complexity :O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Problem1 {
    public int coinChange(int[] coins, int amount) {
        // null check
        if(coins == null || coins.length == 0 || amount == 0) return 0;

        int[] dp = new int[amount + 1];

        // first row fill with dummy values
        for(int i = 0; i < amount+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int coin: coins){
            for(int idx = coin; idx < amount + 1; idx++){
                int left = (dp[idx-coin] == Integer.MAX_VALUE)? dp[idx-coin]: 1 + dp[idx-coin];
                dp[idx] = Math.min(dp[idx], left);
                //     previous(~above), left
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1:dp[amount];
    }
}

