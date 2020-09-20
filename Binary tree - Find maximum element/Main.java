import java.util.*;

class Node{
  int data;
  Node left = null;
  Node right= null;
  Node(int val){
    data = val;
  }
}
class Tree{
  Node root = null;
  
  void add(Node root,int data){
    if(root.data >= data){
      	if(root.left != null){
        	add(root.left,data);
      	}else{
    		root.left = new Node(data);
    	}
    }else{
    	if(root.right != null){
      		add(root.right,data);
      	}else{
        	root.right = new Node(data);
     	}
    }
    
  }
  void addNode(int data){
    if(root == null){
      root = new Node(data);
      return ;
    }
    if(root.data >= data){
      if(root.left != null){
        add(root.left,data);
      }else{
        root.left = new Node(data);
      }
    }else{
      if(root.right != null){
      	add(root.right,data);
      }else{
        root.right = new Node(data);
      }
    }
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    Node temp = root;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()){
      temp = q.poll();
      sb.append(temp.data+" ");
      if(temp.left != null){
        q.offer(temp.left);
      }
      if(temp.right != null){
        q.offer(temp.right);
      }
    }
    return sb.toString();
  }
  int maxEle(){
    if(root == null){
      return 0;
    }
    Node temp = root;
    while(temp.right != null){
      temp = temp.right;
    }
    return temp.data;
  }
}
class Main
{
  public static void main(String args[])
  {
    Scanner s= new Scanner(System.in);
    Tree t = new Tree();
    int dummy;
    while((dummy = s.nextInt()) != -1){
      t.addNode(dummy);
    }
    System.out.println("Maximum element is "+t.maxEle());
    s.close();
  }
}