public class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n < 2) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1] + 0);

        for(int i=2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }

    public static void main(String[] args){

        HouseRobber object = new HouseRobber();
        int[] houseAmounts = {2,7,9,3,1};
        int result = object.rob(houseAmounts);

        System.out.println("Maximum robbed amount without alerting police: " + result);
    }

}

//pointer - space optimization
/*
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n < 2) return nums[0];

        //space optimization from dp array to pointers
        int prev = nums[0];
        int curr = Math.max(prev, nums[1] + 0);

        for(int i=2; i < n; i++){

            int temp = curr;

            curr = Math.max(curr, nums[i] + prev);

            prev = temp;
        }

        return curr;
    }
}
 */

// recursion base

/*
class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int idx, int curRobSum){
        //base
        if(idx >= nums.length) return curRobSum;
        //logic
        // not choose
        int noChoose = helper(nums, idx+1, curRobSum);

        //choose
        int choose = helper(nums, idx+2, curRobSum + nums[idx]);

        // get minimum of both
        return Math.max(noChoose, choose);
    }
}
 */