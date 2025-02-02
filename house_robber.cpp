// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach: Dynamic Programming
// Each house we have two choice, either rob or not rob
// If we rob this house, value will be this house + previous to previous
// If we do not rob this house, value will be previous house
// dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1]);

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n + 1);
        dp.push_back(0);
        dp[1] = nums[0];
        for(int i = 2; i <= n; i++){
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
};