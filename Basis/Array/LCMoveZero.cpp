#include <iostream>
#include <vector>

using namespace std;

int nums;

class Solution{
    public:
        void moveZeroes(vector<int>& nums){
            int m = 0;
            for(int x:nums){
                if(x!=0){
                    nums[m++] = x; 
                }
            }
            for(int i = m;i<nums.size();i++){
                nums[i] = 0;
            }
        }
};