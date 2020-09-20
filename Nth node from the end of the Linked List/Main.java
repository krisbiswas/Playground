#include<iostream>
#include<list>
using namespace std;
int main()
{
  list<int> l;
  int dummy;
  while((cin>>dummy) && dummy >= 0){
    l.push_back(dummy);
  }
  int N;
  cout<<"Enter the nth node:"<<endl;cin>>N;
  if(N>l.size()){
    cout<<"There is no nth node in the list"<<endl;
    return 0;
  }
  list<int>::iterator ahead=l.begin();
  list<int>::iterator behind=l.begin();
  while(ahead!=l.end()){
    while(--N>=0){
      ahead++;// = ahead.next();
    }
    ahead++;
    behind++;// = behind.next();
  }
  cout<< (*behind)<<" is the nth node element in the list" <<endl;
  
  return 0;
}