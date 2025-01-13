class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums == None or len(nums) == 0:
            return 0
        
        n= len(nums)
        # dp = [[0] * 2] * n 
        # dp = [[0 for i in range(2)] for i in range(n)]

     
        
        # dp[0][0] = 0
        # dp[0][1] = nums[0]
        skip =0
        take = nums[0]
        for i in range(1,n):
            # dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            # dp[i][1] = nums[i] + dp[i-1][0]
            temp = skip
            skip = max(skip,take)
            take = nums[i] + temp

        # return max(dp[n-1][0],dp[n-1][1])   
        return max(skip,take)
        