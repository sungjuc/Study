/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include <fstream>
#include "console.h"
#include "simpio.h"

using namespace std;

void averageValueInFile(string filename, double& result);

int main() {
    string filename = "test.txt";
    double result = 0 ;
    averageValueInFile(filename, result);
    cout<<"result: "<<result<<endl;
    return 0;
}

void averageValueInFile(string filename, double& result) {

    ifstream infile;
    infile.open(filename.c_str());
    string temp;
    int count=0;
    double sum = 0;
    while(getline(infile, temp)) {
        count++;
        sum += atof(temp.c_str());
    }
    result = sum/count;
    infile.close();
}