/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"

using namespace std;

struct Node {
    int value;
    int leftSubtreeSize;
    Node* left;
    Node* right;
};

Node* nthNode(Node* root, int n);

int main() {
    cout<<"Order Statistic Trees"<<endl;
    return 0;
}

Node* nthNode(Node* root, int n){
    if(root == NULL)
        return NULL;
    if(root->leftSubtreeSize > n) {
        return nthNode(root->left, n);
    }
    
    if(root->leftSubtreeSize < n) {
        return nthNode(root->right, n-root->leftSubtreeSize);
    }
    
    return root;
}
