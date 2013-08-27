/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "queue.h"

using namespace std;

struct Node {
    string value;
    Node* left;
    Node* right;
};

void breadthFirstSearch(Node* root);

int main() {
    cout<<"Breadth-First Search"<<endl;
    
    Node* e = new Node;
    e->value="e";
    e->left = e->right = NULL;
    
    Node* c = new Node;
    c->value="c";
    c->left = c->right = NULL;
    
    Node* g = new Node;
    g->value="g";
    g->left = g->right = NULL;
    
    Node* i = new Node;
    i->value= "i";
    i->left = i->right = NULL;
    
    Node* d = new Node;
    d->value = "d";
    d->left = c;
    d->right = e;
    
    Node* a = new Node;
    a->value="a";
    a->left = a->right = NULL;
    
    Node* b = new Node;
    b->value = "b";
    b->left = a;
    b->right = d;
    
    Node* h = new Node;
    h->value = "h";
    h->left = g;
    h->right = i;
    
    Node* k = new Node;
    k->value="k";
    k->left = k->right = NULL;
    
    Node* j = new Node;
    j->value = "j";
    j->left=h;
    j->right=k;
    
    Node* root = new Node;
    root->value="f";
    root->left = b;
    root->right=j;
    
    breadthFirstSearch(root);
    
    return 0;
}


void breadthFirstSearch(Node* root) {
    if(root == NULL)
        return;
    
    Queue<Node*> queue;
    queue.enqueue(root);
    bool isFirst = true;
    while(!queue.isEmpty()){
        Node* node = queue.dequeue();
        if(!isFirst)
            cout<<", ";
        cout<<node->value;
        isFirst=false;
        if(node->left != NULL)
            queue.enqueue(node->left);
        if(node->right != NULL)
            queue.enqueue(node->right);
    }
    cout<<endl;
    
}

