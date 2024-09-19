#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

//关键在于求路径的公共点，即LCA，可以用DFS或者BFS来求解，这里用DFS来求解。
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1,path2,path;
        int finish = 0;
        preorder(root,p,path,path1,finish);
        path.clear();
        finish = 0;
        preorder(root,q,path,path2,finish);
        int path_len = 0;
        if(path1.size()<path2.size()){
          path_len = path1.size();
        }
        else{
          path_len = path2.size();
        }
        TreeNode *result = 0;
        for(int i=0;i<path_len;i++){
          if(path1[i]==path2[i]){
            result = path1[i];
          }
        }
        return result;
    }
private:
    void preorder(TreeNode *node,TreeNode *search,vector<TreeNode*> &path,
                  vector<TreeNode*> &result,int &finish){
        if(node == NULL || finish == 1) return;
        path.push_back(node);
        if(node == search){
          finish = 1;
          result = path;
          return;
        }
        preorder(node->left,search,path,result,finish);
        preorder(node->right,search,path,result,finish);
        path.pop_back();
    }
};