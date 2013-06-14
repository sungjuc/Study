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

int main() {
    cout << "Weights and Balances" << endl;
    
    Vector<int> sampleWieghts;
    sampleWieghts += 1, 3;
    
    cout << "2 with (1,3): " << isMeasurable(2, sampleWieghts) << endl;
    cout << "5 with (1,3): " << isMeasurable(5, sampleWieghts) << endl;
    
    return 0;
}

bool isMeasurable(int target, Vector<int>& weights) {
    if(weights.isEmpty())
        return target ==0;
    
    int weight = weights[0];
    Vector<int> rest = weights;
    
    rest.remove(0);
    
    return isMeasurable(target + weight, rest)
           || isMeasurable(target, rest)
           || isMeasurable(target - weight, rest);
}
