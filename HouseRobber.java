/**
1. Exhaustive approach -> Take/not take
and then maximize the robbing.

Time complexity- 2^N, Space Complexity - O(N)(height of stack trace)

2. Approach- Top down
We use array as we have one decision making parameter.
we want max(dp[i-2]+current,dp[i-1])

Time complexity- O(N), Space Complexity -O(N)(Array);

3. Optimized approach: We only want two previous values. We do not need the entire array
We can use two variables instead of array.
prev = nums[0], curr = max and then change the curr according to the max value.

Time complexity- O(N), Space Complexity -O(1)(variables);
 */


 class Solution {

    public int rob1(int[] nums) {

        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i , int money){
        //base
        if(i>= nums.length || nums.length==0){
            return money;
        }
        //logic
        //choose
        int choose_money = helper(nums, i+2, money+nums[i]);

        //not choose

        int notchoose_money = helper(nums, i+1, money);

        return Math.max(choose_money,notchoose_money);
    }
    // DP Approach-> Tabulation
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] mat = new int[nums.length];

        mat[0]=nums[0];
        mat[1]=Math.max(mat[0],nums[1]);
        for(int i = 2; i<nums.length;i++){
            mat[i] = Math.max(nums[i]+mat[i-2],mat[i-1]);
        }

        return mat[mat.length-1];
    }
    // SPace Optimization
    public int rob2(int[] nums) {
        if(nums.length == 1) return nums[0];
    
        int prev=nums[0];
        int currMax=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            int temp = currMax;
            currMax = Math.max(currMax,prev+nums[i]);
            prev=temp;
        }
        return currMax;
}
}