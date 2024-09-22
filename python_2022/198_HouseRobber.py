# time complexity : O(n)
# space complexity: O(1)



# class Solution:
#     def rob(self, nums) -> int:
#         if nums == None or len(nums) == 0:
#            return 0
#         n = len(nums)
#         dp = [0 for i in range(n)]
#         if(n<2):
#             return nums[0]
#         dp[0] = nums[0]
#         dp[1] = max(nums[0], nums[1])
       
#         for i in range(2, n):
#             dp[i] = max(dp[i-1], nums[i]+dp[i-2])
#         return dp[n-1]
class Solution:
    def rob(self, nums):
        if not nums or len(nums)==0:
            return -1
        if len(nums)<2:
            return nums[0]
        prev= nums[0]
        curr= max(nums[0],nums[1])
        for i in range(2, len(nums), 1):
            temp=max(curr,prev+nums[i])
            prev=curr
            curr=temp
        return curr

obj = Solution()
print(obj.rob([6,9,8,1,1,5]))