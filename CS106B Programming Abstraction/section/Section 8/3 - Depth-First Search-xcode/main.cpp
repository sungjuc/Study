/*
 * File: main.cpp
 * --------------
 * This is an empty C++ source file.
 */

#include <iostream>
#include "console.h"
#include "vector.h"
#include "map.h"

using namespace std;
Vector<string> depthFirstSearch(string start, string end, Vector<string> edgeFunction(string nodeName));

int main() {
    cout<<"Depth-First Search"<<endl;
    Map< string, Vector<string> > graph;
    Vector<string> data1;
    
    data1.add("2");
    data1.add("3");
    graph.put("1", data1);

    Vector<string> data2;
    data2.add("6");
    data2.add("8");
    graph.put("2", data2);
    
    Vector<string> data3;
    data3.add("7");
    data3.add("9");
    data3.add("10");
    graph.put("3", data3);
    
    Vector<string> data7;
    data7.add("20");
    data7.add("21");
    data7.add("22");
    graph.put("7", data7);
    
    Vector<string> data21;
    data21.add("30");
    data21.add("31");
    data21.add("32");
    graph.put("21", data21);
    
    return 0;
}

Vector<string> depthFirstSearch(string start, string end, Vector<string> edgeFunction(string nodeName)){
    if(
}