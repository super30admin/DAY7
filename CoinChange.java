// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// approach
// 1) create 2d array and initiate dp[0][0] = 0 and dp[0] = infinite number
// 2) loop through dp and copy previous row values untill current coin value is greater than amount
// 3) when less, take minimum of previous row and current row column less than coins[i-1]];
public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
		if(coins.length == 0 || coins == null){
            return 0;
        }
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i=1; i< dp[0].length; i++){
            dp[0][i] = 999;
        }
        
        for(int i=1; i< dp.length; i++){
            for(int j=1; j< dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        int res = dp[dp.length-1][dp[0].length-1];
        if(res >=999){
            return -1;
        }
        return res;
    }

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int coins[]  = {1, 2, 5};
		int amount = 11;
		int res = obj.coinChange(coins, amount);
		System.out.println(res);
	}

}
