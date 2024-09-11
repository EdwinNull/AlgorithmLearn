#include<bits/stdc++.h>
using namespace std;

struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x): val(x), next(NULL) {}
};

class Solution{
public:
    ListNode* reverseList(ListNode* head,int m,int n){
        int change_len = n-m+1;
        ListNode *pre_head = NULL;
        ListNode *result = head;
        while(head!=NULL && --m){
            pre_head = head;
            head = head->next;
        }
        ListNode *modify_list_tail = head;
        ListNode *new_head = NULL;
        while(head && change_len){
            ListNode *next_node = head->next;
            head->next = new_head;
            new_head = head;
            head = next_node;
            change_len--;
        }
        modify_list_tail->next = head;
        if(pre_head)
            pre_head->next = new_head;
        else
            result = new_head;
        return result;
    }
};