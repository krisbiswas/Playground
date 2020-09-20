package com.kris.biswas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> removeRedundancy(ArrayList<Integer> arrayList){
        ArrayList<Integer> sorted = new ArrayList<>();
        for (Integer integer : arrayList) {
            boolean found = false;
            for (Integer value : sorted) {
                if (value.equals(integer)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                sorted.add(integer);
            }
        }
        return arrayList=sorted;
    }
    private static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList){
        int iMin = 0;
        for(int i=0;i<arrayList.size()-1;i++){      //Iterating complete list till second last element
            iMin = i;                           //local var to store index of min value in ith iteration
            for(int j = i+1;j < arrayList.size();j++){  //searching for min value above current index
                if(arrayList.get(j) <= arrayList.get(iMin)){
                    iMin = j;
                }
            }
            Integer temp = arrayList.get(iMin);         //swapping ith(min value index) value with assumed iminth index value
            arrayList.set(iMin,arrayList.get(i));
            arrayList.set(i,temp);
        }
        return arrayList;
    }
    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList){
        boolean swapped = false;
        do {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) > arrayList.get(i + 1)) {
                    arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
                    arrayList.set(i + 1, arrayList.get(i) - arrayList.get(i + 1));
                    arrayList.set(i, arrayList.get(i) - arrayList.get(i + 1));
                    swapped = true;
                }else{
                    swapped = false;
                }
            }
        }while(swapped);
        return arrayList;
    }
    private static ArrayList<Integer> insertionSort(ArrayList<Integer> array){
        for(int i = 1;i<array.size();i++){
            int value = array.get(i);
//            int hole = i;
//            while(hole>0 && array.get(hole-1) > value){
//                array.set(hole , array.get(hole-1));
//                hole--;
//            }
//            array.set(hole,value);
            int j;
            for(j = i;j > 0 && value < array.get(j-1); j--){
                array.set(j , array.get(j-1));
            }
            array.set(j,value);
        }
        return array;
    }
    private static void merge(List<Integer> array1,int[] t,int left,int mid,int rigtht){
        int i = left;
        int j = mid;
        int k = left;
        while(i<=mid-1 && j<=rigtht){
            if(array1.get(i)>array1.get(j)){
//                temp.add(k,array1.get(j));
                t[k] = array1.get(j);
                j++;
            }else if(array1.get(i) < array1.get(j)){
//                temp.add(k,array1.get(i));
                t[k] = array1.get(i);
                i++;
            }
            k++;
        }
        while (i<mid){
//            temp.add(k,array1.get(i));
            t[k] = array1.get(i);
            i++;k++;
        }
        while (j<=rigtht){
            t[k] = array1.get(j);
//            temp.add(k,array1.get(j));
            j++;k++;
        }
    }
    private static void MergeSort(List<Integer> array,int[] temp,int left,int right){
        int mid;
        if(right>left){
            mid = (left+right)/2;
            MergeSort(array,temp,left,mid);
//            System.out.println(temp);
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i]+" ");
            }
            MergeSort(array,temp,mid+1,right);
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i]+" ");
            }
            merge(array,temp,left,mid+1,right);
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        List<Integer> ar = new LinkedList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        File file = new File("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\Sort Algo\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            ar.add(sc.nextInt());
        }
        int[] temp = new int[ar.size()];
//        System.out.println(ar+" "+ar.size()+"\n");
//        MergeSort(ar,temp,0,ar.size()-1);
//        System.out.println(temp.toString()+"\n");
//        System.out.println(removeRedundancy(ar)+"\n");

        System.out.println(ar);
//        System.out.println(selectionSort(ar)+"\n");
        System.out.println(bubbleSort(ar));
//        System.out.println(ar);
    }
}
