// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * 
 * We store a 1D array which indicates max amount at that each index. Each index max amount is sum of 
 * nums[i]+ max amount till (i-2)th index. Max amount gathered will be the max of last two indexes values in new array.
 *
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int len=nums.length;
        int[] arr=new int[len];
        if(len==1){
            return nums[0];
        }else if(len==2){
            return Math.max(nums[0],nums[1]);
        }else{
            arr[0]=nums[0];
            arr[1]=nums[1];
            for(int i=2;i<len;i++){
                if(i==2){
                    arr[i]=nums[i]+arr[i-2];
                }else{
                    arr[i]=nums[i]+Math.max(arr[i-2],arr[i-3]);
                }
            }
        }
        
        return Math.max(arr[len-1],arr[len-2]);
    }
}
