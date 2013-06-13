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
    string tmp1 = text.substr(0, 1);
    string tmp2 = text.substr(0, 2);
    string tmp3 = text.substr(0, 3);
    
    if (symbols.contains(tmp1) && isElementSpellable(tmp1, symbols))
        return true;
    if (symbols.contains(tmp2) && isElementSpellable(tmp2, symbols))
        return true;
    if (symbols.contains(tmp3) && isElementSpellable(tmp3, symbols))

    
    return false;
}