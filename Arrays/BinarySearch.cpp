#include <bits/stdc++.h>
using namespace std;

int* arr;

bool binarySearch(int aim, int l, int u)
{
    if(l>u) return false;
    int mid = (l+u)/2;

    if(arr[mid]==aim) return true;
    else if(arr[mid]>aim) return binarySearch(aim, l, mid-1);
    else return binarySearch(aim, mid+1, u);
}