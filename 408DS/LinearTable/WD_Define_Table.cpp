#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

#define INIT_SIZE 10  // 初始分配大小
#define INCREMENT 5   // 每次扩容增量

typedef struct{
    int *data;     // 动态分配的数组指针
    int length;    // 当前长度
    int maxsize;   // 当前分配的最大容量
}SqList;

//顺序表基础操作
//1.初始化顺序表
bool InitList(SqList &L){
    L.data = (int*)malloc(INIT_SIZE * sizeof(int));
    if(!L.data) return false;  // 内存分配失败
    L.length = 0;
    L.maxsize = INIT_SIZE;
    return true;
}

//2.按值查找
int LocatElem(SqList L,int e){
    for(int i = 0; i < L.length; i++){
        if(L.data[i] == e) return i+1; 
    }
    return 0;
}

//3.按位查找
int GetElem(SqList L,int i){
    if(i<1 || i>L.length) return -1;
    return L.data[i-1];
}

//4.插入
bool ListInsert(SqList &L,int i,int e){
    if(i<1 || i>L.length+1) return false;
    
    // 检查是否需要扩容
    if(L.length >= L.maxsize){
        int *newdata = (int*)realloc(L.data, (L.maxsize + INCREMENT) * sizeof(int));
        if(!newdata) return false;  // 扩容失败
        L.data = newdata;
        L.maxsize += INCREMENT;
    }
    
    // 元素后移
    for(int j = L.length; j >= i; j--){
        L.data[j] = L.data[j-1];
    }
    L.data[i-1] = e;
    L.length++;
    return true;
}

//5.删除
bool ListDelete(SqList &L,int i,int &e){
    if(i<1||i>L.length) return false;
    e = L.data[i-1];
    for(int j = i;j<L.length;j++){
        L.data[j-1] = L.data[j];
    }
    L.length--;
    return true;
}

//6.输出
void PrintList(SqList L){
    for(int i = 0;i<L.length;i++){
        cout<<L.data[i]<<endl;
    }
}

//7.判空
bool Empty(SqList L){
    if(L.length==0){
        return true;
    }
    return false;
}

//8.销毁
void DestroyList(SqList &L){
    if(L.data){
        free(L.data);     // 释放动态分配的内存
        L.data = NULL;    // 避免悬空指针
    }
    L.length = 0;
    L.maxsize = 0;
}



int main(){
    SqList L;
    if(!InitList(L)){
        cout<<"初始化失败，内存分配错误！"<<endl;
        return -1;
    }
    
    int num = 0;
    cout<<"请输入要插入的元素个数："<<endl;
    cin>>num;
    
    for(int i = 0; i < num; i++){
        int e;
        cout<<"请输入第"<<i+1<<"个元素："<<endl;
        cin>>e;
        if(!ListInsert(L, i+1, e)){
            cout<<"插入第"<<i+1<<"个元素失败！"<<endl;
        }
    }
    
    cout<<"顺序表内容："<<endl;
    PrintList(L);
    
    // 释放内存
    DestroyList(L);
    return 0;
}