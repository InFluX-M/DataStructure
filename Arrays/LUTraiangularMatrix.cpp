#include <bits/stdc++.h>
using namespace std;

int accessLowerTraiangularMatrix(int i, int j)
{
    return (i<j) ? -1 : (i*i+i)/2 + j;
}

int* lowerTraiangularMatrix(int **arr, int n)
{
    int size = (n*n+n)/2;
    int* LT = new int[size];

    for(int i=0; i<n; i++)
        for(int j=0; j<=i; j++) 
            LT[accessLowerTraiangularMatrix(i, j)] = arr[i][j];

    return LT;
}

int accessUpperTraiangularMatrix(int n, int i, int j)
{
    return (i>j) ? -1 : n*i-(i*i+i)/2+j;
}

int* upperTraiangularMatrix(int **arr, int n)
{
    int size = (n*n+n)/2;
    int* UT = new int[size];

    for(int i=0; i<n; i++)
        for(int j=i; j<=n; j++)
            UT[accessUpperTraiangularMatrix(n, i, j)] = arr[i][j];
        
    return UT;
}