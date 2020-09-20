package com.kris.biswas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\All Linked Lists\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner sc = new Scanner(file);
        SinglyLinkedList sll = new SinglyLinkedList();
        boolean exit = false;
        while(!exit) {
            System.out.println("0: add new Node\n1: insert Node\n2: print List\n3: remove node" +
                    "\n8: length\n9: EXIT");
            System.out.print("Enter your input here: ");
            switch (sc.nextInt()){
                case 0:
                    System.out.print("Enter data to add: ");
                    sll.add(sc.nextInt());break;
                case 1:
                    System.out.print("Enter index & data to insert: ");
                    sll.insert(sc.nextInt(),sc.nextInt());
                    break;
                case 2:
                    sll.printList();break;
                case 3:
                    System.out.print("Enter data to remove: ");
                    sll.remove(sc.nextInt());break;
                case 8:
                    System.out.println(sll.size());break;
                case 9:
                    exit = true;break;
            }
        }
        sc.close();
    }
}
