//
//  Deque.cpp
//  Double-Ended Queues
//
//  Created by SungJu Cho on 6/14/13.
//
//

#include <stddef.h>
#include "Deque.h"
#include "error.h"

Deque::Deque() {
    head = tail = NULL;
}

Deque::~Deque(){
    while(head != NULL){
        Cell* next = head->next;
        delete head;
        head = next;
    }
}

void Deque::pushFront(int value) {
    Cell* tmp = new Cell;
    tmp->value=value;
    
    if(head == NULL){
        head = tail = tmp;
    } else {
        tmp->next=head;
        head->prev=tmp;
        head=tmp;
    }
}

void Deque::pushBack(int value) {
    Cell* tmp = new Cell;
    tmp->value = value;
    
    if(tail==NULL){
        head=tail=tmp;
    } else {
        tmp->prev=tail;
        tail->next=tmp;
        tail = tmp;
    }
    
}

int Deque::popFront() {
    if(head==NULL)
        error("Empty!!!");
    int res = head->value;
    
    Cell* tmp = head;
    head = head->next;
    head->prev = NULL;
    delete tmp;
    
    if(head==NULL)
        tail=NULL;
    
    return res;
}
int Deque::popBack() {
    if(tail==NULL)
        error("Empty!!!");
    int res = tail->value;
    Cell* tmp = tail;
    tail = tail->prev;
    tail->next = NULL;
    delete tmp;
    
    if(tail==NULL)
        head = NULL;
    
    return res;
}
