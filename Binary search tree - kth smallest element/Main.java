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
  Integer ans = new Integer(-1);
  
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
  int inOrder(Node root,int count){
    if(root == null){
      return count;
    }
    count = inOrder(root.left,count);
    count--;
    if(count == 0){
      ans = root.data;
      return 0;
    }
    count = inOrder(root.right,count);
    return count;
  }
  int kSmallest(int k){
    inOrder(root,k);
    return ans;
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
    int k=s.nextInt();
    System.out.println("Enter the kth value:\nSmallest kth value "+t.kSmallest(k));
    s.close();
  }
}