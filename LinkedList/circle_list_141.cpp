#include <iostream>
#include <set>
using namespace std;

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
        set<ListNode *> node_set;
        while(head){
            if(node_set.find(head)!= node_set.end()){
                return true;
            }
            node_set.insert(head);
            head = head->next;
        }
        return false;
    }
}

// Double pointer approach
class Solution2{
public:
    bool hasCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast){
            fast = fast->next;
            if(fast){
                fast = fast->next;
            }
            if(fast ==slow){
                return true;
            }
            slow = slow->next;    
        }
        return false;
    }
}