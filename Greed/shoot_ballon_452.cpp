#include<algorithm>
#include <vector>
using namespace std;

bool cmp(const vector<int> &a,const vector<int> &b){
    return a[1] < b[1];
}

class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size()==0) return 0;
        sort(points.begin(),points.end());
        int shoot_num = 1;
        int pos = points[0][1];
        for(const vector<int>& ballon:points){
            if(ballon[0]>pos){
                pos = ballon[1];
                shoot_num++;
            }
        }
        return shoot_num;
    }
};