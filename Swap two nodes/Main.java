#include<iostream>
#include<list>
using namespace std;

int main()
{
  int size;cin>>size;
  list<int> li;
  int dummy;
  while(size-->0){
    cin>>dummy;
    li.emplace_back(dummy);
  }
  int p,q;
  cin>>p>>q;
  list<int>::iterator it=li.begin();
  while(it!=li.end()){
    if(*it==p){
      *it=q;
    }
    else if(*it==q){
      *it=p;
    }
    it++;
  }
  for(it=li.begin();it!=li.end();it++){
    cout<<*it<<" ";
  }
  return 0;
}