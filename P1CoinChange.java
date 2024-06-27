// Memoization
// Time Complexity : O(2^n+m)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Create a recursive function to explore all the possibility 
// At every stage make a decision of take or not to take 
// Store the minimum values in a memo array so it the value exist we will neglect the extra work of expanding


class Solution {
    private int[][] memo;
    public int coinRec(int[] nums,int amount, int idx){
        if(amount == 0) return 0;
        if(idx == nums.length || amount < 0) return 999999;

        if(memo[idx][amount] > 0) return memo[idx][amount];

        int case1 = 1 + coinRec(nums, amount - nums[idx], idx);
        int case2 = 0 + coinRec(nums, amount, idx + 1);

        int re = Math.min(case1, case2);
        memo[idx][amount] = re;
        return re;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        this.memo = new int[coins.length][amount+1];
        int result = coinRec(coins, amount, 0);
        if(result >= 999999){
            return -1;
        }
        return result;
    }
}