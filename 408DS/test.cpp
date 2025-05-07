#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

struct node{
    int val;
    node *next,*prev;

    node(): prev(NULL),next(NULL){}
    node(int _val): val(_val),prev(NULL), next(NULL){}
};

void print(node* head){
    for(auto p = head;p;p = p->next){
        cout<<p->val<<" ";
    }
    cout<<endl;
}

int main(){
    node *head = new node(0),*tail = new node(0);
    head->next = tail;
    tail->prev = head;

    print(head);

    auto a = new node(1);
    a->next = head->next,a->prev = head;
    head->next->prev=a,head->next=a;
    auto b = new node(2);
    b->next = a->next,b->prev = a;
    a->next->prev=b,a->next=b;
    print(head);

    return 0;
}