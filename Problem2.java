
public class Problem2 {
	
	//Step 1: recursive 
	//Time complexity : O(n)
	//Space Complexity :O(n) recursion stack
/*	public static int rob(int[] nums) {
		
		return rob(nums,nums.length-1);
		
	}
	
	private static int rob(int[] nums,int i) {
		if(i<0)
			return 0;
				
		return Math.max((rob(nums,i-2)+ nums[i]),rob(nums,i-1));
		
	}*/
	
	
	//Time Complexity :O(n)
	//Space Complexity :O(1)
	 public static int rob(int[] nums) {
	       if(nums==null || nums.length==0)
	           return 0;
	        
	        int DC=0;
	        int C=0;
	        
	        for(int i=0;i<nums.length;i++){
	            int temp = DC;
	            DC=Math.max(DC,C);
	            C=nums[i]+temp;
	        }
	        
	        
	        return Math.max(C,DC);
	    }
	
	public static void main(String args[]) {
		
		int[] nums= new int[] {1,2,3,1};
		int res= rob(nums);
		System.out.println("res:"+res);
	}

}
