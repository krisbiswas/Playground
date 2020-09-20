package com.kris.biswas;

import java.util.Scanner;

public class SinglyLinkedList {
    private Scanner scanner = new Scanner(System.in);
    SLL_Node head = null;
//    SLL_Node tail = null;
    private int size = 0;

    public void add(int data){
        if(head == null){
            head = new SLL_Node(data);
//            tail = head;
        }else{
//            tail.setNext(newNode);
//            tail = tail.getNext();
            SLL_Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new SLL_Node(data));
        }
        size++;
    }
    public void printList(){
        if(this.head == null){
            System.out.println("Empty List");
            return;
        }else{
            SLL_Node temp = this.head;
            System.out.print("[");
            while(temp != null){
                if(temp.getNext() == null){
                    System.out.print(temp.getData());
                }else{
                    System.out.print(temp.getData()+",");
                }
                temp = temp.getNext();
            }
            System.out.println("]");
        }
    }
    public void insert(int index,int data){
        if(head == null){
            System.out.print("There is no head Node.\nEnter y to create head Node or enter n: ");
            switch (scanner.next().charAt(0)){
                case 'y':
                    head = new SLL_Node(data);//tail = head;
                    size++;break;
                case 'n':
                    System.out.println("Head is Empty.");break;
            }
        }else if(index == 0){
            SLL_Node newNode = new SLL_Node(data);
            newNode.setNext(this.head);
            this.head = newNode;size++;
        }else{
            SLL_Node temp = head;
            int i=0;
            while(temp.getNext() != null && i<index){
                temp = temp.getNext();i++;
            }
            if(temp.getNext() == null && i<index){
                System.out.print("List is shorter then you expected.\n" +
                        "Wanna add this element at the end of this List?  ");
                if(scanner.next().matches("yes")){
                    temp.setNext(new SLL_Node(data,null));
                    size++;
                }
            }else if(i>=index){
                temp.setNext(new SLL_Node(data,temp.getNext()));
                size++;
            }
        }
    }
    public void remove(int data){
        System.out.println("0: Remove First Ocurrance\n1: Remove All");
        switch (scanner.nextInt()){
            case 0:
                removeFirstOccurance(data);break;
            case 1:
                removeAllOccurance(data);break;
        }
    }
    private void removeFirstOccurance(int data){
        if(this.head == null){
            System.out.println("Empty List");
            return;
        }else if(this.head.getData() == data) {
            this.head = this.head.getNext();
        }else{
            SLL_Node temp = this.head;
            while(temp != null){
                if(temp.getNext().getData() == data){
                    temp.setNext(temp.getNext().getNext());
                    size--;break;
                }
                temp = temp.getNext();
            }
        }
    }
    private void removeAllOccurance(int data){
        if(this.head == null){
            System.out.println("Empty List");
            return;
        }else{
            while (this.head.getData()==data){
                head=head.getNext();
            }
            SLL_Node temp = this.head;
            while(temp.getNext() != null) {
                if(temp.getNext().getData() == data){
                    temp.setNext(temp.getNext().getNext());size--;
                }
                temp = temp.getNext();
                if(temp == null){
                    break;
                }
            }
        }
    }
    public int size() {
        return size;
    }
}
