# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
## Solution 1
## Time Complexity:O(mxn) Space Complexity:O(n)
## We have used a fixed size array where we keep on updating it depending on the choose case or no choose case.
## We compare the current case with no choose case and store the minimum of them as the final.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=amount;
         
        int[] arr=new int[n+1];
      for(int j=1;j<=n;j++)
      {
        arr[j]=amount+1;
      }
       for(int i=1;i<=coins.length;i++){
        for(int j=0;j<=n;j++)
        {
            if(j>=coins[i-1]) arr[j]=Math.min(arr[j],1+arr[j-coins[i-1]]);
        }}
    if(arr[n]>amount) return -1;
    else return arr[n];



    }
}

## Problem2 (https://leetcode.com/problems/house-robber/)
## Solution 2
## Time Complexity:O(n) Space Complexity:O(1)
## We store the current sum as prevSum and depending on it I store the two houses before value in the prevSum2 so that we can switch
## depening on which solution has the maximum value and return it as final.
class Solution {
    public int rob(int[] nums) {
       int prevsum=nums[0],prevsum2=0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
       for(int i=1;i<nums.length;i++)
       {
         int temp=prevsum;
         prevsum=Math.max(prevsum,prevsum2+nums[i]);
         prevsum2=temp;

       }
       
       return prevsum;
    }
}
