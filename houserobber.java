// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes



public class houserobber {
    public int rob(int[] nums) {
        int n = nums.length;
        //int [] dp = new int[n];
        //dp[0] = nums[0];
        int prev = nums[0];
        if(n==1) return prev;
       // dp[1] = Math.max(dp[0], nums[1] + 0);
        int curr = Math.max(prev, nums[1] + 0);
        for(int i = 2; i < n; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
