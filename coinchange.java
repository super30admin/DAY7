// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// approach: created a dp matrix to remmebr the minimum number of coins.

// Your code here along with comments explaining your approach


public class coinchange {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int m=coins.length;
            int n=amount;
            int[][] arr=new int[m+1][n+1];
    
            for(int i=0;i<=n;i++)
            {
                arr[0][i]=amount+1;
            }
            for(int i=1;i<=m;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(j<coins[i-1])
                        arr[i][j]=arr[i-1][j];
                    else
                        arr[i][j]=Math.min(arr[i-1][j],1+arr[i][j-coins[i-1]]);
                }
            }
            if(arr[m][n]>=amount+1) return -1;
            return arr[m][n];
        }
    }
    
}
