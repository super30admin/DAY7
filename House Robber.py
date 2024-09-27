#Space Complexity : O(N*2) as it N*2 matrix we have only two option 1 or 2
# it can also be done wothout j loop as well   
#Time Complexity : O(N) 
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) ==0:
            return 0
        dp  = [[0 for x in range(2)]for y in range(len(nums)+1)]
        for i in range (1,len(dp)):
            for j in range (2):
                if j == 0:
                    dp[i][0]= max(dp[i-1][0],dp[i-1][1])
                elif j ==1:
                    dp[i][1] = dp[i-1][0] + nums[i-1]
        result = max(dp[len(dp)-1][0],dp[len(dp)-1][1])
        return result