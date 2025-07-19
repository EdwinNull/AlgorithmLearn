#include <iostream>
#include <stdlib.h>

using namespace std;

#define MAXSIZE 50

typedef struct{
    int data[MAXSIZE];
    int front,rear;
}SqQueue;

//初始化队列
void InitQueue(SqQueue &Q){
    Q.front = Q.rear = 0;
}

//判空
bool QueueEmpty(SqQueue Q){
    if(Q.front == Q.rear)
        return true;
    return false;
}

//入队
bool EnQueue(SqQueue &Q,int e){
    if((Q.rear+1)%MAXSIZE == Q.front)
        return false;
    Q.data[Q.rear] = e;
    Q.rear = (Q.rear+1)%MAXSIZE;
    return true;
}

//出队
bool DeQueue(SqQueue &Q,int &e){
    if(Q.front == Q.rear)
        return false;
    e = Q.data[Q.front];
    Q.front = (Q.front+1)%MAXSIZE;
    return true;
}

//读队头元素
bool GetHead(SqQueue Q,int &e){
    if(Q.front == Q.rear)
        return false;
    e = Q.data[Q.front];
    return true;
}

