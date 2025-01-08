public class HouseRobber {
    //time complexity: O(n)
    //space complexity: O(n)
    public int rob(int[] nums) {
        
        if (nums == null || nums.length ==0 ){
            return 0;
        }
        int [][] dp = new int [nums.length][2];
        dp[0][0] =0;
        dp[0][1] = nums[0];
        for (int i =1; i < nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];


        }

        return Math.max (dp[nums.length-1][0],dp[nums.length-1][1]);
    } 
    //time complexity: O(n)
    //space complexity: O(1)
    public int rob2(int[] nums) {
        if (nums == null || nums.length ==0 ){
            return 0;
        }
        int skip = 0;
        int take = nums[0];
        for (int i = 1; i < nums.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + nums[i];
        }
        return Math.max(skip,take);
    }
}
