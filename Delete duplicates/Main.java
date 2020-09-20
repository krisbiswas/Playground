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
  list<int> l,oriL;
  while((cin>>dummy) && dummy>=0){
    if(!contains(l,dummy)){
      l.push_back(dummy);
    }
    oriL.push_back(dummy);
  }
  cout<<"Linked list before removal of duplicates"<<endl;
  for(list<int>::iterator it=oriL.begin();it!=oriL.end();it++){
  	cout<<*it<<endl;
  }
  cout<<"Linked list after removal of duplicates"<<endl;
  for(list<int>::iterator it=l.begin();it!=l.end();it++){
  	cout<<*it<<endl;
  }
  return 0;
}