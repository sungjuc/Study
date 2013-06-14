/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "lexicon.h"

using namespace std;

bool isElementSpellable(string text, Lexicon& symbols);

int main() {
    Lexicon symbols;
    
    cout << "CHeMoWIZrDy" << endl;
    return 0;
}

bool isElementSpellable(string text, Lexicon& symbols) {
    
    for (int i = 1; i <= text.length() && i <=3 ; i++) {
        string tmp = text.substr(0, i);
        if(symbols.contains(text.substr(0, i)) && isElementSpellable(text.substr(i), symbols))
                            return true;  
    }
    
    return false;
}