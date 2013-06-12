/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "grid.h"

using namespace std;

void fillRegion(Grid<bool>& pixels, int row, int col);

int main() {
    cout << "Filling a Region" << endl;
    
    return 0;
}

void fillRegion(Grid<bool>& pixels, int row, int col) {
   if (!pixels[row][col])
       return;
    
    pixels[row][col] = true;
    
    fillRegion(pixels, row + 1, col);
    fillRegion(pixels, row - 1, col);
    fillRegion(pixels, row, col + 1);
    fillRegion(pixels, row, col - 1);
}