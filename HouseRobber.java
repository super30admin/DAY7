//Time Complexity: O(n)
//Space Complexity: O(n)
public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1]= Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+nums[i-2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        int result = rob(nums);
        System.out.println("Maximum amount of money that can be robbed is: " + result);
    }
}
