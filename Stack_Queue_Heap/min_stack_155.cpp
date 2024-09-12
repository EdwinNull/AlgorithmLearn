#include <iostream>
#include <stack>
using namespace std;

class MinStack {
private:
    stack<int> s;
    stack<int> min_s;
public:
    MinStack() {
    }
    
    void push(int val) {
        s.push(val);
        if(min_s.empty() || val <= min_s.top()){
            min_s.push(val);
        }
        else{
            if(val>min_s.top()) val= min_s.top(); 
            min_s.push(val);
        }
    }
    
    void pop() {
        s.pop();
        min_s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min_s.top();
    }
};