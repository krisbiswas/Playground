import java.util.LinkedList;
import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(){data = -1;next = null;}
    Node(int data){
      this.data = data;
      this.next = null;
    }
}
class List{
  Node head;
  Node tail;
  List(){
    head = null;tail = null;
  }
  void add(int data){
    if(head == null){
      head = new Node(data);
      tail = head;
    }else{
      tail.next = new Node(data);
      tail = tail.next;
    }
  }
  void pairSwap(){
  	if(head == null){
      System.out.println("List is empty");return;
    }
    Node temp = head;
    while(temp != null && temp.next != null){
      int d = temp.data;
      temp.data = temp.next.data;
      temp.next.data = d;
      temp = temp.next.next;
    }
  }
  void print(){
    Node temp = head;
    while(temp != null){
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
}
class Main
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    List list = new List();
    while(s.hasNextInt()){
      int first = s.nextInt();
      if(first >= 0){
        list.add(first);
      }
    }
    list.pairSwap();
    list.print();
  }
}