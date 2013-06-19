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
    Node* left;
    Node* right;
};

bool isBST(Node* root);

int main() {
    
    cout<< "Checking BST Validity"<<endl;
    
    return 0;
}

bool isBST(Node* root){
    if (root == NULL)
       return true;
    bool leftResult = false;
    bool rightResult = false;
    if (root->left != NULL) {
        if(root->value >= root->left->value)
            leftResult = isBST(root->left);
    }
    if (root->right != NULL) {
        if(root->value <= root->right->value)
            rightResult = isBST(root->right);
    }
    return leftResult && rightResult;
}


