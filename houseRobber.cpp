//TC o(n)
//SC o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//In this approach we will use two int instead of creating a dp matrix to optimize sc
//Since we have only 1 deciding factor we will go through every option and check for max 
//for choose and no choose case and will return the max in the end
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==1)return nums[0];
        vector<int>dp(n);

        int prev2 = nums[0];
        int prev1 = max(nums[0],nums[1]);
        for(int i =2;i<n;i++){
            int curr = max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
};
