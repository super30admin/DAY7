// Time Complexity : O(m * n) m is number of coins and n is amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr, amount+1);
        arr[0] = 0;
        for(int i = 0; i< coins.length; i++){
            for(int j = 1; j< arr.length; j++){
                if(j >= coins[i])
                    arr[j] = Math.min(arr[j], arr[j-coins[i]] + 1);
            }
        }
        int res = arr[amount];
        if(res > amount)
            return -1;
        return res;
    }
}