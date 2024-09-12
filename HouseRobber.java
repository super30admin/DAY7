
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried using 2 dimensional array,but could not crack the logic


// Approach
// 1) create two variables inclusive and exclusive and assign inclusive with arr[0] and exclusive with 0
// 2) while traversing the array, inclusive will be maximum of previous inclusive or (exclusive + present array value)
// 3) update exclusive with previous inclusive and return inclusive
public class HouseRobber {
	
	public int maxAmount(int[] arr) {
		if(arr.length == 0){
            return 0;
        }else if(arr.length == 1){
            return arr[0];
        }else if(arr.length == 2){
            return Math.max(arr[0],arr[1]);
        }
		int incl = arr[0];
		int excl = 0;
		for(int i=1;i<arr.length;i++) {
			int temp = incl;
			incl = Math.max(incl, excl+arr[i]);
			excl = temp;
		}
		return incl;
	}

	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();
		int[] nums = {1,2,3,1};
		int res = obj.maxAmount(nums);
		System.out.println(res);
	}

}
