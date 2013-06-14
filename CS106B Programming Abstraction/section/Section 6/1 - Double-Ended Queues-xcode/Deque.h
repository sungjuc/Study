//
//  deque.h
//  Double-Ended Queues
//
//  Created by SungJu Cho on 6/13/13.
//
//

#ifndef Double_Ended_Queues_Deque_h
#define Double_Ended_Queues_Deque_h

class Deque {
public:
    Deque();
    ~Deque();

    void pushFront(int value);
    void pushBack(int value);

    int popFront();
    int popBack();
    
private:
    struct Cell {
        int value;
        Cell* next;
        Cell* prev;
    };
    
    Cell* head;
    Cell* tail;
};

#endif
