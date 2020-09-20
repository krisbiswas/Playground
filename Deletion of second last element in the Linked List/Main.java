#include<iostream>
#include<list>
using namespace std;
int main()
{
  list<int> l;
  int dummy;
  while((cin>>dummy) && dummy>=0){
    l.push_back(dummy);
  }
  if(l.size()<2){
    cout<<"Deletion of second last element is not possible"<<endl;
    return 0;
  }
  list<int>::iterator iter = l.begin();
  int index=0;
  while(index<l.size()-2){
    iter++;
    index++;
  }
  l.remove(*iter);
  for(iter=l.begin();iter!=l.end();iter++){
    cout<<(*iter)<<" ";
  }
}