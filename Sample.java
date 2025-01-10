// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Time complexity : O(m*n)
//Space complexity : O(m*n)
// Your code here along with comments explaining your approach



class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        if(coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        for (int i=1;i<amount+1;i++) {
            dp[0][i] = amount+1;
        }
        for (int i=0;i<coins.length+1;i++) {
            dp[i][0] = 0;
        }

        for (int i=1;i<coins.length+1;i++) {
            for (int j=1;j<amount+1;j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }

            }
        }
        if (dp[coins.length][amount] == amount+1) {
            return -1;
        }

        return dp[coins.length][amount];
    }
}


// Time complexity:O(n)
// Space complexity:O(n)
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        

        if (nums.length == 1) {
            return nums[0];
        }
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i=1;i<dp.length;i++) {
            for (int j=0;j<2;j++) {

                if (j == 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]);
                }
                else if (j == 1) {
                    dp[i][j] = nums[i] + dp[i-1][j-1];
                }

            }
        }

        System.out.println(Arrays.toString(dp[nums.length-1]));

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
