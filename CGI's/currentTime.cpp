#include <iostream>
#include <ctime>

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

    time_t t = time(NULL);
    tm* now = localtime(&t);
    cout << now->tm_hour % 24 << ":" << now->tm_min << ":"<< now->tm_sec<<"</h2>" << endl;
    cout<<"<a href=";
    cout<<"SouthAfrican.cgi";
    cout<<">Switch to South African Time</a><br>"<<endl;
    cout<<"<a href=";
    cout<<"Ghanain.cgi";
    cout<<">Switch to Ghana Time</a>"<<endl;

    return 0;
}