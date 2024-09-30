//198. House Robber

// Time Complexity : 2^n
// Space Complexity :n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



public class HouseRobber {

    //-----Exhaustive approach------------------------------------------------------------------

    // public int rob(int[] nums){
    //     return helper(nums, 0, 0);
    // }

    // private int helper(int[] nums, int i, int robbings){

    //     if(i >= nums.length) return robbings; // base case array ended

    //     int case0 = helper(nums, i+1, robbings); // its a no choose case, we are not choosing this house and starting from next hence i+1, and no robbings
    //     int case1 = helper(nums, i+2, robbings + nums[i]);// we are choosing in this case, and skipping the next hence i+2 and robbing will added with present house nums[i]

    //     return Math.max(case0, case1);
    // }
    //--------------------------------------------------------------------------

    //when We draw tree we see there are repeated subproblems so it will solved by DP 
    //DP approach using 1D array because one depending parameter only

    
        
    //     public int rob(int[] nums) {
    //         int n = nums.length;
    //         if(n==1) return nums[0];
      
    //         int[] dp = new int[n];
    //         dp[0] = nums[0];  // for first value maximum value will be if choose it 
    //         dp[1] = Math.max(nums[0], nums[1]);// second dp element if we do not choose then 
    //         //value comes from right and if we choose value will be maximum value will be same will skip next
      
    //         for(int i = 2; i <n; i++){
      
    //           dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
    //           // choose case and not choose case, if not choosing taking previous solved value,
    //           // when choosing add curren value and skip next value and take remaining dp value not adjeacent
      
    //          }
    //       return dp[n-1];

    //       // TC- O(n)
    //       //SC- O(n)
      
         
    //   }

      //--------DP with only 2 variable----------------------------------------------

      public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
  
       
        int prev = nums[0];  // for first value maximum value will be if choose it 
        int curr = Math.max(nums[0], nums[1]);// second dp element if we do not choose then 
        //value comes from right and if we choose value will be maximum value will be same will skip next
  
        for(int i = 2; i <n; i++){
            int temp = curr;
  
          curr = Math.max(curr, nums[i] + prev);

          prev = temp;
        
  
         }
      return curr;

      // TC- O(n)
      //SC- O(1)
  
     
  }
    


    public static void main(String args[]){

        HouseRobber hr = new HouseRobber();

        int[] houses = {2,7,9,3,1};
        int robbings = hr.rob(houses);

        System.out.println(robbings);
        
    }
    
}
