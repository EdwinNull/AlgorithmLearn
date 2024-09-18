#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
private:
vector<vector<string>> result;
vector<string> path;
bool used[9] = {false};
unordered_map<int,int> mp;
public:
    bool Chaxun(int ceng,int zuobiao){
        for(const auto &a : mp){
            if(zuobiao == a.second+ceng-a.first||zuobiao == a.second-ceng+a.first)
            return true;
        }
        return false;
    }

    void Huisu(int n,int j){
        if(path.size()==n){
            result.push_back(path);
            return;
        }
        for(int i = 0;i < n;i++){
            if(used[i] == true || Chaxun(j,i))continue;
            used[i] = true;
            mp.insert({j,i});
            string yuansu(n,'.');
            yuansu[i] = 'Q';
            path.push_back(yuansu);
            Huisu(n,j+1);
            path.pop_back();
            used[i] = false;
            mp.erase(j);
        }
        return;
    }

    vector<vector<string>> solveNQueens(int n) {
        Huisu(n,1);
        return result;
    }
};
int main(){
    Solution s;
    vector<vector<string>> result = s.solveNQueens(5);
    for(int i = 0;i<result.size();i++){
        for(int j = 0;j<result[i].size();j++){
            cout<<result[i][j]<<endl;
        }
        cout<<endl;
    }
    return 0;
}