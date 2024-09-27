# Time complexity: O(N) We iterate every numsLength -1 element and then append them to 2 arrays
# Space complexity: O(N) We use 2N size arrays (1 for keeping track of profit when the house is chosen and another one to keep track of profit when the house is NOT chosen)
class Solution:
    def rob(self, nums):
        numsLength = len(nums)
        notChosen = []
        chosen = []
        # When you arent choosing the first house, then the total profit is 0
        notChosen.append(0)
      # When there is no house to rob, return 0
        if numsLength == 0:
            return 0
          # When you choose the first house alone, the total profit is gotten by robbing that particular house alone.
        chosen.append(nums[0])
        
        for i in range(1, numsLength):
            # Not chosen scenario
            # Append the current notChosen array with max of previously chosen and notChosen computed profit
                notChosen.append(max(chosen[-1], notChosen[-1]))
            # Chosen scenario
            #Append chosen array with current profit + previous profit when the house is not chosen as adjacent houses cannot be chosen
                chosen.append(nums[i] + notChosen[-2])
        
        # Max profit is the max between after a series of houses are chosen or not chosen
        return max(chosen[-1], notChosen[-1])

def main():
    nums = [2,7,9,3,1]
    solution = Solution()
    print(solution.rob(nums))

if __name__ == "__main__":
    main()
