#approach : 
## Time complexity - O(n)
# Space complexity - O(n)


class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1:
            return nums[0]
        
        dp = [0]*n
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])

        for i in range(2,n):
            dp[i]=max(dp[i-1],dp[i-2]+nums[i])

        return dp[n-1]

        #Recursive
        ## REcursive solution 
        # TIme complexity- O(2^n) where n is the number of houses
        # space complexity = O(n)
        # def helper(nums,index):
        #     if index>=len(nums):
        #         return 0
        #     case1 = helper(nums,index+1)
        #     case2= nums[index] + helper(nums,index+2)
        #     return max(case1,case2)

        # return helper(nums,0)