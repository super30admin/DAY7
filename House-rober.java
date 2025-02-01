// solution1:
// timeComplexity:2^n
// SpaceComplexity:O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: exhaustive approach by considering max between choose and not choose house to rob
class Solution {
    public int rob(int[] nums) {
        int result = helper(nums,0);
        return result;
    }
    public int helper(int[] nums,int index){
        if(index >= nums.length)return 0;
        //choose house 
        int case1=nums[index]+helper(nums,index+2);
        //not choose house
        int case2=helper(nums,index+1);
        return Math.max(case1,case2);
    }
}


// solution -2
// timeComplexity:O(n)
// SpaceComplexity:O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:in exhaustive approch i have observed similar subproblems so here i use DP memization by taking 1D array because we have only on edependent variable
// in that case i got maximum amount by choosing and not choosing particular house 

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
          if(n == 1){
                return nums[0];
            }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]+0);
        for(int i=2;i<n;i++){
                dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}

// solution-3

// timeComplexity : O(n)
// SpaceComplexity:O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: same as above approch to reduce space complexity just used two varibles

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
          if(n == 1){
                return nums[0];
            }
       int prev = nums[0];
        int current = Math.max(prev,nums[1]+0);
        for(int i=2;i<n;i++){
                int temp = current;
                current=  Math.max(current,nums[i]+prev);
                prev=temp;
        }
        return current;
    }
}