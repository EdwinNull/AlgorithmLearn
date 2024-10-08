#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()<2){
            return 0;
        }
        int current_max_index = nums[0];
        int pre_max_index = nums[0];
        int jump_min = 1;
        for(int i = 1;i<nums.size();i++){
            if(i>current_max_index){
                jump_min++;
                current_max_index = pre_max_index;
            }
            if(pre_max_index<nums[i]+i){
                pre_max_index = nums[i]+i;
            }
        }
        return jump_min;
    }
};
