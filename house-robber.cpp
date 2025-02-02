/*Recursion Approach:

The recursive approach explores all possibilities by either skipping the current house (case0) or robbing it (case1).
Base cases: If there are no more houses to consider, return the current total cost. Otherwise, choose the maximum of the two cases.
The result is the maximum amount that can be robbed.


Dynamic Programming (DP) Approach:

Create a DP array dp of the same length as nums, where dp[i] represents the maximum amount that can be robbed up to house i.
Initialize the first two elements of dp based on the first two houses.
For each house i, the maximum amount that can be robbed is the maximum of either skipping the current house (dp[i-1]) or robbing it (nums[i] + dp[i-2]).
The final result is the last element of the dp array.

Time Complexity:

Recursion: Exponential time complexity due to exploring all possibilities.
DP: O(n), where n is the number of houses, as each house is considered only once.
Space Complexity:

Recursion: O(n) for the recursive call stack.
DP: O(n) for the DP array.

*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    // int rob(vector<int>& nums) {
    //     return helper(nums,0,0);
    // }
    // int helper(vector<int>& nums, int i, int cost) {
    //     if(i>=nums.size())return cost;
    //     int case0= helper(nums,i+1,0);
    //     int case1= helper(nums,i+2,cost+nums[i]);
    //     return max(case0,case1);
    // }
    int rob(vector<int>& nums) {
        if(nums.size()==0)return 0;
        if(nums.size()==1)return nums[0];
        vector<int> dp(nums.size(), 0);
        dp[0]=nums[0];
        dp[1]=max(nums[0],nums[1]);
        for(int i=2;i<nums.size();i++){
            dp[i]=max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.size()-1];
    }
};