#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int length = nums.size();
        vector<int> result;
        for(int i = 0; i < length; i++){
            for(int j = i+1; j<length; j++){
                if(nums[i] + nums[j] == target){
                    result.push_back(i);
                    result.push_back(j);
                    return result;
                }
            }
        }
        return result;
    }
};

int main() {
    // 创建Solution类实例
    Solution solution;
    
    // 测试用例1
    vector<int> nums1 = {2, 7, 11, 15};
    int target1 = 9;
    vector<int> result1 = solution.twoSum(nums1, target1);
    cout << "测试用例1: [2, 7, 11, 15], target = 9" << endl;
    cout << "结果: [" << result1[0] << ", " << result1[1] << "]" << endl;
    cout << "预期: [0, 1]" << endl << endl;
    
    // 测试用例2
    vector<int> nums2 = {3, 2, 4};
    int target2 = 6;
    vector<int> result2 = solution.twoSum(nums2, target2);
    cout << "测试用例2: [3, 2, 4], target = 6" << endl;
    cout << "结果: [" << result2[0] << ", " << result2[1] << "]" << endl;
    cout << "预期: [1, 2]" << endl << endl;
    
    // 测试用例3
    vector<int> nums3 = {3, 3};
    int target3 = 6;
    vector<int> result3 = solution.twoSum(nums3, target3);
    cout << "测试用例3: [3, 3], target = 6" << endl;
    cout << "结果: [" << result3[0] << ", " << result3[1] << "]" << endl;
    cout << "预期: [0, 1]" << endl;
    
    return 0;
}