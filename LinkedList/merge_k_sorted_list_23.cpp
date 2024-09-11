#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

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

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.empty()) return NULL;
        if(lists.size() == 1) return lists[0];
        if(lists.size() == 2) return mergeTwoLists(lists[0], lists[1]);
        int mid = lists.size() / 2;
        vector<ListNode*> sub1_lists;
        vector<ListNode*> sub2_lists;
        for(int i = 0; i < mid; i++) sub1_lists.push_back(lists[i]);
        for(int i = mid; i < lists.size(); i++) sub2_lists.push_back(lists[i]);
        ListNode* l1 = mergeKLists(sub1_lists);
        ListNode* l2 = mergeKLists(sub2_lists);
        return mergeTwoLists(l1, l2);
    }
};