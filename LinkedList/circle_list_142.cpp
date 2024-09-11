#include<bits/stdc++.h>
using namespace std;

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

// 两指针从head和meet结点出发，速度相同，相遇的地方即为环的入口
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head;
        ListNode *slow = head;
        ListNode *meet = NULL;
        while(fast){
            slow = slow->next;
            fast = fast->next;
            if(!fast) return NULL;
            fast = fast->next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(!meet){
            return NULL;
        }
        while(head && meet){
            if(head == meet) return head;
            head = head->next;
            meet = meet->next;
        }
        return NULL;
    }
};