/**
 * 
 */

/**
 * @author aupadhye
 *
 */
public class CoinChange1 {

	/**
	 * @param args
	 */
	  public static int coinChange(int[] coins, int amount) {
	       int[] amounts = new int[amount + 1];
	        int recur = recur(coins, amounts, amount);//recur with given amount
	        return recur > amount ? -1 : recur;
	    }

	    public static int recur(int[] coins, int[] amounts, int amount) {
	        if (amount < 0) return Integer.MAX_VALUE - 1;//if amount is less than zero, return a arbitary value;
	        if (amount == 0) return 0;//else return zero;
	        if (amounts[amount] > 0) return amounts[amount];
	        int min = Integer.MAX_VALUE - 1;

	        for (int i = 0; i < coins.length; i++) {//recur with coins available and find the minimu denomination
	            min = Math.min(min, recur(coins, amounts, amount - coins[i]) + 1);
	        }

	        return amounts[amount] = min;
	    }  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,5};
		int amount = 11;
		int minimum = coinChange(arr,amount);
		System.out.println(minimum);
	}

}
