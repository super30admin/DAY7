public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        return oneDTabulation(coins,amount);
    }

    public int recurHelper (int[] coins,int amount,int i,int totalCoins){

        if(amount ==0 ){
            return totalCoins;
        }
        if(amount ==-1){
            return -1;
        }
        //do not select anything
        int case0 = recurHelper(coins,amount,i+1,totalCoins);

        //select a value
        int case1 = recurHelper(coins,amount-coins[i],i,totalCoins+1);

        if(case0==-1){
            return case1;
        }
        if(case1 ==-1){
            return case0;
        }
        return Math.min(case0,case1);
    }

    //Time complexity O(M*N)
    //Space complexity O(M*N)
    public int coinChangeByTabulation(int[] coins, int amount){
        int m = coins.length +1;
        int n = amount +1 ;
        int[][] twoDArray = new int [m][n];


        //fill first row
        for(int k=1;k<n;k++){
            twoDArray[0][k] = 99999;

        }
        for(int i=1;i<m ;i++){
            for (int j =0;j<n;j++){


                //do not chosse
                int noChoose = twoDArray[i-1][j];

                if(j<coins[i-1]){
                    twoDArray[i][j] = noChoose;

                }else{
                    //choose
                    twoDArray[i][j] = Math.min(noChoose,1+ twoDArray[i][j-coins[i-1]]);
                }


            }
        }
        if(twoDArray[m-1][n-1]>=99999){
            return -1;
        }else{
            return twoDArray[m-1][n-1];
        }

    }


    //we optimized space complexity with O(N)

    public int oneDTabulation(int[] coins, int amount){
        int m = coins.length +1;
        int n = amount +1 ;
        int[] dp = new int[n];


        //fill first row
        for(int k=1;k<n;k++){
            dp[k] = 99999;

        }
        for(int i=1;i<m ;i++){
            for (int j =0;j<n;j++){


                //do not chosse
                int noChoose = dp[j];

                if(j<coins[i-1]){
                    dp[j] = noChoose;

                }else{
                    //choose
                    dp[j] = Math.min(noChoose,1+ dp[j-coins[i-1]]);
                }


            }
        }
        if(dp[n-1]>=99999){
            return -1;
        }else{
            return dp[n-1];
        }

    }
}
