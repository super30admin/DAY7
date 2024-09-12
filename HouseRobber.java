// Time Complexity: O(n): n is the size of the array
// Space complexity: O(n): as we are creating a dp array of size n + 1.

//Algorithm

/**
 * 1. Find the subproblem, here the subproblem is finding the way to rob 2 houses.
 * 2. If we have one house, rob that and return the element in the nums array.
 * 3. If we have 2 houses, return the maximum of the 2.
 * 4. Initialize a DP array to store previous values of the robbed houses.
 * 5. We will choose the maximum of the current house + house from index i - 2 to the start and from index i - 1 to the
 *  start.
 * 6. Return max value from the DP array.
 */


class HouseRobber {
    public int rob(int[] nums) {

        int amount = 0;

        if(nums == null || nums.length == 0) return amount;

        if(nums.length == 1) return nums[0];

        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[nums.length+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2 ; i < nums.length ; i++){

            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);


        }

        int max = Integer.MIN_VALUE;

        for(int house: dp){
            max = Math.max(max, house);
        }

        return max;


    }
}
