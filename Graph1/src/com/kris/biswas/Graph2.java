package com.kris.biswas;

import java.util.*;

class Graph2<T> {
    private LinkedHashMap<keyNode<T>, LinkedList<T>> adjNodes;
//    private Hashtable<keyNode<T>, LinkedList<T>> adjNodes;
    private int size;

    Graph2(){
        this.adjNodes = new LinkedHashMap<>();
//        this.adjNodes = new Hashtable<>();
        size = 0;
    }

    //insert edge b/w two vertices
    void addEdge(T source,T destination,Integer dist){
        LinkedList<T> connections = null;
        for(keyNode ky: adjNodes.keySet()){
            if(ky.key.equals(source)){
                connections = adjNodes.get(ky);
                break;
            }
        }
        if(!connections.contains(destination)){
            connections.add(destination);
            for(keyNode key: adjNodes.keySet()){
                if(key.key == source){
                    key.dvt.update(source,dist,destination);
                }
            }
        }else {
            System.out.println("Edge already exists.");
        }
    }

    //Add new vertex in this graph
    void addVertex(T key){
        adjNodes.put(new keyNode<>(key),new LinkedList<>());
        size++;
    }

    //Check whether graph contains a node/vertex with value Key
    boolean containsVertex(T key){
        for(keyNode ky: adjNodes.keySet()){
            if(ky.key == key){
                return true;
            }
        }
        return false;
    }

    //Shows Adjacency List view of the graph
    void showAdjacencyLists() {
        for(keyNode key:adjNodes.keySet()){
            System.out.println(key.key+" : "+adjNodes.get(key));
        }
//        for (LinkedList<T> n : adjNodes.values()){
//            System.out.println(n);
//        }
    }

    //returns the size of graph i.e. no. of vertices in the graph
    int getSize(){
        return size;
    }

    void BFS(T start){
        if(containsVertex(start)){
            ArrayList<T> checkList = new ArrayList<>(adjNodes.size());
            Queue<T> q = new LinkedList<>();
            q.offer(start);
            T temp;
            while(!q.isEmpty()){
                temp = q.poll();
                if(!checkList.contains(temp)){
                    System.out.print(temp+" ");
                    checkList.add(temp);
                    LinkedList<T> startAdjList = null;
                    for(keyNode ky: adjNodes.keySet()){
                        if(ky.key.equals(temp)){
                            startAdjList = adjNodes.get(ky);
                            break;
                        }
                    }
                    for(T vertex : startAdjList){
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
            LinkedList<T> startAdjList = null;
            for(keyNode ky: adjNodes.keySet()){
                if(ky.key.equals(start)){
                    startAdjList = adjNodes.get(ky);
                    break;
                }
            }
            for(int i=0;i<startAdjList.size();i++){
                rBFS(startAdjList.get(i),checkList);
            }
        }
    }
    void recursiveBFS(T start){
        rBFS(start,new ArrayList<T>());
        System.out.println();
    }

    void DFS(T start){
        if(containsVertex(start)){
            ArrayList<T> checkList = new ArrayList<>(adjNodes.size());
            Stack<T> s = new Stack<>();
            s.push(start);
            T temp;
            while(!s.isEmpty()){
                temp = s.pop();
                if(!checkList.contains(temp)){
                    System.out.print(temp+" ");
                    checkList.add(temp);
                    LinkedList<T> startAdjList = null;
                    for(keyNode ky: adjNodes.keySet()){
                        if(ky.key.equals(temp)){
                            startAdjList = adjNodes.get(ky);
                            break;
                        }
                    }
                    for(T vertex : startAdjList){
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
            LinkedList<T> startAdjList = null;
            for(keyNode ky: adjNodes.keySet()){
                if(ky.key.equals(start)){
                    startAdjList = adjNodes.get(ky);
                    break;
                }
            }
            for(int i=startAdjList.size()-1;i>-1;i--){
                rDFS(startAdjList.get(i),checkList);
            }
        }
    }
    void recursiveDFS(T start){
        rDFS(start,new ArrayList<T>(adjNodes.size()));
        System.out.println();
    }

//    int getDistance(T src,T dest){              //unordered graph shortest distance
//        if(adjNodes.containsKey(src) && adjNodes.containsKey(src)){
//            HashMap<T,Integer> distances = new HashMap<>(adjNodes.size());
//            for(keyNode i : adjNodes.keySet()){          //cost from src to any node = inf initially
//                distances.put(i,-1);            //distance -1 means inf
//            }
//            distances.put(src,0);
//            ArrayList<T> checkList = new ArrayList<>(adjNodes.size());
//            Queue<T> q = new LinkedList<>();
//            q.offer(src);
//            T temp;
//            while(!q.isEmpty()){
//                temp = q.poll();
//                if(!checkList.contains(temp)){
//                    checkList.add(temp);
//                    int dFromSrc2Vertex;            //temporarily stores distance from src to any vertex in graph
//                    for(T vertex : adjNodes.get(temp)){
//                        dFromSrc2Vertex = distances.get(vertex);
//                        if(distances.get(temp)/*(get func call returns distance from src to temp)*/+1/*(distance from
//                         temp to its shortest adjacent)*/<dFromSrc2Vertex || dFromSrc2Vertex<0){
//                            distances.put(vertex,distances.get(temp)+1);
//                        }
//                        if(!q.contains(vertex) && !checkList.contains(vertex)){
//                            q.offer(vertex);
//                        }
//                    }
//                }
//            }
//            q.clear();
//            System.out.println(distances);
//            return distances.get(dest);
//        }else{
//            return -1;
//        }
//    }
}
