//Time Complexity O(n)
//Space Complexity O(n)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;


class Solution {
public:
    int rob(vector<int>& nums) {
        int dp[nums.size()+1][2];
        dp[0][0]=0;
        dp[0][1]=0;
        
        for(int i=1;i<=nums.size();i++)
        {
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i-1];
        }
        return max(dp[nums.size()][1],dp[nums.size()][0]);
    }
};