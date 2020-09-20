package com.kris.biswas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList){
        while(true) {
            boolean swapped = false;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) > arrayList.get(i + 1)) {
                    arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
                    arrayList.set(i + 1, arrayList.get(i) - arrayList.get(i + 1));
                    arrayList.set(i, arrayList.get(i) - arrayList.get(i + 1));
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arrayList;
    }
    private static Integer binarySearch(Object[] array,int data){
        int start = 0,last = array.length-1;
        while(true) {
            int mid = (start + last) / 2;
            if(mid == start){
                return -1;
            }
            if ((int) array[mid] > data) {
                last = mid;
            } else if ((int) array[mid] < data) {
                start = mid;
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\Search Algos\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner sc = new Scanner(file);
        ArrayList ar = new ArrayList();
        while(sc.hasNextInt()){
            ar.add(sc.nextInt());
        }
        bubbleSort(ar);
        System.out.println(ar);
        System.out.println("Index: "+binarySearch(ar.toArray(),23));
    }
}
