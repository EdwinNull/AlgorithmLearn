#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void BuildMaxHeap(int arr[], int len){
    for(int i = len/2;i>0;i--){
        MaxHeapify(arr, i, len);
    }
}

void MaxHeapify(int arr[], int i, int len){
    arr[0] = arr[i]; // 用哨兵存储当前节点
    for(int j = 2*i;j<=len;j*=2){ // 沿较大的子节点向下筛选
        if(j<len && arr[j]<arr[j+1]) j++; // 取较大的子节点
        if(arr[0]>=arr[j]) break;          // 当前节点大于等于较大的子节点，筛选结束
        else{
            arr[i] = arr[j]; // 将较大的子节点上移
            i = j;           // 修改当前节点位置
        }
    }
    arr[i] = arr[0]; // 将当前节点放入最终位置
}

void heapSort(int arr[], int n){
    BuildMaxHeap(arr, n); // 建立初始堆
    for(int i = n;i>1;i--){
        swap(arr[1], arr[i]); // 将堆顶元素与最后一个元素交换
        MaxHeapify(arr, 1, i-1); // 对新的堆顶元素进行筛选
    }
}