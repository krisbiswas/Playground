package com.kris.biswas;

public class SLL_Node {
    int data;
    SLL_Node next;

    SLL_Node(int data) {
        this.data = data;
        this.next = null;
    }
    SLL_Node(int data,SLL_Node next) {
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }

    protected SLL_Node getNext() {
        return next;
    }

    protected void setNext(SLL_Node next) {
        this.next = next;
    }
}
