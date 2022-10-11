#include <bits/stdc++.h>
using namespace std;

template <class T> 
class SinglyLinkList
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
        ~Node()
        {
            this->next=nullptr;
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

    SinglyLinkList()
    {
        this->head = nullptr;
        this->tail = nullptr;
        this->size = 0;
    }
    ~SinglyLinkList()
    {
        this->head->~Node();
        this->tail->~Node();
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
        if(this->size==0) this->tail = this->head;
        increaseSize();
    }

    void addLast(T value)
    {
        Node* newNode = new Node(value);

        if(isEmpty()) this->head = newNode;
        else this->tail->setNext(newNode);
        
        this->tail = newNode;
        increaseSize();
    }

    T removeFirst()
    {   
        if(isEmpty()) throw "List is empty";
        
        Node* temp = this->head;
        T value = temp->getValue();
        this->head = this->head->getNext();

        temp->~Node();
        decreaseSize();
        if(isEmpty()) this->tail = nullptr;

        return value;
    }
    
    void merge(SinglyLinkList* list1, SinglyLinkList* list2)
    {
        list1->getTail()->setNext(list2->getHead());
        this->setHead(list1->getHead());
        this->setTail(list2->getTail());
    }

    T* traverse()
    {
        Node* temp = head;

        T* trav = new T[this->size];
        int i=0;

        while(temp)
        {
            trav[i++] = temp->getValue();   
            temp = temp->getNext();
        }

        return trav;
    }
};