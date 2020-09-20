#include<iostream>
using namespace std;
int main()
{
  int size;cin>>size;
  int marks[size];
  int i=0;
  while(i++<size){
    cin>>marks[i-1];
  }
  int maxMarks=0;
  i=0;
  while(i++<size){
    maxMarks = (marks[i-1] > maxMarks)?marks[i-1]:maxMarks;
  }
  cout<<maxMarks;
  return 0;
}