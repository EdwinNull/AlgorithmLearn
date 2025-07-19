#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

typedef struct LinkNode{
    int data;
    struct LinkNode *next;
}LinkNode, *LiStack;

//初始化
void InitStack(LiStack &S){
    S = NULL;
}

//判空
bool StackEmpty(LiStack S){
    if(S == NULL){
        return true;
    }
    return false;
}

//入栈
bool Push(LiStack &S,int e){
    LinkNode *p = (LinkNode *)malloc(sizeof(LinkNode));
    if(p == NULL){
        return false;
    }
    p->data = e;
    p->next = S;
    S = p;
    return true;
}

//出栈
bool Pop(LiStack &S,int &e){
    if(S == NULL){
        return false;
    }
    LinkNode *p = S;
    e = p->data;
    S = p->next;
    free(p);
    return true;
}

//读栈顶
bool GetTop(LiStack S,int &e){
    if(S == NULL){
        return false;
    }
    e = S->data;
    return true;
}