#include <stdio.h>
#include <stdlib.h>

using namespace std;

void InsertSort_Straight(int arr[], int n){
    int i,j;
    for(i = 2;i<n;i++){
        if(arr[i]<arr[i-1]){
            arr[0] = arr[i];
            for(j = i-1;arr[0]<arr[j];j--){ //寻找插入位置
                arr[j+1] = arr[j];
            }
            arr[j+1] = arr[0];
        }
    }
}

void InsertSort_Binary(int arr[], int n){
    int i,j,low,high,mid;
    for(i = 2;i<n;i++){
        if(arr[i]<arr[i-1]){
            arr[0] = arr[i];    //哨兵的作用在于释放i位置以便后移
            low = 1,high = i-1;
            while(low<high){
                mid = (low+high)/2;
                if(arr[0]<arr[mid]) high = mid-1;
                else low = mid+1;
            }
            for(j = i-1;j>=high+1;j--){
                arr[j+1] = arr[j];
            }
            arr[high+1] = arr[0];
        }
    }
}

void ShellSort(int arr[], int n){
    int i,j,gap;
    for(gap = n/2;gap>=1;gap/=2){ //步长逐渐减小
        for(i = gap+1;i<=n;i++){ //从第gap+1个元素开始插入排序
            if(arr[i]<arr[i-gap]){
                arr[0] = arr[i];
                for(j = i-gap;arr[0]<arr[j]&&j>0;j-=gap){ //寻找插入位置
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = arr[0];
            }
        }
    }
}