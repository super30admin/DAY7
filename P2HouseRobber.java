// Before Class Memo solution
// Time Complecity : O(N^m+n)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Created a recursive function which will calculate the maximum output at the current index i 
// At current index i it will recursively call from i+2 to nums.length
// The maximum result is stored in dp[i] to reduce recursive overhead

class Solution {
    int recRob(int[] nums, int i,int[] dp){
        //System.out.println("Currnt index " + i);
        if(i==nums.length-1) return nums[nums.length-1];
        if(i==nums.length-2) return nums[nums.length -2];
        int currentSum = 0;
        for(int j=i+2; j<nums.length;j++){
            //System.out.println("Checking i for :"+ i + "and j for: "+j);
            if(dp[j]==-1){
                currentSum = Math.max(nums[i] + recRob(nums, j, dp), currentSum);
            }else{
                currentSum = Math.max(nums[i]+dp[j], currentSum);
            }
            //System.out.println("Current sum is : "+currentSum);
        }
        
        int sum = recRob(nums, i+1, dp);
        int max = Math.max(sum, currentSum);
        dp[i]=max;
        return max;
    }
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return recRob(nums, 0, dp);
    }
}