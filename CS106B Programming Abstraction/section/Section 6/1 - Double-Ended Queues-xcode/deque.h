//
//  deque.h
//  Double-Ended Queues
//
//  Created by SungJu Cho on 6/13/13.
//
//

#ifndef Double_Ended_Queues_deque_h
#define Double_Ended_Queues_deque_h

class Dequeu {
public:
    Dequeu();
    ~Dequeu();

    void pushFront();
    void pushBack();

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
