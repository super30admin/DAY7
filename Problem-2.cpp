// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        if (nums.empty() || nums.size() == 0)
        {
            return 0;
        }
        // keep track of the previous selection
        int skip = 0, take = 0;

        // update the current selection with the help of take and skip
        // considering the previous selection
        for (int i = 0; i < nums.size(); i++)
        {
            int tempSkip = skip;
            skip = max(skip, take);
            take = tempSkip + nums[i];
        }

        return max(skip, take);
    }
};