#include <iostream>
#include <queue>
using namespace std;

class MyStack {
public:
    MyStack() {
    }
    
    void push(int x) {
        queue<int> temp_queue;
        temp_queue.push(x);
        while(!data.empty()){
            temp_queue.push(data.front());
            data.pop();
        }
        while(!temp_queue.empty()){
            data.push(temp_queue.front());
            temp_queue.pop();
        }
    }
    
    int pop() {
        int x = data.front();
        data.pop();
        return x;
    }
    
    int top() {
        return data.front();
    }
    
    bool empty() {
        return data.empty();
    }
    private:
        queue<int> data;
};