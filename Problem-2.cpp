// Time Complexity : O(n+2)=> n is the number of houses
// Space Complexity : O(n+2), we can also do this in constant time if we use three varaibles
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Actually, coming up with a recurrance relation is relatively easier way fo
//                                           dp problems

// Your code here along with comments explaining your approach
class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        int dp[n+2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<n+2;i++)
        {
            dp[i] = max(dp[i-2]+nums[i-2], dp[i-1]);
        }
        return dp[n+1];
    }
};