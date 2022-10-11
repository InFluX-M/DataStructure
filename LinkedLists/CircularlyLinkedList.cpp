#include <bits/stdc++.h>
using namespace std;

template <class T> 
class CircularlyLinkedList
{
    class Node
    {
    private:
        T value;
        Node* next;

    public:
        Node(T value, Node* next=nullptr)
        {
            this->value=value;
            this->next=next;
        }
        void setNext(Node* next) {this->next=next;}
        void setValue(T value) {this->value=value;}
        Node* getNext() {return this->next;}
        T getValue() {return this->value;}

    };

    Node* head;
    Node* tail;
    int size;

public:

    CircularlyLinkedList()
    {
        this->head = nullptr;
        this->tail = nullptr;
        this->size = 0;
    }

    Node* getHead() {return this->head;}
    Node* getTail() {return this->tail;}
    int getSize() {return this->size;}
    
    void setHead(Node* newHead) {this->head=newHead;}
    void setTail(Node* newTail) {this->tail=newTail;}
    void setSize(int newSize) {this->size=newSize;}
    void increaseSize() {this->size++;}
    void decreaseSize() {this->size--;}

    bool isEmpty() {return this->size==0;}

    T first()
    {
        if(this->isEmpty())
            throw "List is empty";
        return this->head->getValue(); 
    }

    T last() 
    {
        if(this->isEmpty())
            throw "List is empty";
        return this->tail->getValue(); 
    }

    void addFirst(T value)
    {
        this->head = new Node(value, this->head);

        if(isEmpty()) this->tail = this->head;
        
        this->tail->setNext(this->head);
        increaseSize();
    }

    void addLast(T value)
    {
        Node* newNode = new Node(value, this->head);

        if(isEmpty())
        {
            this->head = newNode;    
            this->tail = newNode;
        } 

        this->tail->setNext(newNode);
        increaseSize();
    }

    T removeFirst()
    {   
        if(isEmpty()) throw "List is empty";
        
        Node* temp = this->head;
        T value = temp->getValue();
        this->head = this->head->getNext();
        this->tail->setNext(this->head);

        delete temp;
        decreaseSize();

        return value;
    }

    void rotate()
    {
        if(isEmpty()) throw "List is empty";

        this->tail = this->head;
        this->head = this->head->getNext();
    }

    void traverse()
    {
        Node* temp = head;

        do
        {
            cout<<temp->getValue()<<"\n";
            temp = temp->getNext();
        } while (temp != this->head);
    }
};