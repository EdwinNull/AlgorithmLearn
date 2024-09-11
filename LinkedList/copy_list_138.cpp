#include <iostream>
#include <map>
#include <vector>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

//双map解决
class Solution {
public:
    Node* copyRandomList(Node* head) {
        map<Node *,int> node_map;
        vector<Node *> node_vec;
        Node *ptr = head;
        int i = 0;
        while(ptr){
            node_vec.push_back(new Node(ptr->val));
            node_map[ptr] = i;
            ptr = ptr->next;
            i++;
        }
        node_vec.push_back(0);
        ptr = head;
        i = 0;
        while(ptr){
            node_vec[i]->next = node_vec[i+1];
            if(ptr->random){
                int index = node_map[ptr->random];
                node_vec[i]->random = node_vec[index];
            }
            ptr = ptr->next;
            i++;
        }
        return node_vec[0];
    }
};