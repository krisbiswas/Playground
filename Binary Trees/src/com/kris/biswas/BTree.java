package com.kris.biswas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BTree {
    BNode root;
    int size;

    void addNode(int data){
        if(this.root == null){
            this.root = new BNode(data);size++;return;
        }
        Queue<BNode> q = new LinkedList<BNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BNode temp = q.poll();
                if(temp.getLeft() == null){
                    temp.setLeft(new BNode(data));break;
                }else{
                    q.offer(temp.getLeft());
                }
                if(temp.getRight() == null){
                    temp.setRight(new BNode(data));break;
                }else{
                    q.offer(temp.getRight());
                }
        }
        size++;
    }

    String preOrder(){
        if(this.root == null){
            System.out.println("Empty Tree");return "";
        }
        Stack<BNode> s = new Stack<BNode>();
        s.push(this.root);
        BNode temp;
        String preOrder = "";
        while(!s.isEmpty()){
            temp = s.pop();
//            System.out.print(temp.getData()+" ");
            preOrder+=temp.getData()+" ";
            if(temp.getRight() != null){
                s.push(temp.getRight());
            }
            if(temp.getLeft() != null){
                s.push(temp.getLeft());
            }
        }
//        System.out.println();
        return preOrder;
    }
    void preOrder(BNode root){
        if(root != null){
            System.out.print(root.getData()+" ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    String inOrder(){
        if(root == null){
            System.out.println("Empty Tree");return "";
        }
        Stack<BNode> s = new Stack<>();
        s.push(root);
        BNode temp;
        boolean done = false;
        temp = s.pop();
        String inOrder = "";
        while(!done){
            if(temp != null){
                s.push(temp);
                temp = temp.getLeft();
            }else{
                if(s.isEmpty()){
                    done = true;
                }else{
                    temp = s.pop();
//                    System.out.print(temp.getData()+" ");
                    inOrder+=temp.getData();
                    temp = temp.getRight();
                }
            }
        }
//        System.out.println();
        return inOrder;
    }
    void inOrder(BNode root){
        if(root == null){
            return;
        }
        BNode temp = root;
        if(temp.getLeft() != null){
            inOrder(temp.getLeft());
        }
        System.out.print(temp.getData()+" ");
        if(temp.getRight() != null){
            inOrder(temp.getRight());
        }
    }
//  To Be Continued
    void postOrder(){

    }

    void levelOrder(){
        if(this.root == null){
            System.out.println("Empty");return;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        while(!q.isEmpty()){
            BNode temp= q.poll();
            if(temp != null){
                if(temp.getLeft() != null){
                    q.offer(temp.getLeft());
                }
                if(temp.getRight() != null){
                    q.offer(temp.getRight());
                }
                System.out.print(temp.getData()+" ");
            }
        }
        System.out.println();
    }

    void treeHeight(){
        if(this.root == null){
            System.out.println("Height: "+0);return;
        }
        int count = 1;
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        q.offer(null);
        while (!q.isEmpty()){
            BNode current = q.poll();
            if(current !=null) {
                if (current.getLeft() != null) {
                    q.offer(current.getLeft());
                }
                if (current.getRight() != null) {
                    q.offer(current.getRight());
                }
            }else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        System.out.println("Height: "+count);
    }
    void minTreeHeight(){
        int count = 1;
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        q.offer(null);
        while (!q.isEmpty()){
            BNode current = q.poll();
            if(current !=null) {
                if(current.getLeft() == null && current.getRight() == null){
                    break;
                }
                if (current.getLeft() != null) {
                    q.offer(current.getLeft());
                }
                if (current.getRight() != null) {
                    q.offer(current.getRight());
                }
            }else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        System.out.println("Height: "+count);
    }

    void remove(int data){
        if(root == null){
            return;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        BNode current = root;
        BNode deleteElement = current;
        while (!q.isEmpty()){
            current = q.poll();
            if(current.getData() == data){
                deleteElement = current;
            }
            if(current.getLeft() != null){
                q.offer(current.getLeft());
            }
            if(current.getRight() != null) {
                q.offer(current.getRight());
            }
        }
        deleteElement.setData(current.getData());
        deleteDeepestNode(current);
    }
    private void deleteDeepestNode(BNode last){
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        while(!q.isEmpty()){
            BNode current = q.poll();
            if(current.getLeft() != null && current.getLeft() == last){
                current.setLeft(null);q.clear();
            }else{
                q.offer(current.getLeft());
            }
            if(current.getRight() != null && current.getRight() == last){
                current.setRight(null);q.clear();
            }else{
                q.offer(current.getRight());
            }
        }
    }
    void clear(){
        root = null;
    }

    public int getSize() {
        return size;
    }

    public boolean checkBST(BNode root){
        boolean left = false;
        boolean right = false;
        if(root.getLeft() != null) {
        	if(root.getData()>root.getLeft().getData()){
        		left = checkBST(root.getLeft());
            }
        }else {
        	left = true;
        }
        if(root.getRight() != null) {
        	if(root.getData()<root.getRight().getData()){
        		right = checkBST(root.getRight());
            }
        }else {
        	right = true;
        }    
        return (left && right);
    }
    
    public void K_distance_from_root(BNode root, int K) {
    	if(this.root == null){
            System.out.println("Empty");return;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(this.root);
        q.offer(null);
        while(!q.isEmpty() && K>-1){
            BNode temp= q.poll();
            if(temp != null){
                if(temp.getLeft() != null){
                    q.offer(temp.getLeft());
                }
                if(temp.getRight() != null){
                    q.offer(temp.getRight());
                }
                if(K==0) {
                    System.out.print(temp.getData()+" ");    	
                }
            }else {
            	q.offer(null);
            	K--;
            }
        }
    }
    
    public static int isSubTree(BNode root1, BNode root2)
    {
        BNode temp = null;
        Stack<BNode> s1 = new Stack<>();
        s1.push(root1);
        while(!s1.isEmpty()){
            temp = s1.pop();
            if(temp.getData() == root2.getData()){
                break;
            }
            if(temp.getRight() != null){
                s1.push(temp.getRight());
            }
            if(temp.getLeft() != null){
                s1.push(temp.getLeft());
            }
        }
        s1.clear();
        s1 = new Stack<BNode>();
        s1.push(temp);
        BNode temp2;
        Stack<BNode> s2 = new Stack<>();
        s2.push(root2);
        int isSubTree = -1;
        while(!s2.isEmpty() && !s1.isEmpty()){
            temp2 = s2.pop();
            temp = s1.pop();
            if((temp.getLeft() != null) ^ (temp2.getLeft()!=null) ||(temp.getRight() != null) ^ (temp2.getRight()!=null)){
                break;
            }else if(temp!=null && temp2!=null && temp.getData() != temp2.getData()){
                break;
            }
            
            if((temp.getRight() == null) ^ (temp2.getRight()== null)){
                break;
            }else if(temp.getRight() != null && temp2.getRight()!=null){
                s1.push(temp.getRight());
                s2.push(temp2.getRight());
            }
            
            if((temp.getLeft() == null) ^ (temp2.getLeft()==null)){
                break;
            }else if(temp.getLeft() != null && temp2.getLeft()!=null){
                s1.push(temp.getLeft());
                s2.push(temp2.getLeft());
            }
            
        }
        if(s2.isEmpty()){
            isSubTree = 1;
        }
        return isSubTree;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return preOrder();
    }
}
