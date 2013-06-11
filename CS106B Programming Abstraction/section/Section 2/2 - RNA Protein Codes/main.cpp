/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "vector.h"
#include "map.h"

Vector<string> findProteins(string& rna, Map<string, string> codons);
string findProteins(int& pos, string& rna, Map<string, string> codons);


using namespace std;

int main() {
    cout << "RNA Protein Codes" << endl;
    return 0;
}

Vector<string> findProteins(string& rna, Map<string, string> codons){
    int pos = 0;
    
    Vector<string> result;
    
    while((pos = rna.find("AUG", pos)) != std::string::npos){
        result.add(findProteins(pos, rna, codons));
    }
    
    return result;
}

string findProteins(int& pos, string& rna, Map<string, string> condons){
    if (pos + 3 > rna.length())
        error("RNA string is not valid");
    string tmp = condons[rna.substr(pos, 3)];
    pos = pos + 3;
    if (tmp == "stop")
        return "";
    else
        return tmp+", "+findProteins(pos, rna, condons);
}
