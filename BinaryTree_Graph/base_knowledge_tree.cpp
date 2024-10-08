#include <iostream>
#include <cstdio>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void preorder(TreeNode* node,int layer){
    if(!node) return;
    for(int i=0;i<layer;i++){
        printf("-----------");
    }
    printf("%d\n",node->val);
    preorder(node->left,layer+1);
    preorder(node->right,layer+1);
}

int main(){
    TreeNode a(1);
    TreeNode b(2);
    TreeNode c(3);
    TreeNode d(4);
    TreeNode e(5);
    TreeNode f(6);
    a.left = &b;
    a.right = &c;
    b.left = &d;
    b.right = &e;
    c.right = &f;
    preorder(&a,0);
    return 0;
}
