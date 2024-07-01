//Time complexity O(n)
//space complexity O(1)

class HouseRob {

    //*****Exhaustive approach */
    // public int rob(int[] nums) {
    //     int  re = helper(nums,0);
    //     return re;
    // }
    // public static int helper(int[] nums, int idx){
    //     if(idx>=nums.length) return 0;
    //     //not choose
    //     int case1 = helper(nums, idx+1);
    //     //choose
    //     int case2 = nums[idx] + helper(nums, idx+2);
    //     return Math.max(case1, case2);
    // }

    
//*****Optimised solution */
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int curr = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        HouseRob obj = new HouseRob();
        int[] houses = {1, 2, 3, 1};
        System.out.println(obj.rob(houses));
    }
}
