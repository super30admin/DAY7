# Time Complexity : O(n)
# Space Complexity :O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        # maintain teo pointers
        # one is if the house is chosen and the other is if the house is not chosen
        not_chosen = 0
        chosen = nums[0]

        # then iterate over all the houses and find the amount when that house is chose and when its not chosen
        for n in range(1, len(nums)):
            temp = not_chosen
            # if house is not chose then the amount will be max from not chosen previous home and chosen previous home
            not_chosen = max(chosen, not_chosen)
            # if house is chose then the amount will be the value of previous to previous house + current amount
            chosen = temp + nums[n]
        return max(chosen, not_chosen)