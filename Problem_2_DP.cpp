//Space Complexity: O(NM), where n is number of houses and m is the number of choices we have.
//Time Complexity: O(n), where n is the length of the array.
//Executed successfully  on leetcode.

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0) return 0;
        int dp[nums.size()][2];
        for(int i=0; i<nums.size(); i++){
            dp[i][0] = 0;
            dp[i][1] = 0;
        }
        dp[0][1] = nums.at(0);
        
        for(int i=1; i<nums.size(); i++){
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums.at(i);
        }
        int result = max(dp[nums.size()-1][0], dp[nums.size()-1][1]);
        return result;
    }
};