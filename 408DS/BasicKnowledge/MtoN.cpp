#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
int r = 0;
vector<int> divide(vector<int> &in, int n, int m)
{
    vector<int> res;
    for (int i = in.size() - 1; i >= 0; i--)
    {
        in[i] = r * m + in[i];
        res.push_back(in[i] / n);
        r = in[i] % n;
    }
    reverse(res.begin(), res.end());
    while (res.size() && res.back() == 0)
        res.pop_back();
    return res;
}
int main()
{
    int m, n;
    string x, res;
    vector<int> save;
    cin >> m >> n >> x;
    for (int i = x.size() - 1; i >= 0; i--)
    {
        if (x[i] <= '9')
            save.push_back(x[i] - '0');
        else
            save.push_back(x[i] - 'A' + 10);
    }

    while (save.size())
    {
        save = divide(save, n, m);
        if (r <= 9)
            res += r + '0';
        else
            res += r - 10 + 'a';
        r = 0;
    }
    for (int i = res.size() - 1; i >= 0; i--)
        cout << res[i];
    cout << endl;
    return 0;
}