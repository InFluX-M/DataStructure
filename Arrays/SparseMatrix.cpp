#include <bits/stdc++.h>
using namespace std;

int** sparseMatrix(int** arr, int size, int n, int m)
{
    int** compactMatrix = new int*[size+1];
    for(int i=0; i<size+1; i++) compactMatrix[i] = new int[3];

    compactMatrix[0][0] = n;
    compactMatrix[0][1] = m;
    compactMatrix[0][2] = size;

    int r = 1;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++)
        {
            if(arr[i][j]!=0)
            {
                compactMatrix[r][0] = i;
                compactMatrix[r][1] = j;
                compactMatrix[r][2] = arr[i][j];

                r++;
            }
        }
    }

    return compactMatrix;
}

int** transposingSparseMatrix(int **arr, int n)
{
    int** TCM = new int*[n+1];
    for(int i=0; i<n+1; i++) TCM[i] = new int[3];

    for(int i=0; i<n+1; i++)
    {
        TCM[i][0] = arr[i][1];
        TCM[i][1] = arr[i][0];
        TCM[i][2] = arr[i][2];
    }

    for(int i=1; i<n; i++)
    {
        for(int j=1; j<n-i; j++)
        {
            if(TCM[j][0]>TCM[j+1][0])
            {
                int* temp = TCM[j];
                TCM[j] = TCM[j+1];
                TCM[j+1] = temp;
            }
            else if(TCM[j][0]==TCM[j+1][0])
            {
                if(TCM[j][1]>TCM[j+1][1])
                {
                    int* temp = TCM[j];
                    TCM[j] = TCM[j+1];
                    TCM[j+1] = temp;
                }
                else if(TCM[j][1]==TCM[j+1][1])
                {
                    if(TCM[j][2]>TCM[j+1][2])
                    {
                        int* temp = TCM[j];
                        TCM[j] = TCM[j+1];
                        TCM[j+1] = temp;
                    }
                }
            }
        }
    }

    return TCM;
}

int accessCompactMatrix(int** M, int i, int j, int l, int r)
{
    if(l>r) return -1000;

    int mid=(l+r)/2;

    if(M[mid][0]==i)
    {
        if(M[mid][1]==j) return M[mid][2];
        else if(M[mid][1]>j)
        {
            accessCompactMatrix(M, i, j, l, mid-1);
        }
        else if(M[mid][2]<j)
        {
            accessCompactMatrix(M, i, j, mid+1, j);
        }
    }
    else if(M[mid][0]>i)
    {
        accessCompactMatrix(M, i, j, l, mid-1);
    }
    else
    {
        accessCompactMatrix(M, i, j, mid+1, r);
    }
}