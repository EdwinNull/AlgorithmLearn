#include <iostream>
#include <stack>
#include <queue>
using namespace std;

bool check_is_valid(queue<int> &order) {
    stack<int> S;
    int n = order.size();
    for(int i = 1; i <= n; i++) {
        S.push(i);
    while(!S.empty() && S.top() == order.front()){
        S.pop();
        order.pop();
        }
    }
    if(!S.empty()){
        return false;
    }
    return true;
}

int main(){
    int n,train;
    cin >> n;
    while(n){
        cin >> train;
        while(train){
            queue<int> order;
            order.push(train);
            for(int i = 1; i < train; i++){
                cin >> train;
                order.push(train);
            }
            if(check_is_valid(order)) cout << "Yes\n" << endl;
            else cout << "No\n" << endl;
            cin >> train;
        }
        cout << "\n";
        cin >> n;
    }
    return 0;
}