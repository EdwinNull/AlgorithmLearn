#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<int> path;
        int path_value = 0;
        preorder(root,path_value,targetSum,path,result);
        return result;
    }
private:
    void preorder(TreeNode *Node, int &path_value,int sum,vector<int> &path,
                vector<vector<int>> &result){
                    if(!Node){
                        return;
                    }
                    path_value += Node->val;
                    path.push_back(Node->val);
                    if(!Node->left && !Node->right && path_value==sum){
                        result.push_back(path);
                    }
                    preorder(Node->left,path_value,sum,path,result);
                    preorder(Node->right,path_value,sum,path,result);
                    path_value -= Node->val;
                    path.pop_back();  
                }
};