#include<iostream>
using namespace std;
int main()
{
  int n;cin>>n;
  int passedRollNo[n];
  int i=0;
  for(i=0;i<n;i++){
    cin>>passedRollNo[i];
  }
  int AlexRollNo;cin>>AlexRollNo;
  for(i=0;i<n;i++){
    if(passedRollNo[i]==AlexRollNo){
      //cout<<"Yay! You cleared the exam";
      cout<<"She passed her exam";
      return 0;
    }
  }
  //cout<<"Oh no! Better luck next time";
  cout<<"She failed";
  return 0;
}