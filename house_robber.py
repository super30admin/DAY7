# Time complexity: O(n) 
# space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n <2 : return nums[0] 
        prev = nums[0]
        curr = max(nums[0], nums[1])  
        for i in range(2, n):
            #        not choose  choose
            temp = max(curr,    nums[i]+prev) 
            # max b/w curr total and current num + total in prev

            prev = curr
            curr = temp
        
        return curr