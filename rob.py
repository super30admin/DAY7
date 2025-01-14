class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0

        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp

        return rob2  
# time complexity: O(n) because we only need to iterate through the nums array once
# space complexity: O(1) because we are only using a constant amount of extra space
