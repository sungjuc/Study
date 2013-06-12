/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "vector.h"
#include "lexicon.h"

using namespace std;

bool findAnagram(string letters, Lexicon& english, Vector<string>& words);
bool validWord(string& letters, string& word);

int main() {
    cout << "Multiword Anagrams" << endl;
    Lexicon english("EnglishWords.dat");
    Vector<string> words;
    
    bool result = findAnagram("odraconiandevil", english, words);
    
    if (result) {
        cout<<"Success!!! "<<endl;
        cout<<words.toString()<<endl;
    } else
        cout<<"Fail!!!!"<<endl;
    
    Vector<string> words2;
    
    result = findAnagram("ohlamesaint", english, words2);
    
    if (result) {
        cout<<"Success!!! "<<endl;
        cout<<words2.toString()<<endl;
    } else
        cout<<"Fail!!!!"<<endl;
    
    Vector<string> words3;
    
    result = findAnagram("sodarktheconofman", english, words3);
    
    if (result) {
        cout<<"Success!!! "<<endl;
        cout<<words3.toString()<<endl;
    } else
        cout<<"Fail!!!!"<<endl;
    
    return 0;
}

bool findAnagram(string letters, Lexicon& english, Vector<string>& words) {
    int minWordSize = 2;
    
    string tmp = letters;
    
    if (tmp.size() == 0)
        return true;
    
    foreach(string word in english){
        if((word.size() > minWordSize) && validWord(tmp, word)) {
            if(findAnagram(tmp, english, words)) {
                words += word;
                return true;
            }
            tmp = letters;
        }
    }

    return false;
}

bool validWord(string& letters, string& word){
    string tmp = letters;
    foreach(char a in word) {
        int index = tmp.find(a);
        if(index == std::string::npos)
            return false;
        else
            tmp.erase(index, 1);
    }
    
    letters = tmp;
    return true;
}