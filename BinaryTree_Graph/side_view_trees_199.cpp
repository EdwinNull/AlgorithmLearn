#include <bits/stdc++.h>
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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> views;
        queue<pair<TreeNode*, int>> Q;
        if(root){
            Q.push(make_pair(root, 0));
        }
        while(!Q.empty()){
            TreeNode* node = Q.front().first;
            int depth = Q.front().second;
            Q.pop();
            if(views.size() == depth){
                views.push_back(node->val);// 说明是第一次遍历到这个深度，直接添加到views
            }
            else{
                views[depth] = node->val; // 说明已经遍历过这个深度，更新views[depth]
            }
            if(node->left){
                Q.push(make_pair(node->left,depth+1)); //若有左子树，则深度+1
            }
            if(node->right){
                Q.push(make_pair(node->right,depth+1)); //若有右子树，则深度+1
            }
        }
        return views;
    }
};
