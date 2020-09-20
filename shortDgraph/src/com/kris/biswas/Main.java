package com.kris.biswas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\Graph1\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner scan = new Scanner(file);

        Graph<Integer> g = new Graph<>();

        int noOfVertex = scan.nextInt();
        int vertexCount = 0;
        //for adding vertices of graph
        while(vertexCount != noOfVertex){
            Integer val = scan.nextInt();
//            char val = scan.nextInt();
            if(!g.containsVertex(val)){
                g.addVertex(val,new LinkedList<>());        //adding new vertex
            }
            vertexCount++;
        }
        //For adding edges of each node/vertex
        while(vertexCount>0){
            Integer val = scan.nextInt();
            int noEdges = scan.nextInt();
            for(int i = 0;i<noEdges;i++){               //adding outgoing edges of the current vertex
                int c = scan.nextInt();
                if(g.containsVertex(c)){
                    g.addEdge(val,c);
                }else{
                    System.out.println("No such Vertex exists!");
                    i--;
                }
            }
            vertexCount--;
        }

//        g.showAdjacencyLists();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <=5 ; j++) {
                System.out.println(i+","+j+" : "+g.getDistance(i,j));
            }
            System.out.println();
        }

    }
}
