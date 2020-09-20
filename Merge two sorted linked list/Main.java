#include<iostream>
#include<list>
using namespace std;

void merge(list<int>& list1,list<int>& list2){
  list<int>::iterator it1=list1.begin(),it2=list2.begin();
  //list<int> mergedList;
  while(it1!=list1.end() && it2!=list2.end()){
    if(*it1 < *it2){
      cout<<*it1<<"->";
      //mergedList.push_back(*it1);
      it1++;
    }else{
      cout<<*it2<<"->";
      //mergedList.push_back(*it2);
      it2++;
    }
  }
  while(it1!=list1.end()){
    cout<<*it1<<"->";
      //mergedList.push_back(*it1);
    it1++;
  }
  while(it2!=list2.end()){
    cout<<*it2<<"->";
      //mergedList.push_back(*it2);
    it2++;
  }
  cout<<"NULL";
  //return mergedList;
}
int main()
{
  list<int> l1,l2;
  int dummy;
  int size;
  cin>>size;
  while(size-->0){
    cin>>dummy;
    l1.push_back(dummy);
  }
  cin>>size;
  while(size-->0){
    cin>>dummy;
    l2.push_back(dummy);
  }
  merge(l1,l2);
  return 0;
}