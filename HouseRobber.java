public class HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp =new int[n];
        dp[0]=nums[0];
        if(n==1)return dp[0];
        dp[1]=Math.max(dp[0],nums[1]+0);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }

}

/*
public int rob(int[] nums) {
    return helper(nums,0);
}
private int helper(int[] nums,int idx){
    if(idx>=nums.length)return 0;
    int case1 = nums[idx]+helper(nums,idx+2);
    int case2=helper(nums,idx+1);
    return Math.max(case1,case2);
}
*/

/*
int[] memo;
public int rob(int[] nums) {
    this.memo=new int[nums.length];
    Arrays.fill(memo,-1);
    return helper(nums,0);
}
private int helper(int[] nums,int idx){
    if(idx>=nums.length)return 0;
    if(memo[idx]!=-1) return memo[idx];
    int case1 = nums[idx]+helper(nums,idx+2);
    int case2=helper(nums,idx+1);
    int result= Math.max(case1,case2);
    memo[idx]=result;
    return result;
}
*/
