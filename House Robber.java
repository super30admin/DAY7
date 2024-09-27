/*
Time Complexity : O(n)
Space Complexity : O(1). This is because the array is substitued by using two variables and we do not need the solutions of very old subproblems but just the sub problem soultion of one level above the current iteration/problem.
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        //add the amount for each iteration based on choosing and not choosing each element in the input array
        int choose=0, notchoose = 0,temp=0;
        //iterate through the array
        for(int i=0;i<nums.length;i++){
            choose = temp + nums[i];
            temp = notchoose;
            notchoose = Math.max(choose,notchoose);//among the choose and not choose values pick the max for the next not choose inorder not to miss the largerst value in between
        }
        return Math.max(choose,notchoose);
    }
}