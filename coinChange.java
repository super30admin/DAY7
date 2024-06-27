// Time Complexity : O(mxn) m-no. of different coins, n-amount 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int []dp = new int [n+1];
        for(int j=1;j<=n;j++){
            dp[j] = 999999;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // amount < denomination of curr coin
                if(j<coins[i-1]){
                    // no choose case
                    dp[j]=dp[j];
                }else{
                    // no choose case and choose
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
                }
            }
        }
        int res = dp[n];
        if(res<999999){
            return res;
        }else return -1;
    }
}