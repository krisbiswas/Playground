package com.kris.biswas;

import java.util.*;

class Graph<T> {
    private HashMap<T, LinkedList<T>> nodes;
    private int size;

    Graph(){
        this.nodes = new HashMap<>();
        size = 0;
    }

    //insert edge b/w two vertices
    void addEdge(T source,T dest){
        LinkedList<T> connections = nodes.get(source);
        if(!connections.contains(dest)){
            connections.add(dest);
        }
    }

    //Add new vertex in this graph
    void addVertex(T key,LinkedList<T> edges){
        size++;
        nodes.put(key,edges);
    }

    //Check whether graph contains a node/vertex with value Key
    boolean containsVertex(T key){
        return nodes.containsKey(key);
    }

    //Shows Adjacency List view of the graph
    void showAdjacencyLists() {
        for(T key:nodes.keySet()){
            System.out.println(key+" : "+nodes.get(key));
        }
//        for (LinkedList<T> n : nodes.values()){
//            System.out.println(n);
//        }
    }

    //returns the size of graph i.e. no. of vertices in the graph
    int getSize(){
        return size;
    }

    void BFS(T start){
        if(nodes.containsKey(start)){
            ArrayList<T> checkList = new ArrayList<>(nodes.size());
            Queue<T> q = new LinkedList<>();
            q.offer(start);
            T temp;
            while(!q.isEmpty()){
                temp = q.poll();
                if(!checkList.contains(temp)){
                    System.out.print(temp+" ");
                    checkList.add(temp);
                    for(T vertex : nodes.get(temp)){
                        if(!q.contains(vertex) && !checkList.contains(vertex)){
                            q.offer(vertex);
                        }
//                        else if(q.contains(vertex) && checkList.contains(vertex)){ q.remove(vertex); }
                    }
                }
            }
            System.out.println();
            checkList.clear();q.clear();
        }else{
            System.out.println("No such Vertex in this Graph!");
        }
    }
    //Recursive BFS can't be designed (stack behaviour of recursion). This method isn't BFS but traverses the graph
    private void rBFS(T start,ArrayList<T> checkList){
        if(!checkList.contains(start)){
            System.out.print(start+" ");
            checkList.add(start);
            for(int i=0;i<nodes.get(start).size();i++){
                rBFS(nodes.get(start).get(i),checkList);
            }
        }
    }
    void recursiveBFS(T start){
        rBFS(start,new ArrayList<T>());
        System.out.println();
    }

    void DFS(T start){
        if(nodes.containsKey(start)){
            ArrayList<T> checkList = new ArrayList<>(nodes.size());
            Stack<T> s = new Stack<>();
            s.push(start);
            T temp;
            while(!s.isEmpty()){
                temp = s.pop();
                if(!checkList.contains(temp)){
                    System.out.print(temp+" ");
                    checkList.add(temp);
                    for(T vertex : nodes.get(temp)){
                        if(!checkList.contains(vertex)){
                            s.push(vertex);
                        }
                    }
                }
            }
            System.out.println();
            checkList.clear();s.clear();
        }else{
            System.out.println("No such Vertex in this Graph!");
        }
    }
    private void rDFS(T start,ArrayList<T> checkList){
        if(!checkList.contains(start)){
            System.out.print(start+" ");
            checkList.add(start);
            for(int i=nodes.get(start).size()-1;i>-1;i--){
                rDFS(nodes.get(start).get(i),checkList);
            }
        }
    }
    void recursiveDFS(T start){
        rDFS(start,new ArrayList<T>(nodes.size()));
        System.out.println();
    }

    int getDistance(T src,T dest){              //unordered graph shortest distance
        if(nodes.containsKey(src) && nodes.containsKey(src)){
            HashMap<T,Integer> distances = new HashMap<>(nodes.size());
            for(T i : nodes.keySet()){          //cost from src to any node = inf initially
                distances.put(i,-1);            //distance -1 means inf
            }
            distances.put(src,0);
            ArrayList<T> checkList = new ArrayList<>(nodes.size());
            Queue<T> q = new LinkedList<>();
            q.offer(src);
            T temp;
            while(!q.isEmpty()){
                temp = q.poll();
                if(!checkList.contains(temp)){
                    checkList.add(temp);
                    int dFromSrc2Vertex;            //temporarily stores distance from src to any vertex in graph
                    for(T vertex : nodes.get(temp)){
                        dFromSrc2Vertex = distances.get(vertex);
                        if(distances.get(temp)/*(get func call returns distance from src to temp)*/+1/*(distance from
                         temp to its shortest adjacent)*/<dFromSrc2Vertex || dFromSrc2Vertex<0){
                            distances.put(vertex,distances.get(temp)+1);
                        }
                        if(!q.contains(vertex) && !checkList.contains(vertex)){
                            q.offer(vertex);
                        }
                    }
                }
            }
            q.clear();
            System.out.println(distances);
            return distances.get(dest);
        }else{
            return -1;
        }
    }
}
