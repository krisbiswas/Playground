#include<iostream>
#include<cmath>
using namespace std;

int main()
{
  //Type your code here
  int a,b,c;
  cin>>a>>b>>c;
  bool findLarge = true;
  int key = 0;
  int i=0;
  while(a>0 && b>0 && c>0){
    int temp;
    if(findLarge){
      temp = max(a%10,b%10);a=a/10;b=b/10;
      temp = max(temp,c%10);c=c/10;
      findLarge = false;
    }else{
      temp = min(a%10,b%10);a=a/10;b=b/10;
      temp = min(temp,c%10);c=c/10;
      findLarge = true;
    }
    key+=temp*pow(10,i);
    i++;
  }
  cout<<key<<endl;
  return 0;
}