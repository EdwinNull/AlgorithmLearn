#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        int length = nums.size();
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
};

int main(){
    Solution solution;
    vector<int> nums1 = {1, 2, 3, 4, 5};
    cout << "测试用例1: [1, 2, 3, 4, 5]" << endl;
    cout << "结果: " << (solution.containsDuplicate(nums1) ? "true" : "false") << endl;
    cout << "预期: false" << endl << endl;
    vector<int> nums2 = {1, 2, 3, 4, 5, 1};
    cout << "测试用例2: [1, 2, 3, 4, 5, 1]" << endl;
    cout << "结果: " << (solution.containsDuplicate(nums2) ? "true" : "false") << endl;
    cout << "预期: true" << endl;

    return 0;
}