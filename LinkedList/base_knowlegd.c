#include <stdio.h>

struct ListNode{
    int val;
    struct ListNode *next; // 修正为 struct ListNode *
};

int main()
{
    struct ListNode a;
    struct ListNode b;
    struct ListNode c;
    struct ListNode d;
    struct ListNode e;

    a.val = 1;
    b.val = 2;
    c.val = 3;
    d.val = 4;
    e.val = 5;

    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = &e;
    e.next = NULL;

    struct ListNode *head = &a;
    while(head){
        printf("%d ", head->val);
        head = head->next;
    }
    return 0;
}
