// Time Complexity : O(n*m) m is the lenght of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int n) {
 
        int dp[] = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0]=0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[n] > n ? -1 : dp[n];       
    }
}
