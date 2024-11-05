// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach:  at any point we can choose
// the current index if we dont choose the previous index. so we use dp to build an array based on this
//constraint. Like fibonacci pattern in dp


/**
 * HouseRobber : HouseRobber
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 05, 2024)
 * @since : 1.0 (Nov 05, 2024)
 */
public class HouseRobber {
    // public int rob(int[] nums) {
    //     if(nums.length == 1) return nums[0];
    //     int[] dp = new int[nums.length];
    //     int N = nums.length;
    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0], nums[1]);
    //     for(int i = 2; i < N; i++){
    //         dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
    //     }
    //     return dp[N-1];
    // }

    //optimized without array
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int N = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < N; i++){
            int temp = Math.max(curr, nums[i]+prev);
            prev = curr;
            curr = temp;
        }
        return curr;
    }


}
