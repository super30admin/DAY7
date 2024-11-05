// Time Complexity :O(n) (one-dimensional array)
// Space Complexity :0(1) (just variables )
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class Problem2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp= new int[n];


        int prev=nums[0];
        int curr=Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            int temp=curr;
            curr=Math.max(curr, nums[i]+prev);
            prev= temp;
        }
        return curr;
    }

    public static void main(String args[]) {
        Problem2 prob2 = new Problem2();
        int[] nums={2,7,9,3,1};
        System.out.println("Output "+prob2.rob(nums));

    }
}
