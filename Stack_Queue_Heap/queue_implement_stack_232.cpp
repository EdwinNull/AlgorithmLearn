#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
public:
private:
    stack<int> data;
    MyQueue() {
    }
    
    void push(int x) {
        stack<int> temp;
        while(!data.empty()){
            temp.push(data.top());
            data.pop();
        }
        temp.push(x);
        while(!temp.empty()){
            data.push(temp.top());
            temp.pop();
        }
    }
    
    int pop() {
        int x = data.top();
        data.pop();
        return x;
    }
    
    int peek() {
        return data.top();
    }
    
    bool empty() {
        return data.empty();
    }
};