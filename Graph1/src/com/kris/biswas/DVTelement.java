package com.kris.biswas;

class DVTelement<T> {
    T toVertex;
    Integer distance;
    T throughVertex;

    DVTelement(T to, Integer distance, T via){
        toVertex = to;
        this.distance = distance;
        throughVertex = via;
    }
}
