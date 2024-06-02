/**
 Approach: Dynamic Programming whith 0/1 methodology

 Working:
     declare the dp array with input array length and size 2 for 0 and 1
         case  0: do not choose the current house
         currentIndexVal for 0 = maximum of previous robbed 0 and 1 case

         case 1: choose the current house
            currentIndexVal for 1
                = previous house not chose value (i.e case 0) + current house robbed amount

     return the maximum case 0/1 of the last robbed house

 Time Complexity:O(n)
 Space Complexity: O(m*n)
 */

class HouseRobberDPMatrix {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }


        int[][] dp = new int[nums.length][2];
        int m = dp.length;

        //setting the first row int matrix
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i=1;i<m; i++) {

            // //case0
            // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // //case1
            // dp[i][1] = dp[i-1][0]+nums[i];
        }

        return Math.max(dp[m-1][0], dp[m-1][1]);

        //recursive solution
        //return robHouse(nums, 0, 0);

    }


    //resursive solution
    private int robHouse(int[] nums, int index, int amount) {


        //base case
        if(index>=nums.length){
            return amount;
        }


        //case 0
        int case0 = robHouse(nums, index+1, amount);
        //case1
        int case1 = robHouse(nums, index+2, amount+nums[index]);

        return Math.max(case0, case1);
    }
}