//Space Complexity: O(1)
//Time Complexity: O(2^n), where n is the length of the array.
//Time Limit exceeded  on leetcode.

class Solution {

private:
    int helper(vector<int>& nums, int index, int amount){
        //base case
        if(index >= nums.size()) return amount;
        //logic
        //choose
        int case1 = helper(nums, index+2, amount+nums.at(index));
        //not choose
        int case2 = helper(nums, index+1, amount);
        return max(case1, case2);
        
    }
    

public:
    int rob(vector<int>& nums) {
        if(nums.size()==0) return 0;
        return helper(nums,0,0);
    }
};