/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Over here the robber just has the option of looting houses which arent adjacent.
//The houses that can be looted are the current house i-1 or the next house and the previous house i,i-2
//Space complexity for the DP solution is O(n)
//Time complexity is O(n) since we iterate through all elements in the array

public class house_robber1 {

	/**
	 * @param args
	 */
public static int rob(int[] nums) {
        
        if(nums.length == 0){return 0;}
        int n =  nums.length-1;
        int[] dp = new int[nums.length+1];
        if(nums.length == 1 ) { dp[0] = nums[0];}
        else if(nums.length >=2){
            dp[0] = nums[0]; //if there are two entries. the 1st entry would be maximum of both zeroeth and first entry
            dp[1] = Math.max(nums[0],nums[1]);
        }
     
        
        for(int i=2;i<nums.length;i++){
            
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]); //Either select the previous house or the present and the previous to 
            //previous house since two houses cannot be adjacent.
            
        }
        return dp[n];//return the max robbed value
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] {2,7,9,3,1};
		
		int amount = rob(arr);
		
		System.out.println(amount);
		
	}

}
