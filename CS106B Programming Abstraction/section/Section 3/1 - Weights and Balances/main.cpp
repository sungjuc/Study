/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "vector.h"

using namespace std;

bool isMeasurable(int target, Vector<int>& weights);
bool isMeasurable(int target, int pos, Vector<int>& weights);

int main() {
    cout << "Weights and Balances" << endl;
    
    Vector<int> sampleWieghts;
    sampleWieghts += 1, 3;
    
    cout << "2 with (1,3): " << isMeasurable(2, sampleWieghts) << endl;
    cout << "5 with (1,3): " << isMeasurable(5, sampleWieghts) << endl;
    
    return 0;
}

bool isMeasurable(int target, Vector<int>& weights) {
    return isMeasurable(target, 0, weights);
}

bool isMeasurable(int target, int pos, Vector<int>& weights) {
    if(pos == weights.size())
        return target == 0;
    int weight = weights[pos];
    pos++;
    return isMeasurable(target - weight, pos, weights) ||
           isMeasurable(target, pos, weights) ||
    isMeasurable(target + weight, pos, weights);
}
