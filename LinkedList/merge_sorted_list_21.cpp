#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode temp_head(0);
        ListNode *pre = &temp_head;
        while(list1 && list2){
            if(list1->val < list2->val){
                pre->next = list1;
                list1 = list1->next;
            }
            else{
                pre->next = list2;
                list2 = list2->next;
            }
            pre = pre->next;
        }
        if(list1){
            pre->next = list1;
        }
        if(list2){
            pre->next = list2;
        }
        return temp_head.next;
    }
};