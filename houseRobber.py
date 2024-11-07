# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# We first check if there are no houses. We create a dp array of len(nums).
# TO find non alternating max count, we will assume 3 pointers i-2,i-1 and i. If i-2+(i) > i-1; for that stage, set dp[i] as max. 
# Last term of dp array should be max


class Solution:
    def rob(self,nums:list[int]) -> int:

        if nums == []:                                      # empty array
            return 0

        m = len(nums)                                       # create a dp array
        dp = [0]* m
        dp[0] = nums[0]                                     # base cond :0
        dp[1] = max(nums[0],nums[1])                        # base cond :1

        #house1, house2, check1, check2
        #x x x , house1, house2, check1
        for i in range(2,m):
            # if i == 0:                                              
            #     dp[i] = nums[i]
            # elif i == 1:                                    
            #     dp[i] = max(nums[0],nums[1])    
            # else:                                           
                dp[i] = max(nums[i]+dp[i-2],dp[i-1])         # check1+house1 vs house2

        return dp[-1]                                        # check last at m-1



# class Solution:
#     def rob(self, nums: list[int]) -> int:
#         rob1 =  0
#         rob2 =  0
#         # rob1,rob2,n,n+1,n+2
#         # x,rob1,rob2,n,n+1
#         for n in nums:
#             temp = max(n+rob1,rob2)       
#             rob1 = rob2
#             rob2 = temp
#         return rob2

arr = [4,3,2,3]

print(Solution().rob(arr))
