// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
//approach: created a dp array to calculate the max sum that can be obtained.

// Your code here along with comments explaining your approach


public class houserobber {

    class Solution {
        public int rob(int[] nums) {
            int n=nums.length;
            int [] arr =new int[n];
            if(n==1)    return nums[0];
            arr[0]=nums[0];
            arr[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<n;i++)
            {
                arr[i]=Math.max(arr[i-1],nums[i]+arr[i-2]);
            }
            return arr[n-1];
        }
    }
    
}
