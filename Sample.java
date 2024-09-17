// Time Complexity : coin change : time - O(amount * no of coins) 
// Space Complexity : cpin change : time - O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Coin Change (donr on leetcode)
class Solution {class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 99999);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }
        return dp[amount] == 99999 ? -1 : dp[amount];
     }
}  

//House Robber -- Done on Leetcode
// Time Complexity :  : time - O(no of houses) 
// Space Complexity :  : time - O(n) new dp array
class Solution {
    public int rob(int[] nums) {
        
    int sum1 = 0;
    int sum2 = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0) 
              sum1+=nums[i];
      }
        for(int i=0; i<nums.length; i++){
            if(i%2 != 0) 
                sum2+=nums[i];
        }
        return sum1 > sum2 ? sum1 : sum2;
    
}
}
