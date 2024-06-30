# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
// The logic applied here is if the coin we are using at row level if less than current column index we will take the element from just above row as it is. Then, once the current coin and column index matches, then we will check if the current above matrix element is minimum or the element which is coins places behind it + 1. Then we will assign that element at current matrix. The last element in the matrix will be minimum coins used.



## Problem2 (https://leetcode.com/problems/house-robber/)
In this problem the main logic is we will check what is maximum robbery can a robber do with whether to choose or not choose decision. To calculate the maximum amount we can check what will be the maximum between the current element and i-2 element total or the previous i-1 element total. We will consider the path which gives us maximum amount and the last element in the array will give us an amount which is maximum. 