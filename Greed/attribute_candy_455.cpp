#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int children = 0;
        int count = 0;
        while(children < g.size() && count < s.size()){
            if(g[children] <= s[count]){
                children++;
            }
            count++;
        }
        return children;
    }
};