#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
private:
vector<vector<int>> result;
vector<int> path;
public:
    void Huisu(vector<int>& nums,int start){
        result.push_back(path);
        for(int i = start;i < nums.size();i++){
            if(i > start && nums[i]==nums[i-1])continue;
            path.push_back(nums[i]);
            Huisu(nums,i+1);
            path.pop_back();
        }
        return;
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        Huisu(nums,0);
        return result;
    }
};