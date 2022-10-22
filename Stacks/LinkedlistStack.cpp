#include <bits/stdc++.h>
using namespace std;

template <class T>
class LinkedListStack
{

    class Node
    {
    private:
        T value;
        Node *next;
        Node *prev;

    public:
        Node(T value, Node *prev = nullptr, Node *next = nullptr)
        {
            this->value = value;
            this->prev = prev;
            this->next = next;
        }

        void setPrev(Node *prevprev) { this->prev = prevprev; }
        void setNext(Node *next) { this->next = next; }
        void setValue(T value) { this->value = value; }
        Node *getNext() { return this->next; }
        Node *getPrev() { return this->prev; }
        T getValue() { return this->value; }
    };

    Node *tail;
    int size;

public:
    LinkedListStack()
    {
        this->tail = nullptr;
        this->size = 0;
    }

    Node *getTail() { return this->tail; }
    int getSize() { return this->size; }

    void setTail(Node *newTail) { this->tail = newTail; }
    void setSize(int newSize) { this->size = newSize; }
    void increaseSize() { this->size++; }
    void decreaseSize() { this->size--; }

    bool isEmpty() { return this->size == 0; }

    void push(T value)
    {
        Node *newNode = new Node(value, this->tail, nullptr);

        if (!isEmpty()) this->tail->setNext(newNode);
        this->tail = newNode;
        increaseSize();
    }

    T pop()
    {
        if (isEmpty()) throw "List is empty";

        T value = this->tail->getValue();
        Node* q = this->tail;

        if(size > 1) this->tail->getPrev()->setNext(nullptr);
        this->tail = this->tail->getPrev();

        decreaseSize();

        delete q;
        return value;
    }

    T top()
    {
        if (isEmpty()) throw "List is empty";
        return this->tail->getValue();
    }
};