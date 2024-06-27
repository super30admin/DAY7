#The rob method uses a dynamic programming approach to find the maximum amount of money that can be robbed from houses represented by the list nums. It maintains two variables, arr and brr, to track the maximum money that can be robbed up to even-indexed and odd-indexed houses, respectively. It iterates through nums, updating arr and brr based on whether the current house index is even or odd. Finally, it returns the maximum value between arr and brr, which represents the maximum money that can be robbed.
#Time Complexity: O(n), where n is the length of nums.
#Space Complexity:O(1), as it uses a constant amount of extra space regardless of the input size.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        arr=nums[0]
        brr=nums[1]
        for i in range(2,len(nums)):
            if(i%2==0):
                brr=max(arr,brr)
                arr+=nums[i]
            else:
                arr=max(arr,brr)
                brr+=nums[i]
        return max(arr,brr)