# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)

## Problem2 (https://leetcode.com/problems/house-robber/)


# Notes
- What is DP ( Dynamic Programming )
  - When to use DP? (https://www.youtube.com/watch?v=Hdr64lKQ3e4)
    - Finding optimal solution
    - Counting the total number of solution for the problem.
  - Optimisation of repeated sub problems
    e.g time 1:00:00 = in the youtube video
  - bottom up dp / tabulation
    - Smaller sub problems are solved first and then we will cover the large problem.
    - Patterns
      - Coin Change 
        - ( Greedy Approach [ Always take optimal approach at each step instead of trying out all the combination ])
          - Explanation video: https://www.youtube.com/watch?v=HzeK7g8cD0Y
          - Works if input is [2,5] and target is 10. 
          - Fails if input is [1,2,5] target is 11
            - here if we always take 5 at each step, we won't be able to make 11.
        - if greedy fails Be Exhaustive [ Check all the possible ways ]
          - 2 possibilityies at each stage. 
            - either choose it or not choose it.
            - here we will explore all the possibilities instead of identifying whether to go to the other path or not.  
          - This will be recursion with time complexity 2(M + N) where N is elements and M is target.
            - 2 is because at each stage we will have 2 choices to make
    - Basic Framework will be same for all the patterns
  - top down dp / memoization [Will be covered in next classes]
- How to approach the problem? (e.g Coin Change.)
  - Find the base case (Default values for the array)
  - Build the solution with array having length till input length
  - Try to find pattern while accessing the element in the array and think if we can discard the array and use the single variable instead

- Take Aways
  - Find repeated sub problems
  - Start with Matrix first and then optimise it with array based on the pattern identification.
  

- Coin Change 2
  - 

- Paint House
