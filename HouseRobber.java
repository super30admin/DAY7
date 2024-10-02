public class HouseRobber {
    // Time complexity: O(n)
    // Space Complexity : O(1)
    public int rob(int[] nums) {
        /* return robber(nums, 0, 0);
        
    }
    private int robber(int[] houses, int i, int amount){
        // base case
        if(i>=houses.length) return amount;
        
        // choices
        int case0 = robber(houses, i+1, amount);
        int case1 = robber(houses, i+2, amount+houses[i]);
        
        return Math.max(case0,case1); */
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int prev = 0, cur = nums[0];
        for(int i=2;i<=n; i++){
            int temp = cur;
            cur = Math.max(cur, nums[i-1] + prev);
            prev =temp;
        }
        return cur;
    }
}