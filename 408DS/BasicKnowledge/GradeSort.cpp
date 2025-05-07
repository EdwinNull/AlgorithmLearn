#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int N = 100000;

int n, m;
struct Person
{
    string name;
    int score;
    int id;

    bool operator<(const Person &p) const
    {
        if (score != p.score)
            return score < p.score;
        return id < p.id;
    }

    bool operator>(const Person &p) const
    {
        if (score != p.score)
            return score > p.score;
        return id < p.id;
    }
} q[N];

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> q[i].name >> q[i].score;
        q[i].id = i;
    }
    if (!m)
    {
        stable_sort(q, q + n, greater<Person>());
    }
    else
    {
        stable_sort(q, q + n);
    }

    for (int i = 0; i < n; i++)
    {
        cout << q[i].name << " " << q[i].score << endl;
    }
}