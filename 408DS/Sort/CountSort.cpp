#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 计数排序（稳定），支持负数。时间 O(n + range)，空间 O(range)
void countSort(int arr[], int n){
    if(n <= 1) return;

    // 1) 找到最小值与最大值，确定计数数组范围
    int minVal = arr[0], maxVal = arr[0];
    for(int i = 1; i < n; ++i){
        if(arr[i] < minVal) minVal = arr[i];
        if(arr[i] > maxVal) maxVal = arr[i];
    }

    int range = maxVal - minVal + 1;
    if(range <= 0) return; // 防御（理论上不会发生）

    // 2) 计数出现次数
    vector<int> cnt(range, 0);
    for(int i = 0; i < n; ++i){
        cnt[arr[i] - minVal]++;
    }

    // 3) 前缀和 -> 每个值在结果数组中的“结束位置”
    for(int i = 1; i < range; ++i){
        cnt[i] += cnt[i-1];
    }

    // 4) 逆序遍历，稳定地放入输出数组
    vector<int> out(n);
    for(int i = n - 1; i >= 0; --i){
        int k = arr[i] - minVal;
        out[--cnt[k]] = arr[i];
    }

    // 5) 写回原数组
    for(int i = 0; i < n; ++i){
        arr[i] = out[i];
    }
}
