#include <iostream>
#include <cstdio>
using namespace std;

int main(){
    const int max =5;
    int graph[max][max] = {0};
    graph[0][2] = 1;
    graph[0][4] = 1;
    graph[1][3] = 1;
    graph[2][1] = 1;
    graph[2][3] = 1;
    graph[3][0] = 1;
    graph[3][1] = 1;
    graph[3][4] = 1;
    graph[4][0] = 1;
    graph[4][3] = 1;

    for(int i=0;i<max;i++){
        for(int j=0;j<max;j++){
            cout<<graph[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}