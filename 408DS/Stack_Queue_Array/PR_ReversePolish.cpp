#include <iostream>
#include <stack>
#include <cstring>
#include <string>

using namespace std;

// 判断字符是否为运算符
bool isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
}

// 获取运算符优先级
int getPriority(char op) {
    switch(op) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '(':
            return 0;  // 左括号优先级最低
        default:
            return -1;
    }
}

// 中缀表达式转逆波兰表达式（后缀表达式）
string Generate(char str[]) {
    int length = strlen(str);
    stack<char> S;  // 运算符栈
    string result = "";  // 结果字符串

    for (int i = 0; i < length; i++) {
        char c = str[i];

        // 跳过空格
        if (c == ' ') {
            continue;
        }

        // 如果是数字或字母（操作数），直接加入结果
        if (!isOperator(c)) {
            result += c;
            result += " ";  // 添加空格分隔
        }
        // 如果是左括号，入栈
        else if (c == '(') {
            S.push(c);
        }
        // 如果是右括号，弹出栈中元素直到遇到左括号
        else if (c == ')') {
            while (!S.empty() && S.top() != '(') {
                result += S.top();
                result += " ";
                S.pop();
            }
            if (!S.empty()) {
                S.pop();  // 弹出左括号
            }
        }
        // 如果是运算符
        else {
            // 弹出栈中优先级大于等于当前运算符的所有运算符
            while (!S.empty() && getPriority(S.top()) >= getPriority(c)) {
                result += S.top();
                result += " ";
                S.pop();
            }
            S.push(c);  // 当前运算符入栈
        }
    }

    // 弹出栈中剩余的所有运算符
    while (!S.empty()) {
        result += S.top();
        result += " ";
        S.pop();
    }

    return result;
}

int main() {
    char infix[100];
    cout << "请输入中缀表达式: ";
    cin.getline(infix, 100);

    string postfix = Generate(infix);
    cout << "逆波兰表达式: " << postfix << endl;

    return 0;
}