#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

// 链式队列节点结构
typedef struct LinkNode{
    int data;
    struct LinkNode *next;
}LinkNode;

// 链式队列结构（带头尾指针）
typedef struct{
    LinkNode *front, *rear;  // 队头和队尾指针
}LinkQueue;

//初始化队列（带头节点）
void InitQueue(LinkQueue &Q){
    Q.front = Q.rear = (LinkNode*)malloc(sizeof(LinkNode));
    Q.front->next = NULL;
}

//判空
bool isEmpty(LinkQueue Q){
    if(Q.front == Q.rear){
        return true;
    }
    return false;
}

//入队
bool EnQueue(LinkQueue &Q, int e){
    LinkNode *s = (LinkNode*)malloc(sizeof(LinkNode));
    if(s == NULL){
        return false;  // 内存分配失败
    }
    s->data = e;
    s->next = NULL;
    Q.rear->next = s;  // 新节点插入到rear之后
    Q.rear = s;        // 修改rear指针
    return true;
}

//出队
bool DeQueue(LinkQueue &Q, int &e){
    if(Q.front == Q.rear){
        return false;  // 队列为空
    }
    LinkNode *p = Q.front->next;
    e = p->data;
    Q.front->next = p->next;
    if(Q.rear == p){   // 若原队列只有一个节点，删除后变空
        Q.rear = Q.front;
    }
    free(p);
    return true;
}

//获取队头元素
bool GetHead(LinkQueue Q, int &e){
    if(Q.front == Q.rear){
        return false;  // 队列为空
    }
    e = Q.front->next->data;
    return true;
}

//获取队列长度
int GetLength(LinkQueue Q){
    int length = 0;
    LinkNode *p = Q.front->next;
    while(p != NULL){
        length++;
        p = p->next;
    }
    return length;
}

//销毁队列
void DestroyQueue(LinkQueue &Q){
    while(Q.front){
        Q.rear = Q.front->next;
        free(Q.front);
        Q.front = Q.rear;
    }
}

//打印队列
void PrintQueue(LinkQueue Q){
    if(isEmpty(Q)){
        cout << "队列为空" << endl;
        return;
    }
    cout << "队列元素: ";
    LinkNode *p = Q.front->next;
    while(p != NULL){
        cout << p->data << " ";
        p = p->next;
    }
    cout << endl;
}

// 测试函数
int main(){
    LinkQueue Q;
    InitQueue(Q);

    cout << "=== 链式队列测试 ===" << endl;

    // 测试入队
    cout << "入队操作: 1, 2, 3, 4, 5" << endl;
    for(int i = 1; i <= 5; i++){
        EnQueue(Q, i);
    }
    PrintQueue(Q);
    cout << "队列长度: " << GetLength(Q) << endl;

    // 测试获取队头元素
    int head;
    if(GetHead(Q, head)){
        cout << "队头元素: " << head << endl;
    }

    // 测试出队
    cout << "\n出队操作:" << endl;
    int e;
    while(DeQueue(Q, e)){
        cout << "出队元素: " << e << endl;
        PrintQueue(Q);
    }

    cout << "队列长度: " << GetLength(Q) << endl;

    // 测试空队列操作
    cout << "\n测试空队列操作:" << endl;
    if(DeQueue(Q, e)){
        cout << "出队成功: " << e << endl;
    } else {
        cout << "队列为空，出队失败" << endl;
    }

    if(GetHead(Q, head)){
        cout << "队头元素: " << head << endl;
    } else {
        cout << "队列为空，无法获取队头元素" << endl;
    }

    // 销毁队列
    DestroyQueue(Q);
    cout << "\n队列已销毁" << endl;

    return 0;
}