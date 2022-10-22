#include <bits/stdc++.h>

using namespace std;

template <class T>
class ArrayStack
{
    int n;
    int capacity;
    T* data;

public:

    ArrayStack(int cap)
    {
        capacity = cap;
        data = new T[capacity];
        n = 0;
    }

    int getSize() {return this.size;}
    bool isEmpty() {return n == 0;}
    bool isFully() {return n == capacity;}
    
    void restore()
    {
        capacity *= 2;
        T* newData = new T[capacity];
        for(int i=0; i<n; i++) newData[i] = data[i];
        delete[] data;
        data = newData;
    }

    bool push(T value)
    {
        if(isFully()) restore();
        data[n++] = value;
        return true;
    }
    
    T top()
    {
        if(isEmpty()) throw("Stack is Empty.");
        return data[n-1];
    }

    T pop()
    {
        if(isEmpty()) throw("Stack is Empty.");
        T value = data[n-1];
        n--;
        return value;
    }
    
};