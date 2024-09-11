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
    ListNode* partition(ListNode* head, int x) {
        ListNode less_head(0);
        ListNode more_head(0);
        ListNode *less_ptr = &less_head;
        ListNode *more_ptr = &more_head;
        while (head) {
            if (head->val < x) {
                less_ptr->next = head;
                less_ptr = head;
            }
            else{    
                more_ptr->next = head;
                more_ptr = head;
            }
            head = head->next;
        }
        less_ptr->next = more_head.next;
        more_ptr->next = NULL;
        return less_head.next;
    }
};