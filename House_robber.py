class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None:
          return -1
        # [6,2,3,1]
          #     NoRob   Rob
          # 6.   0.      6
          # 2.   6.     2+0
          # 3.   6.     6+3 = 9 
          # 1.   9.     1+2 = 3

        dp = [[0 for i in range(2) ]for j in range(len(nums))]
        dp[0][1] = nums[0]
        n = len(nums)
        #  [0, 6], [0, 0], [0, 0], [0, 0]]
            # 0       1       2       3    == i
        
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = nums[i] + dp[i-1][0]

        print(dp)

        return max(dp[n-1][0], dp[n-1][1])
        
