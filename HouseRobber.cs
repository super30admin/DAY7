// time complexity = O(n) where n = number of houses
// space complexity = O(1) as we are just using 2 variables
public class Solution
{
    public int Rob(int[] nums)
    {
        int n = nums.Length;
        if (n == 1)
        {
            return nums[0];
        }
        // int[] dp = new int[n];
        // dp = nums;
        // dp[1]= Math.Max(dp[0],dp[1]);
        int prev = nums[0];
        int curr = Math.Max(prev, nums[1]);
        for (int i = 2; i < n; i++)
        {
            //dp[i]=Math.Max(dp[i-1],dp[i]+dp[i-2]);
            int tmp = curr;
            curr = Math.Max(curr, prev + nums[i]);
            prev = tmp;
        }
        return curr;
    }
}