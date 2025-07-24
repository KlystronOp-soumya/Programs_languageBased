#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "
constexpr char END_LINE = '\n';

class SinglyNode
{
public:
    int data{};
    SinglyNode *nextNodeAddressObj{};
    SinglyNode() : data{INT_FAST8_MIN}, nextNodeAddressObj{nullptr} {};
    SinglyNode(const int data) : data{data}, nextNodeAddressObj{nullptr} {};
};

class SinglyLinkedList
{

private:
    SinglyNode *head;

public:
    SinglyLinkedList()
    {
        head = new SinglyNode();
    }
    ~SinglyLinkedList()
    {
        SinglyNode *temp;
        while (this->head != NULL)
        {
            temp = head;
            head = head->nextNodeAddressObj;
            free(temp);
            temp = nullptr;
        }
        delete temp;
        delete head;
        head = nullptr;
    }
    void addBeg(const int data)
    {
        if (head == nullptr)
        { // not required as already created in constructor
            SinglyLinkedList(data);
        }
        else
        {
            SinglyNode *temp = new SinglyNode(data);
            temp->nextNodeAddressObj = head;
            head = temp;
        }
    }

    void showList()
    {
        if (head != nullptr)
        {
            SinglyNode *temp = head;
            while (temp->data != INT_FAST8_MIN && temp->nextNodeAddressObj != nullptr)
            {
                cout << "Data is: " << temp->data << END_LINE;
                temp = temp->nextNodeAddressObj;
            }
        }
    }
};

int main(int argc, char *argv[])
{
    SinglyLinkedList list;
    list.addBeg(1);
    list.addBeg(2);
    list.addBeg(3);

    list.showList();

    return 0;
}