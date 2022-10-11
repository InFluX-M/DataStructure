#include <bits/stdc++.h>
using namespace std;

template <class T>
class DoublyLinkedList
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
        void setNext(Node *next) { this->next = next; }
        void setPrev(Node *prev) { this->prev = prev; }
        void setValue(T value) { this->value = value; }
        Node *getNext() { return this->next; }
        Node *getPrev() { return this->prev; }
        T getValue() { return this->value; }
    };

    Node *header;
    Node *tailer;
    int size;

public:
    DoublyLinkedList()
    {
        this->header = new Node(0);
        this->tailer = new Node(0);

        this->header->setNext(this->tailer);
        this->tailer->setPrev(this->header);

        this->size = 0;
    }

    Node* getHeader() {return this->header;}
    Node* getTailer() {return this->tailer;}
    int getSize() {return this->size;}
    
    void setSize(int newSize) {this->size=newSize;}
    void increaseSize() {this->size++;}
    void decreaseSize() {this->size--;}

    bool isEmpty() {return this->size==0;}

    T first()
    {
        if(this->isEmpty())
            throw "List is empty";
        return this->header->getNext()->getValue(); 
    }
    T last() 
    {
        if(this->isEmpty())
            throw "List is empty";
        return this->tailer->getPrev()->getValue(); 
    }

    void add(T e, Node* p, Node* s)
    {
        Node* newNode = new Node(e, p, s);
        p->setNext(newNode);
        s->setPrev(newNode);
        increaseSize();
    }
    T remove(Node* q)
    {
        q->getPrev()->setNext(q->getNext());
        q->getNext()->setPrev(q->getPrev());
        T temp = q->getValue();
        decreaseSize();
        delete q;
        return temp;
    }

    void addFirst(T value)
    {
        add(value, this->header, this->header->getNext());
    }
    void addLast(T value) {add(value, this->tailer->getPrev(), this->tailer);}

    T removeFirst()
    {   
        if(isEmpty()) throw "List is empty";
        return remove(this->header->getNext());
    }

    T removeLast()
    {   
        if(isEmpty()) throw "List is empty";
        return remove(this->tailer->getPrev());
    }

    T* traverse()
    {
        Node* temp = this->header->getNext();

        T* trav = new T[this->size];
        int i=0;

        while(temp != this->tailer)
        {
            trav[i++] = temp->getValue();   
            temp = temp->getNext();
        }

        return trav;
    }

    T* backTraverse()
    {
        Node* temp = this->tailer->getPrev();

        T* trav = new T[this->size];
        int i=0;

        while(temp != this->header)
        {
            trav[i++] = temp->getValue();   
            temp = temp->getPrev();
        }

        return trav;
    }

};