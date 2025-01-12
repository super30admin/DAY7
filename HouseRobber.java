//TC: O(n)
//SC: O(n)
//approach: dynamic programming
public class HouseRobber {
    public static int rob(int[] nums) {
        int n=nums.length;
        int dp[][] = new int[n][2];
        dp[0][1] = nums[0];
        for(int i=1; i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,10,8,2,10,3,5,10,5,3};
        System.out.println(rob(nums));
    }
}
