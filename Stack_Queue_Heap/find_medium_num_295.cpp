#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

//使用大小顶堆，大顶堆与小顶堆的大小相等，则中位数为两个堆顶的平均值
//大小顶堆不等，则中位数为大顶堆的堆顶
class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> A;
    priority_queue<int, vector<int>, less<int>> B; 
    MedianFinder() { }
    void addNum(int num) {
        if (A.size() != B.size()) {
            A.push(num);
            B.push(A.top());
            A.pop();
        } else {
            B.push(num);
            A.push(B.top());
            B.pop();
        }
    }
    double findMedian() {
        return A.size() != B.size() ? A.top() : (A.top() + B.top()) / 2.0;
    }
};