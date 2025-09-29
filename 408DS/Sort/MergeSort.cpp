#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
  归并排序（稳定排序）
  时间复杂度：O(nlogn)（无论最好/最坏/平均）
  空间复杂度：O(n)（需要临时数组）
  思想：分治——把数组分成两半，分别排序，再合并两个有序数组
*/

// 将相邻两段有序数组 arr[left..mid] 与 arr[mid+1..right] 合并为一个有序段
void merge(int arr[], int left, int mid, int right){
    // 左右子数组的长度
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // 拷贝出左右临时数组（避免覆盖）
    vector<int> L(n1), R(n2);
    for(int i = 0; i < n1; i++) L[i] = arr[left + i];
    for(int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

    // i 遍历 L，j 遍历 R，k 写回到原数组
    int i = 0, j = 0, k = left;

    // 归并：从两边各取当前最小的元素放回 arr
    while(i < n1 && j < n2){
        // 使用 <= 以保证稳定性：相等时先放左侧元素
        if(L[i] <= R[j]){
            arr[k++] = L[i++];
        }else{
            arr[k++] = R[j++];
        }
    }

    // 将未耗尽的一侧剩余元素直接拷回
    while(i < n1) arr[k++] = L[i++];
    while(j < n2) arr[k++] = R[j++];
}

// 递归的归并排序：对区间 [left, right] 排序
void mergeSort(int arr[], int left, int right){
    if(left < right){
        // 取中点（写法可避免 left+right 溢出）
        int mid = left + (right - left) / 2;

        // 分别对左右半区排序
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 将两个有序半区合并
        merge(arr, left, mid, right);
    }
}