package com.kris.biswas;

import java.util.PriorityQueue;

class keyNode<T> {
    T key;
//    PriorityQueue<T> pq;
    DVT<T> dvt;                           //Distance Vector Table

    keyNode(){
        key = null;
    }
    keyNode(T key){
        this.key = key;
        dvt = new DVT<>();
    }

    void updateTable(T to,Integer dist,T via){
        dvt.update(to,dist,via);
    }

    void addToTable(T to,Integer dist){
        dvt.add(to,dist,null);      //null means node is in adj. List
    }
}
