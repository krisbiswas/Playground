#include<iostream>
using namespace std;
int main()
{
  int nRow;cin>>nRow;
  int nCol;cin>>nCol;
  int mat[nRow][nCol], mat2[nRow][nCol];
  int nMat=2;
  for(int i=0;i<nRow;i++){
    for(int j=0;j<nCol;j++){
      cin>>mat[i][j];
    }
  }
  for(int i=0;i<nRow;i++){
    for(int j=0;j<nCol;j++){
      cin>>mat2[i][j];
    }
  }
  for(int i=0;i<nRow;i++){
    for(int j=0;j<nCol;j++){
      cout<<(mat[i][j]+mat2[i][j])<<" ";
    }
    cout<<endl;
  }
  return 0;
}