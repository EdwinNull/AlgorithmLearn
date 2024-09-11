#include <iostream>
#include <set>
#include <cstdio>
using namespace std;

//利用集合特性求数组交点值
int main(){
    set<int> test_set;
    const int A_len = 7;
    const int B_len = 5;
    int A[A_len] = {1, 2, 3, 4, 5, 6, 7};
    int B[B_len] = {2, 4, 6, 8, 10};
    for(int i = 0;i<A_len;i++){
        test_set.insert(A[i]);
    }
    for(int i = 0;i<B_len;i++){
        if(test_set.find(B[i])!= test_set.end()){
            printf("b[%d] = %d in array A\n",i,B[i]);
        }
    }
    return 0;
}