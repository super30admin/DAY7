//Recursion or Exhaustion approach
//Time limit exceeded is the issue with recursion.
class houseRobber1 {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        return recurse(nums,0,0);

    }
    private int recurse(int[] nums,int index,int amountRobbed){
        //base
        if(index >= nums.length){
            return amountRobbed;
        }
        //logic
        //zero case or robber didn't rob
        int case1= recurse(nums,index+1,amountRobbed);
        //one case or robber did rob
        int case2 = recurse(nums,index+2,amountRobbed+nums[index]);
        return Math.max(case1,case2);
    }
}

//dp approach using array
class houseRobber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int n = nums.length;
        //Using an array here
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1;i<n;i++){
            //If we rob the house
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //If we don't rob the house
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][1],dp[n-1][0]);
    }
}

//dp using skip and take

class houseRobber3 {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int n = nums.length;
        //Using an array here
        int skip = 0;
        int take = nums[0];
        for(int i = 1;i<n;i++){
            int tempSkip = skip;
            skip = Math.max(skip,take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip,take);
    }
}