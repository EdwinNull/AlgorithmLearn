#include <iostream>
#include <queue>
#include <cstdlib>
using namespace std;

typedef struct BitNode{
    int data;
    struct BitNode *lchild,*rchild;
}BitNode,*BitTree;

//二叉树的先序遍历
void PreOrder(BitTree T){
    if(T != NULL){
        cout << T->data << " ";
        PreOrder(T->lchild);
        PreOrder(T->rchild);
    }
}

//二叉树的中序遍历
void InOrder(BitTree T){
    if(T != NULL){
        InOrder(T->lchild);
        cout << T->data << " ";
        InOrder(T->rchild);
    }
}

//二叉树的后序遍历
void PostOrder(BitTree T){
    if(T != NULL){
        PostOrder(T->lchild);
        PostOrder(T->rchild);
        cout << T->data << " ";
    }
}

//二叉树的层次遍历
void LevelOrder(BitTree T){
    if(T == NULL) return;
    queue<BitTree> q;
    q.push(T);
    while(!q.empty()){
        BitTree node = q.front();
        q.pop();
        cout << node->data << " ";
        if(node->lchild) q.push(node->lchild);
        if(node->rchild) q.push(node->rchild);
    }
}

//创建二叉树节点
BitTree CreateNode(int data){
    BitTree node = (BitTree)malloc(sizeof(BitNode));
    node->data = data;
    node->lchild = NULL;
    node->rchild = NULL;
    return node;
}

//二叉搜索树插入节点
void InsertNode(BitTree &T, int data){
    if(T == NULL){
        T = CreateNode(data);
    }
    else if(data < T->data){
        InsertNode(T->lchild, data);
    }
    else if(data > T->data){
        InsertNode(T->rchild, data);
    }
}

//查找节点
BitTree SearchNode(BitTree T, int data){
    if(T == NULL || T->data == data){
        return T;
    }
    if(data < T->data){
        return SearchNode(T->lchild, data);
    }
    else{
        return SearchNode(T->rchild, data);
    }
}

//找到最小值节点
BitTree FindMin(BitTree T){
    while(T && T->lchild){
        T = T->lchild;
    }
    return T;
}

//删除节点
BitTree DeleteNode(BitTree T, int data){
    if(T == NULL) return T;
    
    if(data < T->data){
        T->lchild = DeleteNode(T->lchild, data);
    }
    else if(data > T->data){
        T->rchild = DeleteNode(T->rchild, data);
    }
    else{
        if(T->lchild == NULL){
            BitTree temp = T->rchild;
            free(T);
            return temp;
        }
        else if(T->rchild == NULL){
            BitTree temp = T->lchild;
            free(T);
            return temp;
        }
        
        BitTree temp = FindMin(T->rchild);
        T->data = temp->data;
        T->rchild = DeleteNode(T->rchild, temp->data);
    }
    return T;
}

//计算二叉树高度
int GetHeight(BitTree T){
    if(T == NULL) return 0;
    int leftHeight = GetHeight(T->lchild);
    int rightHeight = GetHeight(T->rchild);
    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

//计算二叉树节点数
int GetNodeCount(BitTree T){
    if(T == NULL) return 0;
    return 1 + GetNodeCount(T->lchild) + GetNodeCount(T->rchild);
}

//销毁二叉树
void DestroyTree(BitTree &T){
    if(T != NULL){
        DestroyTree(T->lchild);
        DestroyTree(T->rchild);
        free(T);
        T = NULL;
    }
}

int main(){
    BitTree root = NULL;
    
    cout << "=== 二叉搜索树基本操作演示 ===" << endl;
    
    // 插入节点
    cout << "\n1. 插入节点: 50, 30, 70, 20, 40, 60, 80" << endl;
    InsertNode(root, 50);
    InsertNode(root, 30);
    InsertNode(root, 70);
    InsertNode(root, 20);
    InsertNode(root, 40);
    InsertNode(root, 60);
    InsertNode(root, 80);
    
    // 遍历操作
    cout << "\n2. 遍历操作:" << endl;
    cout << "先序遍历: ";
    PreOrder(root);
    cout << endl;
    
    cout << "中序遍历: ";
    InOrder(root);
    cout << endl;
    
    cout << "后序遍历: ";
    PostOrder(root);
    cout << endl;
    
    cout << "层次遍历: ";
    LevelOrder(root);
    cout << endl;
    
    // 树的属性
    cout << "\n3. 树的属性:" << endl;
    cout << "树的高度: " << GetHeight(root) << endl;
    cout << "节点总数: " << GetNodeCount(root) << endl;
    
    // 查找操作
    cout << "\n4. 查找操作:" << endl;
    BitTree found = SearchNode(root, 40);
    if(found){
        cout << "找到节点 40" << endl;
    }
    else{
        cout << "未找到节点 40" << endl;
    }
    
    found = SearchNode(root, 25);
    if(found){
        cout << "找到节点 25" << endl;
    }
    else{
        cout << "未找到节点 25" << endl;
    }
    
    // 删除操作
    cout << "\n5. 删除操作:" << endl;
    cout << "删除节点 20 后的中序遍历: ";
    root = DeleteNode(root, 20);
    InOrder(root);
    cout << endl;
    
    cout << "删除节点 30 后的中序遍历: ";
    root = DeleteNode(root, 30);
    InOrder(root);
    cout << endl;
    
    cout << "删除节点 50 后的中序遍历: ";
    root = DeleteNode(root, 50);
    InOrder(root);
    cout << endl;
    
    // 销毁树
    DestroyTree(root);
    cout << "\n二叉树已销毁" << endl;
    
    return 0;
}