// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class Solution
{
    public int Rob(int[] nums)
    {
        int n = nums.Length;
        if (n == 1) return nums[0];
        //int[] dp = new int[n];
        // optimize space complexity by using two variables prev and curr
        int prev = nums[0];
        int curr = Math.Max(nums[0], nums[1]);

        for (int i = 2; i < n; i++)
        {
            int temp = curr;
            curr = Math.Max(curr, nums[i] + prev);
            prev = temp;
        }

        //return dp[n-1];
        return curr;
    }
}

public class Program
{
    public static void Main()
    {
        Solution obj = new Solution();
        int[] nums = new int[]{ 1, 2, 3, 1};
        //Output: 4
        int result = obj.Rob(nums);
        Console.WriteLine(result);
    }
}