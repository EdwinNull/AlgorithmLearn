#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/*
 * 顺序存储二叉树中找最近公共祖先(LCA)的算法
 * 
 * 顺序存储规则：
 * - 根节点存储在下标1的位置
 * - 对于下标为i的节点：
 *   - 左孩子下标：2*i
 *   - 右孩子下标：2*i+1
 *   - 父节点下标：i/2
 */

class SequentialBinaryTree {
private:
    vector<int> tree;  // 顺序存储的二叉树，下标0不使用
    int size;          // 树的大小
    
public:
    // 构造函数
    SequentialBinaryTree(int n) : size(n) {
        tree.resize(n + 1, 0);  // 下标0不使用，所以大小为n+1
    }
    
    // 设置节点值
    void setNode(int index, int value) {
        if (index >= 1 && index <= size) {
            tree[index] = value;
        }
    }
    
    // 获取节点值
    int getNode(int index) {
        if (index >= 1 && index <= size) {
            return tree[index];
        }
        return -1;  // 无效节点
    }
    
    // 检查节点是否存在（值不为0表示存在）
    bool nodeExists(int index) {
        return index >= 1 && index <= size && tree[index] != 0;
    }
    
    // 获取父节点下标
    int getParent(int index) {
        if (index <= 1) return -1;  // 根节点没有父节点
        return index / 2;
    }
    
    // 获取左孩子下标
    int getLeftChild(int index) {
        int left = 2 * index;
        return (left <= size) ? left : -1;
    }
    
    // 获取右孩子下标
    int getRightChild(int index) {
        int right = 2 * index + 1;
        return (right <= size) ? right : -1;
    }
    
    // 方法1：通过路径比较找LCA（推荐）
    int findLCA_PathMethod(int i, int j) {
        if (!nodeExists(i) || !nodeExists(j)) {
            return -1;  // 节点不存在
        }
        
        // 获取从根到节点i的路径
        vector<int> pathI = getPathToRoot(i);
        // 获取从根到节点j的路径
        vector<int> pathJ = getPathToRoot(j);
        
        // 反转路径，使其从根开始
        reverse(pathI.begin(), pathI.end());
        reverse(pathJ.begin(), pathJ.end());
        
        // 找到最后一个公共节点
        int lca = 1;  // 至少根节点是公共祖先
        int minLen = min(pathI.size(), pathJ.size());
        
        for (int k = 0; k < minLen; k++) {
            if (pathI[k] == pathJ[k]) {
                lca = pathI[k];
            } else {
                break;
            }
        }
        
        return lca;
    }
    
    // 方法2：通过向上移动找LCA
    int findLCA_UpwardMethod(int i, int j) {
        if (!nodeExists(i) || !nodeExists(j)) {
            return -1;  // 节点不存在
        }
        
        // 让两个节点都向上移动到同一层
        while (i != j) {
            if (i > j) {
                i = getParent(i);
            } else {
                j = getParent(j);
            }
            
            // 如果其中一个到达了根节点之上，说明有问题
            if (i < 1 || j < 1) {
                return -1;
            }
        }
        
        return i;
    }
    
    // 方法3：位运算优化方法（最高效）
    int findLCA_BitMethod(int i, int j) {
        if (!nodeExists(i) || !nodeExists(j)) {
            return -1;
        }
        
        // 找到i和j的最高公共位
        // 在完全二叉树的顺序存储中，LCA可以通过位运算快速找到
        while (i != j) {
            if (i > j) {
                i >>= 1;  // 相当于 i = i / 2，向上移动到父节点
            } else {
                j >>= 1;  // 相当于 j = j / 2，向上移动到父节点
            }
        }
        
        return i;
    }
    
    // 辅助函数：获取从节点到根的路径
    vector<int> getPathToRoot(int index) {
        vector<int> path;
        while (index >= 1) {
            path.push_back(index);
            index = getParent(index);
        }
        return path;
    }
    
    // 打印树的结构（用于调试）
    void printTree() {
        cout << "二叉树结构（顺序存储）：" << endl;
        for (int i = 1; i <= size; i++) {
            if (tree[i] != 0) {
                cout << "节点" << i << ": " << tree[i];
                if (getParent(i) != -1) {
                    cout << " (父节点: " << getParent(i) << ")";
                }
                cout << endl;
            }
        }
    }
};

// 测试函数
void testLCA() {
    cout << "=== 顺序存储二叉树最近公共祖先算法测试 ===" << endl;
    
    // 创建一个大小为15的二叉树
    SequentialBinaryTree tree(15);
    
    // 构建测试树：
    //       1
    //      / \
    //     2   3
    //    / \ / \
    //   4 5 6  7
    //  /|
    // 8 9
    
    tree.setNode(1, 1);   // 根节点
    tree.setNode(2, 2);   // 左子树
    tree.setNode(3, 3);   // 右子树
    tree.setNode(4, 4);
    tree.setNode(5, 5);
    tree.setNode(6, 6);
    tree.setNode(7, 7);
    tree.setNode(8, 8);
    tree.setNode(9, 9);
    
    tree.printTree();
    cout << endl;
    
    // 测试用例
    vector<pair<int, int>> testCases = {
        {4, 5},   // LCA应该是2
        {8, 9},   // LCA应该是4
        {4, 6},   // LCA应该是1
        {2, 3},   // LCA应该是1
        {8, 7},   // LCA应该是1
        {5, 5}    // 同一个节点，LCA是自己
    };
    
    cout << "测试结果：" << endl;
    for (auto& test : testCases) {
        int i = test.first;
        int j = test.second;
        
        int lca1 = tree.findLCA_PathMethod(i, j);
        int lca2 = tree.findLCA_UpwardMethod(i, j);
        int lca3 = tree.findLCA_BitMethod(i, j);
        
        cout << "节点" << i << "和节点" << j << "的LCA：" << endl;
        cout << "  路径方法: " << lca1 << endl;
        cout << "  向上方法: " << lca2 << endl;
        cout << "  位运算方法: " << lca3 << endl;
        
        // 验证三种方法结果是否一致
        if (lca1 == lca2 && lca2 == lca3) {
            cout << "  ✓ 三种方法结果一致" << endl;
        } else {
            cout << "  ✗ 方法结果不一致！" << endl;
        }
        cout << endl;
    }
}

int main() {
    testLCA();
    
    cout << "\n=== 算法复杂度分析 ===" << endl;
    cout << "1. 路径方法：" << endl;
    cout << "   时间复杂度: O(log n)，空间复杂度: O(log n)" << endl;
    cout << "   优点: 思路清晰，易于理解" << endl;
    cout << "   缺点: 需要额外的存储空间" << endl;
    
    cout << "\n2. 向上移动方法：" << endl;
    cout << "   时间复杂度: O(log n)，空间复杂度: O(1)" << endl;
    cout << "   优点: 空间效率高" << endl;
    cout << "   缺点: 需要同时移动两个指针" << endl;
    
    cout << "\n3. 位运算方法：" << endl;
    cout << "   时间复杂度: O(log n)，空间复杂度: O(1)" << endl;
    cout << "   优点: 最高效，利用了顺序存储的特性" << endl;
    cout << "   缺点: 需要理解位运算原理" << endl;
    
    cout << "\n推荐使用位运算方法，因为它最充分利用了顺序存储的优势！" << endl;
    
    return 0;
}