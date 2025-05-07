#include <vector>
#include <iostream>
#include <algorithm>

    using namespace std;

vector<int> div(vector<int> &A, int b, int &r)
{
    vector<int> C;
    r = 0;
    for (int i = A.size() - 1; i >= 0; i--)
    {
        r = r * 10 + A[i];
        C.push_back(r / b);
        r %= b;
    }
    reverse(C.begin(), C.end());
    while (C.size() > 1 && C.back() == 0)
        C.pop_back();
    return C;
}

int main()
{
    string s;

    while (cin >> s)
    {
        vector<int> A;
        for (int i = s.size() - 1; i >= 0; i--)
            A.push_back(s[i] - '0');
        int r = 0;
        vector<int> res;
        vector<int> C = div(A, 2, r);
        while (1)
        {
            res.push_back(r);
            if (C.size() == 1 && C[0] == 0)
                break;
            C = div(C, 2, r);
        }
        for (int i = res.size() - 1; i >= 0; i--)
            cout << res[i];
        puts("");
    }

    return 0;
}