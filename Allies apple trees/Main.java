#include <iostream>
using namespace std;

int main() 
{
   // Try out your code here
    int reqApples;
  cin>>reqApples;
  if(reqApples % 12 == 0){
  	cout<<(reqApples/12)*8;
  }else{
    cout<<((reqApples/12)+1)*8<<endl;
  }
    return 0;
}