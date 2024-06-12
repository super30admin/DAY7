// Time Complexity : O(NLogN) + O(NM)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Have trouble understanding the time complexity and the recursion tree

import java.util.Arrays;

public class Coin_Change {
	public static int coinChange(int[] coins, int amount) {
		// The coins are first sorted
		Arrays.sort(coins);
		/*
		 * dp arrays is created of length ammount +1 and all indexes are filled with
		 * ammount +1 except first index which is 0
		 */
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		/*
		 * We iterate from 0 till the value of the amount and inside it we iterate from
		 * 0 till the length of the coins array, we check if the value at that
		 * particular index in the coin array is less or equal to the current iteration
		 * of amount, if so we update our index at dp array
		 */
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				} else {
					break;
				}
			}
		}
		/*
		 * In the end if the last index in dp array is greater than amount we return -1,
		 * else we return the value at the last index in the dp array
		 */
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		int min_coins = coinChange(coins, amount);
		System.out.println("Coins: " + Arrays.toString(coins));
		System.out.println("Amount: " + amount);
		System.out.println("Minimum coins Used: " + min_coins);
	}
}