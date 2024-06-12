
// Time Complexity : O(N)
// Space Complexity : Could not understand space complexity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

class House_Robber {
	public static void main(String[] args) {
		int arr[] = { 100, 1, 2, 200 };
		int money_collected = rob(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Money Collected: " + money_collected);
	}

	public static int rob(int[] nums) {
		// Edge case is handled
		if (nums.length == 0) {
			return 0;
		}
		/*
		 * Creating a dp array of nums(length +1) to store the maximum money that can be
		 * stolen during the traversal of all houses. The money at the last index of dp
		 * array would be the maximum money that can be stolen
		 */
		int dp[] = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
		}
		return dp[nums.length];
	}
}