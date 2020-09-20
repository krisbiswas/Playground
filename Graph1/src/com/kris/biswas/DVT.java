package com.kris.biswas;

import java.util.ArrayList;
import java.util.Vector;

public class DVT<T> {
    ArrayList<DVTelement> toVertex;

    DVT(){
        toVertex = new ArrayList<>();
    }

    boolean contains(T vertex){
        return toVertex.contains(vertex);
    }

    void add(T to,Integer dist,T via){          //
        toVertex.add(new DVTelement(to,dist,via));
    }

    void remove(T vertex){
        toVertex.remove(vertex);
    }

    void update(T to,Integer dist,T via){       //method is used in algos. involving distance as factor
        boolean found = false;
        for(DVTelement e : toVertex){
            if(to.equals(e.toVertex)){
                e.distance = dist;
                e.throughVertex = via;
                found = true;
            }
        }
        if(found){
            return;
        }else {
            add(to,dist,via);
        }
    }
}
