
// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach. Dp approach.
// rows as houses. that is elements of nums
// coloumns as 0, 1 where 0 - skip the house, 1 - rob the house
//fill the first row of dp row1 col 1 as 0 as we skipped the house
// fill the first row and 2 coloumn as first element of nums as we chose to rob the house
// start the loop with i=1 as we already filled the first row. Run the loop until lnums lenth
//fiill next rows with formula
// - row i  coloums 1 = maximun of previous row coloumns
// - row i coloumn 2 = previous sipped i-1,0;
// at the end return max between dp[nums.lenth-1][0] and dp[nums.lenth-1][1]


public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[][] dp = new int[nums.length][2];
        // fill the first row
        dp[0][0] = 0; // because we decided to skip the house
        dp[0][1] = nums[0]; // we decided to rob the house;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    // approach 2 skipping the coloumns for skip and rob instead using temp variables
    // time complexity - 0(n)
    //space O(1)

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int skip = 0;
        int take = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempSkip = skip;
            skip = Math.max(tempSkip, take);
            take = skip + nums[i];
        }
        return Math.max(skip, take);
    }
}
