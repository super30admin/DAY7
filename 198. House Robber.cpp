//Time Complexity = O(2^N)
//Space Complexity = O(N)
//where N is the size of array nums.
//Here time limit will exceed.
class Solution {
public:
    int helper(vector<int> nums, int index, int cash)
    {
        //base case
        if(index>=nums.size())
            return cash;
        
        //logic
        return max(helper(nums,index+1,cash), helper(nums,index+2, cash+nums[index]));
    }
    int rob(vector<int>& nums) {
        return helper(nums, 0,0);
    }
};


//Time Complexity = O(N)
//Space Complexity = O(1)
//where N is the size of array nums.
class Solution {
public:
    int rob(vector<int>& nums) {
        int skip=0, take=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            int temp = skip;
            skip = max(temp, take);
            take = temp + nums[i];
        }
        return max(skip, take);
    }
};
