#include<iostream>
using namespace std;
int main(){
  // Type your code here
  int n;cin>>n;
  int tNums[n];
  for(int i=0;i<n;i++){
    cin>>tNums[i];
  }
  int m=0,f=0;
  for(int i=0;i<n;i++){
    if((tNums[i]&1) == 1){
      m++;
    }else{
      f++;
    }
  }
  cout<<m<<"\n"<<f<<endl;
  return 0;
}