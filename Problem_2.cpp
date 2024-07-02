/*
Time Complexity: O(m*n)

Space Complexity: O(n) 
*/

#include<iostream>
#include<vector>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        int numOfHouses = nums.size();
        if (numOfHouses <= 1) return nums[0]; 
        int arr [numOfHouses];
        long amount = 0;
        arr[0] = nums[0];
        arr[1] = std::max(nums[0], nums[1]);
        for(int i = 2; i < numOfHouses; i++){
            arr[i] = std::max(arr[i-1], nums[i] + arr[i-2]);
        }
        return arr[numOfHouses-1];
    }
};

int main(){
    Solution sol = Solution();
    std::vector<int> arr {1,2,3,1};
    int exp_res = 4;
    int res = sol.rob(arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }

    arr = {2,7,9,3,1};
    exp_res = 12;
    res = sol.rob(arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }
}
