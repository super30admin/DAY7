##############198. House Robber####################

// Time Complexity : N
// Space Complexity : N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//I created another list with running sum but it was with some tweaks. When I visit first element I check what is the maximum value when I moved to 2nd element I can't take value from i-1 (i.e. 1st element) so found max I can rob. When I moved to 3rd element (can't rob from 2nd) so what is the max I can get from elements <=i-1. Once the list is built just return max from list

For input 
[1,2,3,1] -> my list is [0, 1, 2, 4, 3]
[2,7,9,3,1] -> my list is [0, 2, 7, 11, 10, 12]


class Solution:
    def rob(self, nums: List[int]) -> int:
        lmax=[0]
        #tmp=[0]
        for i in range(len(nums)):		# creating array with rolling some with tweaks
            if i==0:
                lmax.append((nums[i]))
                #print("if:",lmax)
            else:
                #print("else:",i,lmax)
                #print(lmax[:i])
                tmp=lmax[:i]
                vmax=max(tmp)
                lmax.append(vmax+nums[i])
        #print("final",lmax)
        return max(lmax)			# find max for new array


        
        

#############322. Coin Change###################


// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Not able to come up with good solution


// Your code here along with comments explaining your approach in three sentences only
Not able to come up with any good solution though we could have done it in brute force but it would have been too long with multiple permutations and combinations




  