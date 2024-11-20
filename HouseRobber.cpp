//given an array representing the amount of money in each houese
// [1,2,3,1]
// return the max amount of the money we can rob without alerting police
//the first restriction is we can not visit the adjacent house
//[1,3] = 4
//[2,1] = 3
// return 4

// first approach is that we got to the max amount house
// [1,2,3,1]
//      ^
// [5,5,5,6,5]
// [5,6]
// [5,5,5]

// in that case we need to apply exhaustive approach
// we find all the possible combinations
// even houses robbed 
// odd houses robbed
// [1,2,3,1]
//  but we can jump two houses at a time so in that case we need to make the decision at each house
// [1]
// we can either rob this house or no
// dp[0] = 1;
// dp[-1] = 0
// dp[0] = max(dp[0]+dp[-2],dp[-1])
// [2]
// dp[1] = 2
// dp[0] = 1
// [3]
// dp[3] = dp[3]+dp[1]
// dp[2] = dp[2]

class Solution {
public:
    int rob(vector<int>& nums) {
        // let us first create a dp array
        int n = nums.size();
        vector<int>dp(n,0);

        //base case
        if(nums.size()!=0)
            dp[0] = nums[0];
        if(nums.size()!=1)
            dp[1] = max(nums[0],nums[1]);
        //logic
        for(int i = 2; i < n; i++)
        {
            //for each house we can make two decision
            int case0 = dp[i-1];
            int case1 = nums[i] + dp[i-2];

            dp[i] = max(case0,case1); 
        }

        return dp[n-1];
    }
};