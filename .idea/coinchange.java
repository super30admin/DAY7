// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length + 1; //Increase the size of the length
        int n = amount + 1; //Increase the amount by 1
        int[][] matrix = new int[m][n]; //Create a matrix

        for(int j = 0; j < n; j++){
            matrix[0][j] = amount + 1; //Set the max value for the first row
        }

        for(int i = 1; i< m; i++){
            for(int j = 1; j< n; j++){
                if(j < coins[i - 1]){
                    matrix[i][j] = matrix[i-1][j]; //Gets the value from the row above
                } else{
                    matrix[i][j] = Math.min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]); //Min between the value from the row above or the elem coins[i-1] steps before
                }
            }
        }
        if (matrix[m -1][n - 1] >= amount + 1){ //Checks if max elem is present at matruix[m][n]
            return -1;
        } else{
            return matrix[m - 1][n - 1]; //Otherwise returns the elem directly
        }
    }
}
