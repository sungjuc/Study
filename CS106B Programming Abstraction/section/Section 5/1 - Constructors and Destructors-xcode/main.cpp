/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "stack.h"

using namespace std;

void printStack(Stack<int> toPrint);

int main() {
    Stack<int> elems;
    for(int i = 0; i < 10; i++)
        elems.push(i);
        
        printStack(elems);
    
    return 0;
}

void printStack(Stack<int> toPrint){
    Stack<int> temp;
    while(!toPrint.isEmpty())
        temp.push(toPrint.pop());
    
    while(!temp.isEmpty())
        cout << temp.pop() << endl;
}
