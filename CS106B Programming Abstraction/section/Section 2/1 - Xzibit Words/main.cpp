/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "lexicon.h"

using namespace std;

string mostXzibitWord(Lexicon& words);
int getNumberOfSubstringWords(Lexicon& words, string word);

int main() {
    cout<<"Xzibit Words"<<endl;
    Lexicon words("EnglishWords.dat");
    Lexicon data("test.dat");
    
    string result = mostXzibitWord(words);
    
    cout << "Moxt xZibitWord: "<< result <<endl;
    return 0;
}

string mostXzibitWord(Lexicon& words){
    string result;
    int maxCount = 0;
    foreach(string word in words){
        int count = getNumberOfSubstringWords(words, word);
        if(maxCount < count) {
            maxCount = count;
            result = word;
        }

    }
    return result;
}

int getNumberOfSubstringWords(Lexicon& words, string word) {
    int count = 0;
    for(int i=0; i<word.length(); i++){
        for(int j= i + 1; j<word.length();j++){
            string tmp = word.substr(i, j-i);
            if(words.contains(tmp))
                count++;
        }
    }
    return count;
}