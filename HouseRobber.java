class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2) return nums[0];
        int prev= nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i=2; i< n; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;        
        }
        return curr;



        //return helper(nums, 0, 0);
    }

    // Exhaustive approach(exceeds time limit)
    // private int helper(int[] nums, int i, int amt){

    //     //base case
    //     if(i >= nums.length) return amt;





    //     //logic
    //     //not choose case
    //     int case0 = helper(nums, i+1, amt);

    //     //choose case
    //     int case1 = helper(nums, i+2, amt + nums[i]);

    //     return Math.max(case0,case1);

    // }
}