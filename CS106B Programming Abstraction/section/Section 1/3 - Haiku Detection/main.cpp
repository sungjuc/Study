/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include <fstream>
#include "console.h"
#include "simpio.h"
#include "tokenscanner.h"

using namespace std;

int syllablesIn(string word);
bool isHaiku(string);


int main() {
    cout<<"Haiku Detection"<<endl;
    string filename = "syllables.txt";
    
    cout<<"The result is: " << isHaiku(filename) << endl;
    
    
    return 0;
}

bool isHaiku(string filename) {
    fstream infile;
    infile.open(filename.c_str());
    string temp;
    int count = 0;
    TokenScanner scanner;
    while(getline(infile, temp)){
        count++;
        int syllables = 0;
        scanner.setInput(temp);
        while (scanner.hasMoreTokens()){
            syllables += syllablesIn(scanner.nextToken());
        }
        if((count == 1 || count ==3)&&syllables!=5){
            infile.close();
            return false;
        }
        if (count == 2 && syllables !=7){
            infile.close();
            return false;
        }
        if (count >3){
            infile.close();
            return false;
        }
            
    }
    return true;
}

int syllablesIn(string word) {
    // Need to be implemented.
    return 0;
}