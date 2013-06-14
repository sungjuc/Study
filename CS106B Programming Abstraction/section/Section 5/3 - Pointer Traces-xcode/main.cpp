/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"

using namespace std;

void print(int* first, int* second);
void transmogrify(int* first, int* second);
void mutate(int* first, int* second);
void change(int* first, int* second);

int main() {
    int* one = new int[5];
    int* two = new int[5];
    
    for(int i = 0; i< 5; i++){
        one[i] = i;
        two[i] = i * 10;
    }
    
    transmogrify(one, two);
    print(one, two);
    
    mutate(one, two);
    print(one, two);
    
    change(one, two);
    print(one, two);
    
    delete[] one;
    delete[] two;
    
    return 0;
}

void print(int* first, int* second) {
    for(int i=0; i < 5; i++) {
        cout << i << ": " << first[i] << ", " << second[i] << endl;
    }
}

void transmogrify(int* first, int* second) {
    for (int i = 0; i < 5; i++) {
        first[i] = 137;
    }
}

void mutate(int* first, int* second) {
    first = second;
    second[0] = first[0];
}

void change(int* first, int* second) {
    first = new int[5];
    second = new int[5];
    
    for(int i=0; i< 5; i++){
        first[i] = second[i] = 271;
    }
}