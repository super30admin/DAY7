// Brute force - explore all possible solutions
// time complexity : 2^n where n is number of houses
// space complexity: o(1) not counting recursion stack size


class Solution {
public:
    int rob(vector<int>& nums) {
        
        return helper(nums, 0);
    }

    int helper(vector<int>&nums, int idx)
    {
        // base
        if(idx >= nums.size())
        {
            return 0;
        }

        // choose
        int a1 = nums[idx] + helper(nums, idx+2);

        // not choose
        int a2 = helper(nums, idx+1);

        return max(a1, a2);
    }
};


// using DP - 1D array 
// time : o(n)
// space : O(n)
class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp(nums.size()+1, 0);
        dp[1] = nums[0];
        for(int i = 2; i <=nums.size(); i++)
        {
            dp[i] = max(nums[i-1]+ dp[i-2], dp[i-1]);
        }

        return dp[nums.size()];
    }
};

// using dp - variables
// time : o(n)
// space : o(1)

class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp(nums.size()+1, 0);
        dp[1] = nums[0];

        int prev_prev = 0;
        int prev = nums[0];
        int curr = prev;
        for(int i = 1; i < nums.size(); i++)
        {
            curr = max(nums[i]+prev_prev, prev);
            prev_prev = prev;
            prev = curr;
        }

        return curr;
    }
};