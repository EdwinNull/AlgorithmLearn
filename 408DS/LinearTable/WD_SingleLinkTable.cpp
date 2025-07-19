#include <iostream>
#include <stdlib.h>

using namespace std;

#define MAXSIZE 100
#define INCREMENT 10

typedef struct LNode{
    int data;
    struct LNode *next;
}LNode, *LinkList;

//初始化单链表
bool InitList(LinkList &L){
    L = (LNode *)malloc(sizeof(LNode)); //为头结点分配空间
    L->next = NULL;
    //若不带头指针，则直接使用”L=NULL“即可
    return true;
}

//求表长
int Length(LinkList L){
    int len = 0;
    LNode *p = L;
    while(p->next != NULL){
        p = p->next;
        len++;
    }
    return len;
}

//按序查找节点
LNode *GetElem(LinkList L,int i){
    LNode* p = L;
    int j = 0;
    while(p!=NULL && j<i){
        p = p->next;
        j++;
    }
    return p;
}

//按值查找
LNode *LocateElem(LinkList L,int v){
    LNode *p = L->next;
    while(p!=NULL && p->data!=v){
        p = p->next;
    }
    return p;
}

//按序插入操作
bool Insert(LinkList &L,int i,int v){
    LNode *p = L;
    int j = 0;
    while(p!=NULL && j<i-1){
        p = p->next;
        j++;
    }
    //在有了GetElem的基础上，就可以直接使用
    //“LNode *p = GetElem(L,i-1)”了
    if(p==NULL) return false;
    LNode *s = (LNode *)malloc(sizeof(LNode));
    s->data = v;
    s->next = p->next;//这句与下一句是不可颠倒的
    p->next = s;
    return true;
}

//指定节点的插入（后插）
bool InsertAt(LNode* p,int v){
    if(p==NULL) return false;
    LNode * s = (LNode *)malloc(sizeof(LNode));
    if(s==NULL) return false; //分配失败
    s->data = v;
    s->next = p->next;
    p->next = s;
    return true;
}
//若想实现前插，可以在后插后交换两个节点的data值，实现逻辑上的前插

//删除操作
bool Delete(LinkList &L, int i, int &v){
    LNode *p = L;
    int j = 0;
    while(p->next != NULL && j<i-1){
        p = p->next;
        j++;
    }
    if(p->next == NULL || j>i-1){
        return false;
    }
    LNode *q = p->next;
    v = q->data;
    p->next = q->next;
    free(q);
    return true;
}

//给出结点删除
bool DeleteAt(LinkList &L, LNode* p) {
    if (p == NULL) return false;
    // 如果不是最后一个节点，使用"偷天换日"方法
    if (p->next != NULL) {
        LNode *q = p->next;
        p->data = q->data;
        p->next = q->next;
        free(q);
        return true;
    }
    // 如果是最后一个节点，需要找到前驱节点
    if (L == NULL || L->next == NULL) return false;
    LNode* prev = L;
    while (prev->next != NULL && prev->next != p) {
        prev = prev->next;
    }
    if (prev->next == p) {
        prev->next = NULL;
        free(p);
        return true;
    }
    return false;
}

//头插法建立链表
LinkList List_HeadInsert(LinkList &L){
    LNode *s;
    int x;
    L = (LNode *)malloc(sizeof(LNode));
    L->next = NULL;
    scanf("%d",&x);
    while(x!=9999){
        s = (LNode *)malloc(sizeof(LNode));
        s->data = x;
        s->next = L->next;
        L->next = s;
        scanf("%d",&x);
    }
    return L;
}

//尾插法
LinkList List_TailInsert(LinkList &L){
    int x;
    L = (LNode *)malloc(sizeof(LNode));
    LNode *s,*r = L;
    scanf("%d",&x);
    while(x!=9999){
        s = (LNode *)malloc(sizeof(LNode));
        s->data = x;
        r->next = s;
        r = s;
        scanf("%d",&x);
    }
    r->next = NULL;
    return L;
}