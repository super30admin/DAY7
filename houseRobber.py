"""
198. House Robber

DP Approach (2D matrix) --
TC - O(m * n)
SC - O(n * 2) ==> O(2n) ==> ignore 2 since constance. Final SC - O(n)

# Optimized Space approach
# Skip-Take variable approach
# TC = O(n)
# SC = O(1)

"""

num = [2, 7, 9, 3, 1]


def houseRobber(nums):
    n = len(nums)

    skip = 0
    take = nums[0]

    for i in range(1, n):
        temp = skip

        skip = max(skip, take)

        take = temp + nums[i]

    return max(skip, take)


# DP Approach (2D matrix)
def houseRobber2DMatrix(nums):
    if nums is None or len(nums) == 0: return -1

    n = len(nums)

    dp = [[None for _ in range(2)] for _ in range(n)]

    # add 0th row 0th col = 0 since we choose not to rob that house
    dp[0][0] = 0

    # add 0th row 1st col to be nums[0] since we choose to rob this house
    dp[0][1] = nums[0]

    for i in range(1, n):
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])

        dp[i][1] = dp[i - 1][0] + nums[i]

    return max(dp[n - 1][0], dp[n - 1][1])


if __name__ == '__main__':
    print(houseRobber2DMatrix(num))
    print(houseRobber(num))
