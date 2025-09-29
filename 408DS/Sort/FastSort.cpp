#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void fastSort(int arr[], int low, int high){
    if(low<high){
        int pivotpos = partition(arr, low, high);
        fastSort(arr, low, pivotpos-1);
        fastSort(arr, pivotpos+1, high);
    }
}

int partition(int arr[], int low, int high){
    int pivot = arr[low];
    int i = low, j = high;
    while(i < j){
        while(i < j && arr[j] >= pivot) j--;
        while(i < j && arr[i] <= pivot) i++;
        if(i < j) swap(arr[i], arr[j]);
    }
    swap(arr[low], arr[i]); // 枢轴归位
    return i;               // 返回枢轴最终位置
}