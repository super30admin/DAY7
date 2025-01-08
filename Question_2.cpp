#include <bits/stdc++.h>
using namespace std;
#include <vector>
#include <iostream>
int rob(vector<int>& nums) {
    int n=nums.size();
    if(n==1) return nums[n-1];
    int y=nums[n-1],x=max(nums[n-2],nums[n-1]);
    if(n==2) return x;
    int t;
    for(int i=n-3;i>=0;i--){
        t=y;
        y=x;
        x=max(nums[i]+t,x);
    }
    return x;
}
int main(){
    vector<int> nums={2,7,9,3,1};
    cout<<rob(nums)<<endl;
    return 0;
}