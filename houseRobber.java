//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        //base case- if the array is not given or length is 0
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length;
        //initializing an array for n rows and 2columns(skip or take)
        int[][] k=new int[n][2]; 
        //initializing the rob case with the initial earning
        k[0][1]=nums[0];
        //iterating over the elements
        for(int i=1;i<n;i++){
            //if the current house is not robbed
            k[i][0]=Math.max(k[i-1][0], k[i-1][1]);
            //when the current house is being robbed
            k[i][1]=k[i-1][0]+nums[i];            
        }
        //and then return the max
        return Math.max(k[n-1][0], k[n-1][1]);
    }
}