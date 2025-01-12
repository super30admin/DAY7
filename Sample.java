/************************* PROBLEM -1 *************************/

// Time Complexity : 0(n*m)
// Space Complexity : o(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Intuition is to create a matrix with all possible combinations to store solution
// and use the already stored solution to solve the existing combination.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null){
            return -1;
        }
        int max=amount+1;//infinity
        int[][] dp=new int[coins.length+1][amount+1];
        for(int j=1;j<=amount;j++){
            dp[0][j]=max;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }

        }
        if(dp[coins.length][amount]==max){
            return -1;
        }
        return dp[coins.length][amount];
    }
}


/********************************* PROBLEM-2******************************/
// Time Complexity : 2^n n=no of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no (time limit exceeded)
// Any problem you faced while coding this : no

//recursive approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0 || nums==null){
            return 0;
        }
        return recurse(nums,0,0);
    }

    private int recurse(int[] nums,int index,int amount){
        //base
        if(index>=nums.length){
            return amount;
        }

        //logic
        int case0=recurse(nums,index+1,amount);
        int case1=recurse(nums,index+2,amount+nums[index]);
        return Math.max(case0,case1);
    }
}

// Time Complexity : 0(n) n=no of houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int[][] dp=new int[nums.length][2];
        dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
