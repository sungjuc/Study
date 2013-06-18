/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "string.h"

using namespace std;

struct Cell {
    int value;
    Cell* next;
};

void quicksort(Cell*& list);
Cell* getSample();
void printList(Cell*& list);

int main() {
    
    cout<<"Quick Sort"<<endl;
    
    Cell* sample = getSample();
    
    quicksort(sample);
    
    printList(sample);
    
    return 0;
}

void quicksort(Cell*& list){
    if(list->next == NULL)
        return;
    
    Cell* first = list;
    Cell* left = NULL;
    Cell* right = NULL;
    Cell* cursor = list;
    Cell* leftLast;
    
    while(cursor->next != NULL){
        cursor = cursor->next;
        Cell* tmp = new Cell;
        tmp->value = cursor->value;
        if(cursor->value <= first->value) {
            tmp->next = left;
            left = tmp;
        } else {
            tmp->next = right;
            right = tmp;
        }
    }
    
    if(right != NULL) {
        quicksort(right);
    }
    
    if(left != NULL) {
        quicksort(left);
    }
    
    leftLast = left;
    while(left != NULL && leftLast->next != NULL) {
        leftLast = leftLast->next;
    }
    if(leftLast != NULL)
        leftLast->next = first;
   
    first->next = right;
    
    if(left!=NULL)
        list = left;
    else
        list = first;
}

Cell* getSample() {
    Cell* sample = new Cell;
    sample->value=5;
    Cell* sample2 = new Cell;
    sample2-> value=2;
    sample->next=sample2;
    Cell* sample3 = new Cell;
    sample3-> value = 7;
    sample2->next = sample3;
    Cell* sample4 = new Cell;
    sample4->value = 1;
    sample3->next = sample4;
    sample4->next = NULL;
    
    return sample;
}

void printList(Cell*& list) {
    Cell* cursor = list;
    bool isFirst = true;
    
    while(cursor != NULL){
        if(!isFirst)
            cout<<", ";
        isFirst = false;
        cout<<cursor->value;
        cursor = cursor->next;
    }
    cout<<endl;
}