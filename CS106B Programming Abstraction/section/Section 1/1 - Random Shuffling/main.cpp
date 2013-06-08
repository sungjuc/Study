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
    if(input.length()==1)
        return input;
    int randomIndex = randomInteger(0, input.length()-1);
    return input[randomIndex] + randomShuffle(input.substr(0, randomIndex) + input.substr(randomIndex+1));
}