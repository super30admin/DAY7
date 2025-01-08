// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 198. House Robber
// Approach: Dynamic Programming
// Time Complexity: O(n)

class Solution
{
public:
    int rob(vector<int> &nums)
    {

        // Base Case
        if (nums.empty() || nums.size() == 0)
        {
            return 0;
        }

        int n = nums.size();
        int skip = 0;
        int take = 0;

        // Iterate over houses
        for (int i = 0; i < n; i++)
        {

            // Temporary store for Skip
            int tempSkip = skip;

            // Case 0
            skip = max(skip, take);

            // Case 1
            take = tempSkip + nums[i];
        }

        // Return the max of skip or take
        return max(skip, take);
    }
};