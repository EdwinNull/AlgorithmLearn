#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int N = 100000;

int n,m;
struct Person{
    int id;
    int score;

    bool operator< (const Person& p) const{
       if(score != p.score) return score < p.score;
       return id < p.id;
    }
}q[N];

int main(){
    cin >> n;
    for(int i =0;i<n;i++){
        cin >> q[i].id >> q[i].score;
    }
    sort(q,q+n);
    for(int i =0;i<n;i++){
        cout << q[i].id << " " << q[i].score << endl;
    }
    return 0;
}