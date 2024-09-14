#include <iostream>
#include <vector>
using namespace std;

//更新index数组，使得index[i]表示从0到i位置能跳到的最远位置
class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<int> index;
        for(int i = 0; i < nums.size(); i++){
            index.push_back(i+nums[i]);
        }
        int jump = 0;
        int max_index = 0;
        while(jump<nums.size() && jump<=max_index){
            if(max_index<index[jump]){
                max_index = index[jump];
            }
            jump++;
        }
        if(jump == index.size()){
            return true;
        }
        return false;
    }
};









//好似超时了
// int step = 0;
//         int place = 0;
//         while(place < nums.size()-1){
//             if(nums[place]+place >= nums.size()-1){
//                 return true;
//             }
//             int max = 0;
//             for(int i = 1; i <= step; i++){
//                 int temp = place+i;
//                 if(nums[temp] > max) max = nums[temp];
//             }
//             place = max;
//             step = nums[place];
//             if(nums[place]+place >= nums.size()-1){
//                 return true;
//             }
//         }
//         return false;