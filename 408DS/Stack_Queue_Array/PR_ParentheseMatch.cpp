#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <stack>
#include <cstring>

using namespace std;

bool MatchBracket(char str[],int length){
    stack<char> S;
    for(int i = 0;i<length;i++){
        if(str[i] == '(' || str[i] == '{' || str[i] == '['){
            S.push(str[i]);
        }
        else{
            if(S.empty()) return false;
            char top = S.top();
            S.pop();
            if(str[i]==')'&&top!='('){
                return false;    
            }
            if(str[i]=='}'&&top!='{'){
            return false;    
            }
            if(str[i]==']'&&top!='['){
                return false;    
            }
        }
    }
    return S.empty();
}

int main(){
    char str[] = "([])";
    int length = strlen(str);
    if(MatchBracket(str,length)){
        cout<<"Match"<<endl;
    }
    else{
        cout<<"Not Match"<<endl;
    }
    return 0;
}