class Solution:
    def rob(self, nums: List[int]) -> int:
        if(nums == None or len(nums) ==0):
            return 0
        
        n = len(nums)

        dp = [[0] * 2 for i in range(n)]

        dp[0][0] = 0
        dp[0][1] = nums[0]


        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0] , dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[n-1][0], dp[n-1][1])
            

         





    #     #Brute Force
    #     if len(nums) == 0 or nums == None:
    #         return 0
    #     return self.recursive(nums,0,0)

    # def recursive(self ,nums:list[int], index:int, amountRobbed : int)   -> int :

    #     if (index >= len(nums)):
    #         return amountRobbed

    #     case0 = self.recursive(nums, index+1 , amountRobbed)

    #     case1 = self.recursive(nums, index+2 , amountRobbed + nums[index] )
    
    #     return max(case0 , case1)
        