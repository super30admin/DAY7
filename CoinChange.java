// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// used the tabulation approach by creating a 2d array based on parameter changing

public class CoinChange {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length ==0){
                return 0;
            }

            int[][] memo = new int[coins.length+1][amount+1];

            for(int j=1;j<amount+1;j++){
                memo[0][j] = amount+1;
            }

            for(int i=1;i<coins.length+1;i++){
                for(int j=1;j<amount+1;j++){
                    if(j < coins[i-1]){
                        memo[i][j] = memo[i-1][j];
                    }else{
                        memo[i][j] = Math.min(memo[i-1][j],1+ memo[i][j- coins[i-1]]);
                    }
                }
            }

            if(memo[coins.length][amount] == amount+1){
                return -1;
            }
            return memo[coins.length][amount];
        }

}
