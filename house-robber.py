# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

first, second = 0, 0

for num in nums:
    first, second = second, max(first+num, second)

return second