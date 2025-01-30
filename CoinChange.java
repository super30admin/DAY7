//MEMOIZATION
/* Time Complexity: atmost we solve (number of coins * amount) subproblems so Tc will be O(M*N)
 * Space Complexity: as we store the answers of all the subproblems O(M*N)
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: atmost we solve (number of coins * amount) subproblems so Tc will be O(M*N)
 * Space Complexity: as we store the answers of all the subproblems O(M*N), can be optimized further to O(N) using two rows at all times.
 * Leetcode: yes
 * Any Problems: no
 */
import java.util.Arrays;

public class CoinChange
{
    //MEMOIZATION - (top down)
    /*The below code is an approach of dynamic programming through memoization, where we store the results when we solve a subproblem for the first time
     * such that if at any time in future if there is a need to solve same subproblem again then we just fetch the previous swtored result in O(1) TC without solving it again
     * this way we can optimize the recursion approach.
     */
        private int helper(int index, int target, int[] coins,  int[][] dp)
        {
            /*Base Cases
             * Case 1: where target becomes 0 means we find one combination so we return 0;
             * Case 2: where either the index becomes out of range(no elements left in the array) or target becomes negative
             * that means we didn't find a combination in that path.
            */
            if(target == 0)
            {
                dp[index][target] = 0;
                return 0;
            }
            if(index<0 || target<0)
                return 99999;
            //if at all we already solved the subproblem then just return it else perform recursion to solve the subproblem
            if(dp[index][target] != -1)
                return dp[index][target];

            //considering the current element
            int case1 = 1 + helper(index, target-coins[index], coins, dp);
            //not considering the current element
            int case2 = helper(index-1, target, coins, dp);
    
            //once solved store it in dp for later use
            dp[index][target] = Math.min(case1, case2);
            
            return dp[index][target];
        }
        public int coinChangeMemoization(int[] coins, int amount) {
            int[][] dp  = new int[coins.length][amount+1];
            //initialize every cell of dp with -1, to remember that at first every subproblem is unsolved.
            for(int i=0; i<coins.length; i++)
                Arrays.fill(dp[i], -1);
            helper(coins.length-1, amount, coins,  dp);
            return dp[coins.length-1][amount] >= 99999 ? -1 : dp[coins.length-1][amount];
        }
    

        //TABULATION (bottom up)
        /* In tabulation approach we will be filling out the dp matrix rows, where each row is filled based on the previous row and itself.
         * The time complexity of this approach is O(m*n) and the space complexity will be O(m*n)
         * we can further optimize the space complexity using two rows as when we process the current row, we will only be needing it previous row. so storing rest of the rows is unnecessary.
         */
        public int coinChange(int[] coins, int amount) {
            int[][] dp  = new int[coins.length][amount+1];
            
            //when the amount is 0 then the minimum number of coins needed are 0
            for(int i=0; i<coins.length; i++)
                dp[i][0] = 0;
    
            for(int i=0; i<coins.length; i++)
            {
                for(int j=1; j<amount+1; j++)
                {
                    /* There will be two cases while filling, the first row and the rest of the rows
                     * Case 1) rest of the rows: depends of previous rows and itself to calculate the minimum
                     * case 2) first row: doesn't have any previous row, so, since the problem is to find the minimum,
                     *  we need to compare it with a possible max value (significantly larger(99999) or Integer.MAX_VALUE)
                     */
                    if(i>0)
                    {
                        if(j>=coins[i])
                            dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
                        else
                            dp[i][j] = dp[i-1][j];
                    } 
                    else
                    {
                        if(j>=coins[i])
                            dp[i][j] = Math.min(99999, 1+ dp[i][j-coins[i]]);
                        else
                            dp[i][j] = 99999;
                    }
                        
                }
            }
           
            return dp[coins.length-1][amount] >= 99999 ? -1 : dp[coins.length-1][amount];
        }

}