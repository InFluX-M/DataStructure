#include <bits/stdc++.h>
using namespace std;

template <class T>
class DoubleStack
{
    int n1, n2;
    int capacity;
    T* data;

public:

    DoubleStack(int cap)
    {
        capacity = cap;
        data = new T[capacity];
        n1 = 0;
        n2 = cap-1;
    }

    int getSize1() {return this.n1;}
    int getSize2() {return this->capacity - this.n2 - 1;}

    bool isEmpty1() {return n1 == 0;}
    bool isEmpty2() {return n2 == capacity-1;}
    bool isFully() {return n1 > n2;}

    bool push1(T value)
    {
        if(isFully()) false;
        data[n1++] = value;
        return true;
    }
    bool push2(T value)
    {
        if(isFully()) return false;
        data[n2--] = value;
        return true;
    }
    
    T top1()
    {
        if(isEmpty1()) throw("Stack is Empty.");
        return data[n1-1];
    }
    T top2()
    {
        if(isEmpty2()) throw("Stack is Empty.");
        return data[n2+1];
    }

    T pop1()
    {
        if(isEmpty1()) throw("Stack is Empty.");
        T value = data[n1-1];
        n1--;
        return value;
    }
    T pop2()
    {
        if(isEmpty2()) throw("Stack is Empty.");
        T value = data[n2+1];
        n2++;
        return value;
    }
};