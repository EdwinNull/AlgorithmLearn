#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x):data(x),next(NULL){}
};

class Solution {
public:
    Node* reversedList(Node* head){
        Node *newHead = NULL;
        while(head){
            Node *temp = head->next; //备份当前节点的下一个节点
            head->next = newHead; //将当前节点指向新链表的头部
            newHead = head; //将当前节点作为新链表的头部
            head = temp; //移动到下一个节点
        }
        return newHead;
    }
};

int main(){
    Node a(1);
    Node b(2);
    Node c(3);
    Node d(4);
    Node e(5);
    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = &e;
    Solution sol;
    Node *head = &a;
    while(head){
        cout<<head->data<<" ";
        head = head->next;
    }
    head = sol.reversedList(&a);
    while(head){
        cout<<head->data<<" ";
        head = head->next;
    }
    return 0;
}