#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <stack>

using namespace std;

#define MAXSIZE 50
typedef struct{
    int data[MAXSIZE];
    int top;
}SqStack;

//初始化
void InitStack(SqStack &S){
    S.top = -1;
}

//判空
bool StackEmpty(SqStack S){
    if(S.top == -1){
        return true;
    }
    return false;
}

//入栈
bool Push(SqStack &S,int e){
    if(S.top == MAXSIZE-1)
        return false;
    S.data[++S.top] = e;
    return true;
}

//出栈
bool Pop(SqStack &S,int &e){
    if(S.top == -1)
        return false;
    e = S.data[S.top--]; // 出栈并返回栈顶元素的值，栈顶指针减1，返回true，否则返回false。
    return true;
}

//读栈顶
bool GetTop(SqStack S,int &e){
    if(S.top == -1)
        return false;
    e = S.data[S.top];
    return true;
}