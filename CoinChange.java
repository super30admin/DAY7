
//Time complexity = O(n^2)
//Space Complexity = O(n)
// 1-d array dp
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i< amount+1;i++) {
            dp[i] = amount+1;
        }
        for(int i=1;i< coins.length+1;i++) {
            for(int j=1;j< amount+1;j++) {
                if(j< coins[i-1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[amount] >= amount+1 ) {
            return -1;
        }
        return dp[amount];
    }
}

//2-d array
// class Solution {
//        public int coinChange(int[] coins, int amount) {
//            int[][] dp = new int[coins.length+1][amount+1];
//            for(int i=0;i< amount+1;i++) {
//                dp[0][i] = amount+1;
//            }
//            for(int i=1;i< coins.length+1;i++) {
//                for(int j=1;j< amount+1;j++) {
//                    // till amount < coins[i-1]
//                    if(coins[i-1] > j) {
//                        dp[i][j] = dp[i-1][j];
//                    } else {
//                         dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]); 
//                    }
                   
//                }
//            }
//            if(dp[coins.length][amount] >= amount+1 ) {
//                return -1;
//            }
//            return dp[coins.length][amount];
           
           
//        }
    
// }


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int re = recursion(coins, 0, amount);
//         if(re == 999999) {
//             return -1;
//         } else {
//             return re;
//         }
        
//     }
    
    
//     private int recursion(int[] coins, int idx, int amount) {
//         if(amount==0) {
//             return 0;
//         }
//         if(amount<0 || idx == coins.length) {
//             return 999999;
//         }
//         // chosen
//         int case1 = 1+ recursion(coins,idx, amount-coins[idx]);
//         //  not chosen
//         int case2 = recursion(coins,idx+1, amount);
//         return Math.min(case1,case2);
//     }
// }