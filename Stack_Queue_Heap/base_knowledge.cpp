#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main(){
    //stack's operations
    stack<int> s;
    if(s.empty()) cout<<"Stack is empty"<<endl;
    s.push(1);
    s.push(2);
    s.push(3);
    while(!s.empty()){
        cout<<s.top()<<" ";
        s.pop();
    }
    cout<<endl;

    //queue's operations
    queue<int> q;
    if(q.empty()) cout<<"Queue is empty"<<endl;
    q.push(1);
    q.push(2);
    q.push(3);
    cout<<q.front()<<" "<<q.back()<<endl;
    while(!q.empty()){
        cout<<q.front()<<" ";
        q.pop();
    }
    cout<<endl;
}