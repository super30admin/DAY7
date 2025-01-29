// https://leetcode.com/problems/house-robber/description/
// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n) where n is the length of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// write base conditions for when n=0, 1, and 2.
// Declare a dp of size input array length. Declare the first two elements of the DP.
// Then at eact index i, calculate the maximum of nums[i]+dp[i-2], dp[i-1]

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return max(nums[0],nums[1]);
        }
        int dp[n];
        dp[0] = nums[0];
        dp[1] = max(nums[0],nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
};