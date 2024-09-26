//Time Complexity : O(mn)
//Space Complexity : O(mn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        //if coins array is empty
        if(coins==null||coins.length==0)
            return 0;
        //initialize an array
        int[][] k=new int[coins.length+1][amount+1];
        //infiniti value
        for(int i=1;i<amount+1;i++){
            k[0][i]=amount+1;
        }
        //iterating over coins and amount
        for(int j=1;j<coins.length+1;j++){
            for(int i=1;i<amount+1;i++){
                //as j starts from 1, if amount is less then take from the above ie., 0 case
                if(i<coins[j-1])
                    k[j][i]=k[j-1][i];
                else
                    k[j][i]=Math.min(k[j-1][i], 1+k[j][i-coins[j-1]]);
            }
        }
        //checking last row and column
        if(k[coins.length][amount]==amount+1)
            return -1;
        return k[coins.length][amount];
    }
}