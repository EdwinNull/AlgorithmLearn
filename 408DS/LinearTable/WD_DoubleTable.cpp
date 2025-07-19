#include <stdio.h>
#include <stdlib.h>

// 双链表节点结构定义
typedef struct DNode {
    int data;                // 数据域
    struct DNode *prior;     // 指向前驱节点的指针
    struct DNode *next;      // 指向后继节点的指针
} DNode, *DLinkList;

// 初始化双链表（带头节点）
DLinkList InitDLinkList() {
    DLinkList L = (DLinkList)malloc(sizeof(DNode));
    if (L == NULL) {
        printf("内存分配失败！\n");
        return NULL;
    }
    L->prior = NULL;
    L->next = NULL;
    return L;
}

// 判断双链表是否为空
int IsEmpty(DLinkList L) {
    return (L->next == NULL);
}

// 获取双链表长度
int GetLength(DLinkList L) {
    int length = 0;
    DNode *p = L->next;
    while (p != NULL) {
        length++;
        p = p->next;
    }
    return length;
}

// 按位序查找节点（返回第i个节点的指针）
DNode* GetElem(DLinkList L, int i) {
    if (i < 1) return NULL;
    
    DNode *p = L;
    int j = 0;
    while (p != NULL && j < i) {
        p = p->next;
        j++;
    }
    return p;
}

// 按值查找节点
DNode* LocateElem(DLinkList L, int e) {
    DNode *p = L->next;
    while (p != NULL && p->data != e) {
        p = p->next;
    }
    return p;
}

// 在第i个位置插入元素
int ListInsert(DLinkList L, int i, int e) {
    if (i < 1) return 0;
    
    DNode *p = GetElem(L, i - 1);  // 找到第i-1个节点
    if (p == NULL) return 0;
    
    DNode *s = (DNode*)malloc(sizeof(DNode));
    if (s == NULL) return 0;
    
    s->data = e;
    s->next = p->next;
    if (p->next != NULL) {
        p->next->prior = s;
    }
    s->prior = p;
    p->next = s;
    
    return 1;
}

// 头插法插入元素
int ListInsertHead(DLinkList L, int e) {
    DNode *s = (DNode*)malloc(sizeof(DNode));
    if (s == NULL) return 0;
    
    s->data = e;
    s->next = L->next;
    if (L->next != NULL) {
        L->next->prior = s;
    }
    s->prior = L;
    L->next = s;
    
    return 1;
}

// 尾插法插入元素
int ListInsertTail(DLinkList L, int e) {
    DNode *p = L;
    // 找到最后一个节点
    while (p->next != NULL) {
        p = p->next;
    }
    
    DNode *s = (DNode*)malloc(sizeof(DNode));
    if (s == NULL) return 0;
    
    s->data = e;
    s->next = NULL;
    s->prior = p;
    p->next = s;
    
    return 1;
}

// 删除第i个位置的元素
int ListDelete(DLinkList L, int i, int *e) {
    DNode *p = GetElem(L, i);  // 找到第i个节点
    if (p == NULL) return 0;
    
    *e = p->data;
    
    if (p->next != NULL) {
        p->next->prior = p->prior;
    }
    p->prior->next = p->next;
    
    free(p);
    return 1;
}

// 删除指定值的第一个节点
int DeleteByValue(DLinkList L, int e) {
    DNode *p = LocateElem(L, e);
    if (p == NULL) return 0;
    
    if (p->next != NULL) {
        p->next->prior = p->prior;
    }
    p->prior->next = p->next;
    
    free(p);
    return 1;
}

// 正向遍历打印双链表
void PrintList(DLinkList L) {
    DNode *p = L->next;
    printf("双链表内容（正向）: ");
    while (p != NULL) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

// 反向遍历打印双链表
void PrintListReverse(DLinkList L) {
    // 先找到最后一个节点
    DNode *p = L;
    while (p->next != NULL) {
        p = p->next;
    }
    
    printf("双链表内容（反向）: ");
    while (p != L) {
        printf("%d ", p->data);
        p = p->prior;
    }
    printf("\n");
}

// 销毁双链表
void DestroyList(DLinkList L) {
    DNode *p = L->next;
    while (p != NULL) {
        DNode *temp = p;
        p = p->next;
        free(temp);
    }
    free(L);
}

// 测试函数
int main() {
    DLinkList L = InitDLinkList();
    if (L == NULL) {
        printf("双链表初始化失败！\n");
        return -1;
    }
    
    printf("=== 双链表基本操作测试 ===\n");
    
    // 测试插入操作
    printf("\n1. 测试插入操作:\n");
    ListInsertHead(L, 10);
    ListInsertHead(L, 20);
    ListInsertTail(L, 30);
    ListInsertTail(L, 40);
    ListInsert(L, 3, 25);
    PrintList(L);
    PrintListReverse(L);
    printf("链表长度: %d\n", GetLength(L));
    
    // 测试查找操作
    printf("\n2. 测试查找操作:\n");
    DNode *node = GetElem(L, 3);
    if (node != NULL) {
        printf("第3个节点的值: %d\n", node->data);
    }
    
    node = LocateElem(L, 25);
    if (node != NULL) {
        printf("找到值为25的节点\n");
    } else {
        printf("未找到值为25的节点\n");
    }
    
    // 测试删除操作
    printf("\n3. 测试删除操作:\n");
    int deletedValue;
    if (ListDelete(L, 2, &deletedValue)) {
        printf("删除第2个节点，值为: %d\n", deletedValue);
    }
    PrintList(L);
    
    if (DeleteByValue(L, 30)) {
        printf("删除值为30的节点成功\n");
    }
    PrintList(L);
    printf("链表长度: %d\n", GetLength(L));
    
    // 测试空链表判断
    printf("\n4. 测试空链表判断:\n");
    printf("链表是否为空: %s\n", IsEmpty(L) ? "是" : "否");
    
    // 销毁链表
    DestroyList(L);
    printf("\n双链表已销毁\n");
    
    return 0;
}