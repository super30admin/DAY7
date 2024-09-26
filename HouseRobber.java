/**
 * Time Complexity : O(n) where n = number of houses
 * Space Complexity : O(n) where n = number of houses
 */

public class HouseRobber{
    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String args[]){
        HouseRobber obj = new HouseRobber();
        int[] myArr = new int[]{1,2,3,1};
        System.out.println("Maximum Profit Possible : "+obj.rob(myArr));
    }
}