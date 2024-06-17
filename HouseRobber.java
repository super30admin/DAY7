import java.util.Arrays;
//TC: O(N)
//SC: O(1)
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length < 2){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }

    public int rob5(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length < 2){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob4(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robHelper(nums, 0, dp);
    }

    private int robHelper(int[] nums, int index, int[] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] > -1){
            return dp[index];
        }
        int case1 = robHelper(nums, index + 1, dp);
        int case2 = robHelper(nums, index + 2, dp) + nums[index];
        dp[index] = Math.max(case1, case2);
        return dp[index];
    }

    public int rob3(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int cost){
        if(index >= nums.length){
            return cost;
        }

        int cost1 = helper(nums, index + 1, cost);
        int cost2 = helper(nums, index + 2, cost + nums[index]);
        return Math.max(cost1, cost2);
    }

    public int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length < 2){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] strs){
        int ans = new HouseRobber().rob2(new int[]{1,2,3,1});
    }
}
