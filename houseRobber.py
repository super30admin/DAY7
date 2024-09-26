"""
House Robber
Approach -
1. Here unlike coinchange and house paint, we have 1 DA array since there's only 1 deciding factor.
2. There is no specific amount which would cause the array to terminate. The tree can expand till achieved max value
3. This is what causes repeated sub problems. Tree shapes will help decide if its a repeated sub problem
4. If the amount was the deciding factor than the tree shape would vary.

TC = O(n)
SC - O(1)
"""
n = [2,7,9,8,1]

# recursive
def houseRobber(nums):
    if nums is None or len(nums) == 0:
        return -1

    skip = 0
    take = nums[0]
    temp = 0

    for i in range(len(nums)):
        # store value of skip since its required further
        temp = skip
        # do not rob
        skip = max(skip, take)
        # rob
        take = temp + nums[i]

    return max(skip, take)


print(houseRobber(n))

#recursive
# '==' doesnt work since we're increasing index by 2
    # it might go out of bound
    # if index >= len(nums):
    #     return amountRobbed
    #
    # # case 1
    # # do not choose or case 0
    # case1 = helper(nums, index+1, amountRobbed)
    #
    # #case2
    # # choose or case 1
    # case2 = helper(nums. index+2, amountRobbed + nums[index])
    #
    # return max(case1, case2)
