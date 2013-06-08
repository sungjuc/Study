/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "random.h"

using namespace std;

string randomShuffle(string);

int main() {
    
    //string testData = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string testData = "ABCD";
    string resultData = randomShuffle(testData);
    
    cout << "Result Data: " << resultData <<endl;
    
    return 0;
}

string randomShuffle(string input) {
    if(input.size()==0)
        return "";
    int randomIndex = randomInteger(0, input.size());
    return input[randomIndex] + randomShuffle(input.erase(randomIndex, 1));
}