// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
The concept is optimized from the recursion approach. In the recursion approach, we explored all possibilities
of sub-arrays of the available denominations(make two decisions at each point,
whether to include the current coin or not and continue exploring both until end) and following the top-down approach
checked if the amount became 0 at any point. If it did, then following this path would give us the number of
coins needed. And among all these paths, we just had to calculate the minimum path.
This was was O(n^3) T.C which had the time limit issue.

So on top of this, we thought of the optimized approach by eliminating the same sub-problem. That means.
if we already encountered a sub-array of {2,5} with current amount left to be 7, we store this value in a 2d array.
And if we encounter this same sub-problem again, we can just use the solution stored from here and add one coin to it.
So using this way, we will only encounter a unique sub-problem only once. So what we do in the code is,
we take a 2d array to store the number of coins required to build each value from 0 to the required amount, for all the
available denominations. In this 2d array, just insert a dummy row with denomination 0 and coins needed as infinity.
At each i,jth iterations, check for two cases. If the current amount is lesser than the denomination, that means we
cannot build a sub-array and hence just import the infinity value from above. Case 2 is if we can build the amount,
check for the minimum value between the number of coins from above and difference between the current amount and
current places behind in the same denomination row. Return the last value from the 2d array as output.
 */

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        //Optimizations
        if(amount == 0) return 0;
        if(coins.length == 1) {
            if(amount == coins[0]) return 1;
            else if(amount < coins[0]) return -1;
        }

        int max = amount+1; //infinity value for this problem
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=1; j<=n; j++) { //O(n)
            dp[0][j] = max; //dummy insertion of max values for denomination 0
        }
        for(int i=1; i<=m; i++) { //O(m)
            for(int j=1; j<=n; j++) { //O(m*n) T.C
                //case 1
                if(j < coins[i-1]) { //if amount is lesser than current coin
                    dp[i][j] = dp[i-1][j]; //just import the infinity value from above
                }
                //case 2
                else{ //if amount can be adjusted with the current coin
                    //we take the minimum of value from above and difference between current amount
                    //and the amount from current denomination ago.(this would be the factor of current amount)
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]); //O(m*n) S.C
                }
            }
        }
        int res = dp[m][n];
        if(res >= amount+1) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins1 = {1,2,5,10};
        int amount1 = 35;
        int amount2 = 78;
        System.out.println("Minimum coins from coins1 to " +
                "build " + amount1 + " is " + coinChange(coins1, amount1));
        System.out.println("Minimum coins from coins1 to " +
                "build " + amount2 + " is " + coinChange(coins1, amount2));
    }
}
