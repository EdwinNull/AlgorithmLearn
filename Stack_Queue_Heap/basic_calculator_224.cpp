#include <iostream>
#include <stack>
#include <string>
using namespace std;

void compute(stack<int> &number_stack, stack<char> &operator_stack){
    if(number_stack.size() < 2 || operator_stack.empty()){
        return;
    }
    int num2 = number_stack.top();
    number_stack.pop();
    int num1 = number_stack.top();
    number_stack.pop();
    char op = operator_stack.top();
    if(op == '+'){
        number_stack.push(num1 + num2);
    }
    else if(op == '-'){
        number_stack.push(num1 - num2);
    }
    operator_stack.pop();
}

class Solution {
public:
    int calculate(string s) {
        static const int STATE_BEGIN = 0;
        static const int NUMBER_STATE = 1;
        static const int OPERATOR_STATE = 2;
        stack<int> number_stack;
        stack<char> operator_stack;
        int number = 0;
        int state = STATE_BEGIN;
        int compute_flag = 0;
        for(int i = 0;i<s.length();i++){
            if(s[i]==' '){
                continue;
            }
            switch(state){
                case STATE_BEGIN:
                    if(s[i] >= '0' && s[i] <= '9'){
                        state = NUMBER_STATE;
                    }
                    else{
                        state = OPERATOR_STATE;
                    }
                    i--;
                    break;
                case NUMBER_STATE:
                    if(s[i] >= '0' && s[i] <= '9'){
                        number = number*10 + (s[i] - '0');
                    }
                    else{
                        number_stack.push(number);
                        if(compute_flag==1) compute(number_stack, operator_stack);
                        number = 0;
                        state = OPERATOR_STATE;
                        i--;
                    }
                    break;
                case OPERATOR_STATE:
                    if(s[i] == '+' || s[i] == '-'){
                        operator_stack.push(s[i]);
                        compute_flag = 1;
                    }
                    else if(s[i] == '('){
                        state = NUMBER_STATE;
                        compute_flag = 0;
                    }
                    else if(s[i] >= '0' && s[i] <= '9'){
                        state = NUMBER_STATE;
                        i--;
                    }
                    else if(s[i] == ')'){
                        compute(number_stack, operator_stack);
                    }
                    break;
            }
        }
        if(number!= 0){
            number_stack.push(number);
            compute(number_stack, operator_stack);
        }
        if(number == 0 && operator_stack.empty()){
            return 0;
        }
            return number_stack.top();
    }
};
