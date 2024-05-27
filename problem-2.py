# Time Complexity : O(n)
# space complexity : O(1)

# Approach :

# this is a pick and no pick type of problem
# let initially if we dont pick the first house , let that value be 0 and if we pick that house then assign the first value of array
# iterate from index=1 till the array, store the zero value in a temp variable
# if we pick a value, it would the sum of the value of that index and 0 value of the previous index
# if we dont pick a value, it would be the max value of the (zero value of the previous elments)

class Solution:
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return -1

        lenArr = len(nums)

        zeroPrev = 0
        onePrev = nums[0]

        for i in range(1, lenArr):
            tempZero = zeroPrev
            zeroPrev = max(zeroPrev, onePrev)
            onePrev = nums[i] + tempZero

        return max(zeroPrev, onePrev)
