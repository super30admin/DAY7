class Solution:
    def rob(self, nums) -> int:
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        
        n=len(nums)
        dp=[0]*n
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])
        #print(dp[0], dp[1])
        for i in range(2,n):
            dp[i]=max(dp[i-1],dp[i-2]+nums[i])
            #print(dp[i])
            
        return dp[-1]