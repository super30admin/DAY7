// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>
 
using namespace std;

class Solution {
public:
    // int helper(vector<int>& nums, int i, vector<int>& dp) {
    //     // base
    //     if (i >= nums.size()) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     // choose
    //     int case1 = nums[i] + helper(nums, i+2, dp);
    //     //not choose
    //     int case2 = helper(nums, i+1, dp);

    //     return dp[i] = max(case1, case2);
    // }
    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        vector<int> dp(nums.size(), 0);
        dp[0] = nums[0];
        dp[1] = max(dp[0], nums[1]+0);
        for (int i=2; i<nums.size(); i++){
            dp[i] = max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.size()-1];
        // return helper(nums, 0, dp);
    }
};