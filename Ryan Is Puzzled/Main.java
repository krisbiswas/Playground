#include<iostream>
using namespace std;
int main()
{
  int r;cin>>r;
  int c;cin>>c;
  int mat[r][c],t_mat[c][r];
  for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
      cin>>mat[i][j];
    }
  }
  for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
      t_mat[j][i]=mat[i][j];
    }
  }
  for(int i=0;i<c;i++){
    for(int j=0;j<r;j++){
      cout<<t_mat[i][j]<<" ";
    }
    cout<<endl;
  }
  
  return 0;
}