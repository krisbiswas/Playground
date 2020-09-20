#include<iostream>
#include<list>
using namespace std;
bool contains(list<int>& l,int data){
  list<int>::iterator it=l.begin();
  while(it!=l.end()){
    if(*it == data){
      return true;
    }
    it++;
  }
  return false;
}
int main()
{
  int dummy;
  list<int> l;
  while((cin>>dummy) && dummy>=0){
    if(!contains(l,dummy)){
      l.push_back(dummy);
    }
  }
  if(l.empty()){
    cout<<"List is empty"<<endl;
  }else{
  	for(list<int>::iterator it=l.begin();it!=l.end();it++){
      cout<<*it<<endl;
    }
  }
  return 0;
}