#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string removeKdigits(string num, int k) {
        if(k == num.size()) return "0";
        vector<char> S;
        string res = "";
        for(int i = 0; i < num.size(); i++){
            int number = num[i] - '0';
            while(S.size()!=0 && S[S.size()-1] > number && k>0){
                S.pop_back();
                k--;
            }
            if(number != 0 || S.size() != 0){
                S.push_back(number);
            }
        }
        while(S.size() != 0 && k>0){
            S.pop_back();
            k--;
        }
        //确保0正确输入
        for(int i = 0; i < S.size(); i++){
            res.append(1, S[i]+'0');
        }
        if(res.size() == 0) return "0";
        return res;
    }
};