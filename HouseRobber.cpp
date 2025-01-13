class Solution {
public:
    //time complexity: O(n)
    //space complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    int rob(vector<int>& nums) {
        int n = nums.size();
        
        //using temp variable to save previous pick
        //helping not_pick to choose from previous pick and not_pick
        int not_pick =0;
        int pick = nums[0];
        for(int i=1; i<n; i++){
            int temp = pick;
            pick= not_pick+ nums[i];
            not_pick = max(not_pick,temp);
            
        }
        return max(not_pick, pick);
    }
};