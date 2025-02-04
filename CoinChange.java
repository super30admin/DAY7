class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] arr=new int[coins.length+1][amount+1];
        if(amount==0) return 0;
        if(amount<0) return 9999;
        for(int j=1;j<=amount;j++){
            arr[0][j]=99999;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    arr[i][j]=Math.min(1+arr[i][j-coins[i-1]],arr[i-1][j]);
                }
                else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[coins.length][amount] == 99999 ? -1 : arr[coins.length][amount];

    }
}
