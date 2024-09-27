// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//using dp array
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int case0 = 0 , case1 = nums[0];
        // case0 = 0 // by default value when did not rob the first house
        // case1 robbing the first house
        
        for(int i = 1 ; i < nums.length ; i++)
        {
             int oldCase0 = case0;
             case0 = Math.max(case0, case1);
             case1 = nums[i] + oldCase0;
        } 
        
        return Math.max(case0, case1);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//using dp array
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int dp[][] = new int [nums.length][2];
        // dp[0][0] = 0 // by default value when did not rob the first house
        dp[0][1] = nums[0]; // robbing the first house
        
        for(int i = 1 ; i < nums.length ; i++)
        {
             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
             dp[i][1] = nums[i] + dp[i-1][0];
        } 
        
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}

// recursive house robber
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, 0);
    }

    private int helper(int [] nums, int idx, int amount)
    {
        // base case
        if(idx >= nums.length)
            return amount;

        // recursive case
        int case0 = helper(nums, idx+1, amount);
        int case1 = helper(nums, idx+2, amount + nums[idx]);

        return Math.max(case0, case1);
    }
}