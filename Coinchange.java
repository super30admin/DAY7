// Time Complexity :O(m+1 * n+1) where m is coins array length and n is amount
// Space Complexity :O(m+1 * n+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer to the video once to write the code
class Coinchange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1]; //an extra row and coulmn for 0 are added in the matrix
        for(int j=1;j<=n;j++) {
            dp[0][j] = amount+1;//All the column elements are initialized to a maximum value greater than amount for row 0
        }

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(j < coins[i-1]) {//if the denomination is greater than the amount, the position is filled with prev row and same column value 
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);//Minimum no of coins value is filled at the position
                }
                
            }
        }
        if (dp[m][n] > amount) return -1;//if last position in the matrix is greater than amount, return -1
        else return dp[m][n];//else return the value at last position of the matrix
    }
}
/*
//using 1-D array
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n+1];
        for(int j=1;j<=n;j++) {
            dp[j] = amount+1;
        }

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(j < coins[i-1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
                
            }
        }
        if (dp[n] > amount) return -1;
        else return dp[n];
    }
 */
