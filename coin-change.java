// Time Complexity : 2^ m+n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : it gave output limit exceeded error
// Any problem you faced while coding this : i faced while implimenting recuring i need to do more practise on recursion problems


// Your code here along with comments explaining your approach: first i approached greedy (by taking maximum value in the given array always by continueing this approach there may be a chance to do not achieve target from possible array also) so i explored all possible cases in exhaustive manner here i  impleted by choosing and not choosing case of each level throught the array starting from index 0 
// here two cases case1:not choose case here the index will be incremened by one but amount will remains same because we didnot choose anything from array
// case1: choose case here the index will be same because we can again use the same index of value to achieve our target and amount will be deducted by coins[index] because we have used that coin
// later by taking min between choose and not choose cases will get min although here i got output limit exceed error as well as i have seen similar subproblem in exhaustive solution so i can use DP

// solution 1: exhaustive solution choose and not choose case

class Solution {
    public int coinChange(int[] coins, int amount) {
         int result = coinRecursion(coins,0,amount,amount);
         if(result >= amount+1)return -1;
         return result;
    }
    public int coinRecursion(int[] coins,int index,int amount,int target){
        if(amount < 0 ||index >= coins.length){
            return target+1; 
        }
      
        if(amount ==0 ){
            return 0;
        }
        
       // not choose case
        System.out.println("case1"+Arrays.toString(coins)+""+index+" "+amount);
       
        int case1=0+coinRecursion(coins,index+1,amount,target);
        //  choose case
         System.out.println("case2"+Arrays.toString(coins)+""+index+" "+amount);
     
        int case2=1+coinRecursion(coins,index,amount-coins[index],target);
           // int final = ;
        return Math.min(case1,case2);
        
       
    }
}
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no 

// Your code here along with comments explaining your approach: To avoid repeating calculations, I used dynamic programming (DP) to solve the problem efficiently. I created a 2D array of size `(m+1) x (n+1)` because we have two dependent input variables,
//  where m is the number of coins and n is the target amount.
// To fill the table at position (j, k), I choose the min value between  
//not choose case:The value from the just row above dp[j-1][k], meaning we don’t use the current coin.  
//choose case :1 + dp[j][k - coins[j-1]] meaning we use the current coin and reduce the amount.  

// **Solution 2:** DP approach using a 2D array of size `coins.length x amount`.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
           dp[0][i] = 99999;
        }
        for(int j=1;j<=m;j++){
            for(int k=1;k<=n;k++){
                if(k < coins[j-1]){
                    dp[j][k] = dp[j-1][k];
                }else{
                    dp[j][k] = Math.min(dp[j-1][k],1+dp[j][k-coins[j-1]]);
                }
            }
        }
        if(dp[m][n] > amount) return -1;
        return dp[m][n];
       
    }
}
// Time complexity: O(m*n)
// Space complexity:O(n)
// same dp solution but here i used 1D array because in each itteration of filling table i just dependent on same row and just the above row so to reduce space just took 1d array and overwrite it further
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[] dp=new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
           dp[i] = 99999;
        }
        for(int j=1;j<=m;j++){
            for(int k=1;k<=n;k++){
                if(k < coins[j-1]){
                    dp[k] = dp[k];
                }else{
                    dp[k] = Math.min(dp[k],1+dp[k-coins[j-1]]);
                }
            }
        }
        if(dp[n] > amount)return -1;
        return dp[n];
       
    }
}