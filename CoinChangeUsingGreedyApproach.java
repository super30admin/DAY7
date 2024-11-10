/*
Time Complexity:
    Sorting the Coins: We sort the coins array in descending order at the beginning, which takes O(mlogm) time, where
    m is the number of coin denominations.

    Iterating through Coins: After sorting, we iterate through each coin denomination once to calculate how many coins
    we can use. This takes O(m) time.

    Therefore, the overall time complexity is:

    O(mlogm)+O(m)=O(mlogm) where m is the number of coin denominations.

Space Complexity:
    The greedy approach doesn’t require any additional data structures beyond a few variables for counting and tracking
    the remaining amount. Therefore, the space complexity is: O(1)

========================================================================================================================
The greedy approach for the coin change problem is not always optimal for cases where the coin denominations do not
allow a direct solution. However, it can be effective when the denominations are "canonical," meaning there are enough
 smaller coins to represent all values correctly.

For example, if the coins are [1, 5, 10, 25], the greedy approach will work perfectly.
But for denominations like [1, 3, 4], it can fail because choosing the largest possible coin at each step does not
always yield the minimum number of coins.

Greedy Approach (When Feasible)
If we assume the greedy method might work (like in cases with denominations that allow optimal greedy choice),
the steps would be:

1. Sort the Coins in Descending Order: Start with the largest denomination and work your way down to smaller ones.
2. Iteratively Subtract the Largest Coin: For each coin denomination, add as many coins as possible without exceeding
    the amount.
3. Update Remaining Amount: After each choice, subtract the coin value multiplied by the number of times it was used
    from the remaining amount.
4.Continue to the Next Largest Coin: Move to the next largest denomination and repeat until the amount reaches zero
    or is impossible to match exactly.

Explanation
Sorting: First, we sort the coins in descending order so we can try the largest coins first.
Coin Usage Calculation: For each coin, calculate the maximum number of times it can be used by dividing the remaining
amount by the coin's value. This reduces the remaining amount by the exact value covered.
Edge Case Handling: After the loop, if amount is not zero, it means we couldn’t match the exact amount with the
available coins, so we return -1.

Limitations
This greedy approach may fail if the denominations do not support an optimal greedy solution. For example:

With coins [1, 3, 4] and an amount of 6, the greedy approach would choose 4 (leaving 2), but using 3 + 3 would
actually require fewer coins.
If this kind of input is common, using dynamic programming (like the original approach) or another method would be
more reliable.
 */
import java.util.Arrays;

class CoinChangeUsingGreedyApproach {
    public int coinChange(int[] coins, int amount) {
        // Sort coins in descending order
        Arrays.sort(coins);
        int coinCount = 0;

        // Traverse coins from largest to smallest
        for (int i = coins.length - 1; i >= 0; i--)
        {
            if (amount == 0) break; // If no amount is left, stop

            // Use as many of the current coin as possible
            if (coins[i] <= amount) {
                coinCount += amount / coins[i]; // Count how many of this coin we can use
                amount %= coins[i];             // Update the remaining amount
            }
            /*
            coins[i] <= amount: This condition checks if the current coin (denomination) can be used to contribute to
            the remaining amount. If the coin's value is larger than amount, we skip it since it would exceed the
            remaining amount we’re trying to match.
            ============================================================================================================
            coinCount += amount / coins[i];:

            amount / coins[i] calculates the maximum number of times we can use this coin without exceeding the
            remaining amount.
            For example, if amount is 47 and the coin value coins[i] is 10, amount / coins[i] gives 4. This means we
            can use four 10 coins (totaling 40) to cover most of the remaining amount.
            We add this count to coinCount, which tracks the total number of coins used so far.
            ============================================================================================================
            amount %= coins[i];:

            After using the maximum number of coins[i] coins, we need to update amount to reflect the remainder that
            still needs to be covered.
            amount %= coins[i] calculates this remainder by taking the modulus (remainder) of amount divided by coins[i]
            Using the example above with amount = 47 and coins[i] = 10, amount %= coins[i] gives 47 % 10 = 7. Now,
            amount is updated to 7, meaning we still need to cover 7 with smaller coins.
            This process repeats for each coin in descending order, reducing amount until either it reaches 0
            (meaning we found an exact match) or we’ve exhausted all coins (meaning an exact match isn’t possible,
            so we return -1).
             */
        }

        // If we couldn't make the amount exactly, return -1
        return amount == 0 ? coinCount : -1;
    }
}
