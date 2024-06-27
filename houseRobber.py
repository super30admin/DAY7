
# Time Complexity : O(n) for Dp approach and O(2^n) for recursive approach
# Space Complexity : O(n) for Dp as i am storing in an array. I am not sure but i think recursive stack space.
# Did this code successfully run on Leetcode : yes

# Any problem you faced while coding this : Yes i faced challenges while figuring out the base condition for recursive code. 
#and for Dp approach what should be the initial values stored in the dp array for when i < 0

class Solution:
    def rob(self, nums: List[int]) -> int:

        # Dynamic programming
        dp=[0] * len(nums)
        for i in range(len(nums)):
            if i-1<0:
                dp[i]=nums[i]
              
            else:
                dp[i] = max(dp[i-1], nums[i]+dp[i-2])

        return dp[-1]


        # Recursive code
        def helper(nums,index):
            if index>=len(nums):
                return 0

            take=nums[index]+helper(nums,index+2)
            notake=helper(nums,index+1)
            return  max(take,notake)

        return helper(nums,0)


    # Approach
    # I sketched the tree first by using the exhaustive approach taught in the class.
    #                             [1,2,3,1]
    #                         [2,3,1]-0    [3,1] -1

    # this is what my initial node looked like. In the question they have given that we dont have to take the adjacent node 
    # so wat a given time we have to decide weather we have to take the current house or not. 
    # so we have 2 cases:

    # case 1: we take the current house and skip the next house.(right side of tree)
    # case 2 : we do not take the current house(left side to the tree)

    # base case was that when the array becomes empty. i.e when the index reached the last house in the array
