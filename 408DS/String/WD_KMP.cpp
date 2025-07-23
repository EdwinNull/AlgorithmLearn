#include <iostream>
#include <cstring>
#include <vector>
#include <string>

using namespace std;

// 构建next数组（部分匹配表）
void buildNext(const string& pattern, vector<int>& next) {
    int m = pattern.length();
    next[0] = -1;  // 第一个字符的next值为-1

    int j = -1;  // j表示前缀的末尾位置
    for (int i = 1; i < m; i++) {
        // 当前字符不匹配时，回退到前一个可能的匹配位置
        while (j >= 0 && pattern[i] != pattern[j + 1]) {
            j = next[j];
        }

        // 如果当前字符匹配，则前缀长度加1
        if (pattern[i] == pattern[j + 1]) {
            j++;
        }

        next[i] = j;
    }
}

// KMP字符串匹配算法
int KMP(const string& text, const string& pattern) {
    int n = text.length();
    int m = pattern.length();

    if (m == 0) return 0;  // 空模式串匹配任何位置
    if (n < m) return -1;  // 文本串比模式串短，无法匹配

    // 构建next数组
    vector<int> next(m);
    buildNext(pattern, next);

    int j = -1;  // j表示模式串中已匹配的字符数-1
    for (int i = 0; i < n; i++) {
        // 当前字符不匹配时，利用next数组跳过一些比较
        while (j >= 0 && text[i] != pattern[j + 1]) {
            j = next[j];
        }

        // 如果当前字符匹配，则已匹配字符数加1
        if (text[i] == pattern[j + 1]) {
            j++;
        }

        // 如果完全匹配，返回匹配位置
        if (j == m - 1) {
            return i - m + 1;  // 返回匹配的起始位置
        }
    }

    return -1;  // 未找到匹配
}

// 查找所有匹配位置的KMP算法
vector<int> KMP_FindAll(const string& text, const string& pattern) {
    vector<int> result;
    int n = text.length();
    int m = pattern.length();

    if (m == 0 || n < m) return result;

    // 构建next数组
    vector<int> next(m);
    buildNext(pattern, next);

    int j = -1;
    for (int i = 0; i < n; i++) {
        while (j >= 0 && text[i] != pattern[j + 1]) {
            j = next[j];
        }

        if (text[i] == pattern[j + 1]) {
            j++;
        }

        if (j == m - 1) {
            result.push_back(i - m + 1);  // 记录匹配位置
            j = next[j];  // 继续寻找下一个匹配
        }
    }

    return result;
}

// 打印next数组（用于调试和理解）
void printNext(const string& pattern, const vector<int>& next) {
    cout << "Pattern: " << pattern << endl;
    cout << "Index:   ";
    for (int i = 0; i < pattern.length(); i++) {
        cout << i << " ";
    }
    cout << endl;
    cout << "Next:    ";
    for (int i = 0; i < next.size(); i++) {
        cout << next[i] << " ";
    }
    cout << endl << endl;
}

int main() {
    // 测试用例1：基本匹配
    string text1 = "ABABCABABA";
    string pattern1 = "ABABA";

    cout << "=== KMP算法演示 ===" << endl;
    cout << "文本串: " << text1 << endl;
    cout << "模式串: " << pattern1 << endl;

    // 构建并显示next数组
    vector<int> next1(pattern1.length());
    buildNext(pattern1, next1);
    printNext(pattern1, next1);

    // 查找第一个匹配
    int pos = KMP(text1, pattern1);
    if (pos != -1) {
        cout << "找到匹配，位置: " << pos << endl;
    } else {
        cout << "未找到匹配" << endl;
    }

    // 查找所有匹配
    vector<int> allPos = KMP_FindAll(text1, pattern1);
    cout << "所有匹配位置: ";
    for (int p : allPos) {
        cout << p << " ";
    }
    cout << endl << endl;

    // 测试用例2：更复杂的模式
    string text2 = "AABAACAADAABAABA";
    string pattern2 = "AABA";

    cout << "文本串: " << text2 << endl;
    cout << "模式串: " << pattern2 << endl;

    vector<int> next2(pattern2.length());
    buildNext(pattern2, next2);
    printNext(pattern2, next2);

    vector<int> allPos2 = KMP_FindAll(text2, pattern2);
    cout << "所有匹配位置: ";
    for (int p : allPos2) {
        cout << p << " ";
    }
    cout << endl << endl;

    // 测试用例3：无匹配情况
    string text3 = "ABCDEFG";
    string pattern3 = "XYZ";

    cout << "文本串: " << text3 << endl;
    cout << "模式串: " << pattern3 << endl;

    int pos3 = KMP(text3, pattern3);
    if (pos3 != -1) {
        cout << "找到匹配，位置: " << pos3 << endl;
    } else {
        cout << "未找到匹配" << endl;
    }

    return 0;
}
