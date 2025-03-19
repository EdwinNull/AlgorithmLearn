#include <bits/stdc++.h>
using namespace std;
int n;
int main()
{
    double x;
    cin >> x;
    double l = -10000,r = 10000;
    while(r-l>1e-8){
        double mid = (l+r)/2;
        if(mid*mid*mid-x>=0) r = mid;
        else l = mid;
    }
    printf("%lf\n",l);
    return 0;
}