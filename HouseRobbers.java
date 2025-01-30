//MEMOIZATION
/* Time Complexity: atmost we solve (0 - number of houses) subproblems so Tc will be O(N)
 * Space Complexity: as we store the answers of all the subproblems O(N), can be optimized to O(1) as we are just using three indices at any time.
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: atmost we solve (0 - number of houses) subproblems so Tc will be O(N)
 * Space Complexity: as we store the answers of all the subproblems O(N), can be optimized to O(1) as we are just using three indices at any time.
 * Leetcode: yes
 * Any Problems: no
 */
import java.util.Arrays;

public class HouseRobbers {
    //MEMOIZATION
     private int helper(int index, int[] nums, int[] dp)
    {
        if(index >= nums.length)
            return 0;
        //if the subproblem is already solved just return it
        if(dp[index]!=-1)
            return dp[index];

        //current solution = max(current + second previous , previous)
        dp[index] = Math.max(nums[index]+helper(index+2, nums, dp), helper(index+1, nums, dp));

        return dp[index];
    }
    public int robMemoization(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);

    }

    //TABULATION
    public int robTabulation(int[] nums) {
        //edge case when length = 1
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        //base cases
        // At zero the max amount is by considering the amount at that point
        dp[0] = nums[0];
        //At 1 the max amount is either the previous step or the current step because we have a condition that we can't make consecutive steps.
        dp[1] = Math.max(nums[0], nums[1]);

        /*The main intuition behind tabulation is that from base case we try to get to the target through building each step.
         * Here at each step, the answer will be the maximum of previous step or current + before the previous step.
        */
        for(int i=2; i<nums.length; i++)
            dp[i] = Math.max(dp[i-1] , nums[i] + dp[i-2]);
        return dp[nums.length-1];
    }

}
