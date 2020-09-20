package com.kris.biswas;

import java.util.LinkedList;
import java.util.Queue;

public class BST extends BTree{
//    BNode root = null;
    int size = 0;

    @Override
    void addNode(int data) {
        if (super.root == null) {
            super.root = new BNode(data);
            super.size++;
            return;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(super.root);
        while (!q.isEmpty()) {
            BNode temp = q.poll();
            if (data > temp.getData()) {
                if (temp.getRight() != null) {
                    q.offer(temp.getRight());
                } else {
                    temp.setRight(new BNode(data));
                    break;
                }
            } else if (data < temp.getData()) {
                if (temp.getLeft() != null) {
                    q.offer(temp.getLeft());
                } else {
                    temp.setLeft(new BNode(data));
                    break;
                }
            }
        }
    }

    int maxValue(){
        if(super.root == null){
            return -1;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(super.root);
        int res = -1;
        while(!q.isEmpty()){
            BNode temp = q.poll();
            if(temp.getRight() != null){
                q.offer(temp.getRight());
            }else{
                res = temp.getData();
            }
        }
        return res;
    }
    int minValue(){
        if(super.root == null){
            return -1;
        }
        Queue<BNode> q = new LinkedList<>();
        q.offer(super.root);
        int res = -1;
        while(!q.isEmpty()){
            BNode temp = q.poll();
            if(temp.getLeft() != null){
                q.offer(temp.getLeft());
            }else{
                res = temp.getData();
            }
        }
        return res;
    }
//    int indexOf(int data){
//        if(root == null){
//            return -1;
//        }
//        BNode temp = root;
//        int index=0;
//        while(temp!=null){
//            if(temp.getData() == data){
//                break;
//            }
//            if(temp.getData() < data){
//                temp = temp.getRight();
//            }else if(temp.getData() > data){
//                temp = temp.getLeft();
//            }
//            index++;
//        }
//        return index;
//    }

}
