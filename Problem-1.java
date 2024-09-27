class Solution {
    // Time Complexity : O(S * n) where S is the amount and n is the size of conis
    // Space Complexity : O(S) - S is the amount
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Corner case issues
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1] ;
        //find miminum so fiill it will max value to check if it is possible or not
        Arrays.fill(dp,amount+1);
        //base case
        dp[0] = 0;
        //for every amount do
        for(int i = 1; i <= amount; i++) {
            // for all possible combinations
            for(int c : coins) {
                //f coin value exceeds , neglect that coin
                if(c <= i) {
                    //includes and excludes case
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        //check if default value is modified or not and return accordingly
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
