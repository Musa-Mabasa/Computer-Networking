#include <iostream>
#include <ctime>
#include <fstream>

using namespace std;

int main()
{
    cout<< "Content-type: text/html" << endl << endl;
    cout<<"<html>"<<endl;
    cout<<"<head>"<<endl;
    cout<<"<title>CGI</title>"<<endl;
    cout<<"</head>"<<endl;
    cout<<"<body>"<<endl;
    cout<<"<h2>";

    ofstream outfile;
    outfile.open("backend.txt");
    outfile<<2;
    outfile.close();

    time_t t = time(NULL);
    tm* now = localtime(&t);
    cout << (now->tm_hour) % 24 << ":" << now->tm_min << ":"<< now->tm_sec<<"</h2><br><br>" << endl;
    cout<<"<a href=";
    cout<<"currentTime.cgi";
    cout<<">Go Back!!</a><br>"<<endl;
    // cout<<"<a href="">Go next!!</a> "<<endl;

    return 0;
}