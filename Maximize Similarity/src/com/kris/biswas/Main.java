package com.kris.biswas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void maximumSimilarity(int[] a,int K){
        int least;
        int leastIndex;
        int noZeros = 0;
        while(noZeros < 2){
            leastIndex = 0;
            least = a[0];
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            noZeros = 0;
            int count= 0;
            for (int i = 0; i < a.length; i++) {
                if (least > a[i]) {
                    least = a[i];
                    leastIndex = i;
                }
                if (a[i] == 0) {
                    noZeros++;
                }
                if(i+1<a.length && a[i]==a[i+1]){
                    count++;
                }
            }
            if(count == a.length-1){
                System.out.println(a.length);return;
            }
            if (noZeros < 2) {
                a[leastIndex] += K;
                for (int i = 0; i < a.length; i++) {
                    if (i != leastIndex) {
                        a[i] = a[i] - K;
                    }
                }
            }
        }

        int maxCount = 0;
        System.out.print("Count: " );
        for(int i = 0;i<a.length;i++){
            int count=0;
            for(int j = 0;j<a.length;j++){
                if(a[i] == a[j]){
                    count++;
                }
            }
            if(maxCount < count){
                maxCount = count;
            }
            System.out.print(a[i]+" ");
        }
        System.out.println("\n"+maxCount);
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream f= new FileInputStream("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\Maximize Similarity\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner scan = new Scanner(f);
//        System.out.print("Size of Array: ");
        int N = scan.nextInt();
        int K = scan.nextInt();
	    int[] a = new int[N];
	    for(int i = 0;i < N;i++){
	        a[i] = scan.nextInt();
        }
	    maximumSimilarity(a,K);
        scan.close();
    }
}
