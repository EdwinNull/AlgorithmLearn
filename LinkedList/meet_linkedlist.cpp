#include <iostream>
#include <set>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

int get_list_length(ListNode *head){
    int length = 0;
    while(head){
        length++;
        head = head->next;
    }
    return length;
}

ListNode *forward_long_list(int long_len,int short_len,ListNode *head){
    int delta = long_len - short_len;
    while(head && delta){
        head = head->next;
        delta--;
    }
    return head;
}

class Solution{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        //使用集合的方法
        set<int> node_set;
        while(headA){
            node_set.insert(headA);
            headA = headA->next;
        }
        while(headB){
            if(node_set.find(headB)!= node_set.end()){
                return headB;
            }
            headB = headB->next;
        }
        return NULL;
    }
}

class Solution2{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int list_A_length = get_list_length(headA);
        int list_B_length = get_list_length(headB);
        if(list_A_length > list_B_length){
            headA = forward_long_list(list_A_length,list_B_length,headA);
        }
        else{
            headB = forward_long_list(list_B_length,list_A_length,headB);
        }
        while(headA && headB){
            if(headA == headB){
                return headA;
            }
            headA = headA->next;
            headB = headB->next;
        }
        return NULL;
    }
}