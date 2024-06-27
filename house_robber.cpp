// Approach: keeping an array for storing the max amt robbed for diff number of houses - starting from just the first house and storing the max amt in the 0th index. formula -> the max amt robbed will either be the prev max robbed (1 house less) or it will be (curr house + prev to prev house), because we have to leave a gap bet houses. return the amt we get when there are all the houses (last index).
// Time: O(n)
// Space: O(n) - can be optimized but didnt try

class Solution {
public:
    int rob(vector<int>& nums) {
        int arr[nums.size()];
        // vector<int> arr(nums.size());
        for(int i = 0; i < nums.size(); i++) {
            if(i == 0) {
                arr[0] = nums[0];
            }
            else if(i == 1) {
                arr[1] = max(arr[0], nums[1]);
            }
            else {
                arr[i] = max(arr[i-1], (nums[i] + arr[i-2]));
            }
            // cout<<i<<" "<<arr[i]<<endl;
        }
        return arr[nums.size()-1];
    }
};