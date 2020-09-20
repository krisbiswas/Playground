package com.kris.biswas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Krishnandu Biswas\\IdeaProjects\\" +
                "Binary Trees\\src\\com\\kris\\biswas\\inputs.txt");
        Scanner s = new Scanner(file);
        BTree tree = new BTree();
        BTree tree2 = new BTree();
//        BST tree = new BST();
        boolean exit = false;
        while (!exit){
            System.out.println("\n0: Add node\n1: print preOrder\n2: print inOrder\n4: Level Order\n" +
                    "5: Height\n6: Check for BST\n7: Remove\n8: Clear\n9: exit");
            switch(s.nextInt()){
                case 0:
                    System.out.print("Enter data to be added: ");
                    tree.addNode(s.nextInt());break;
                case 1:
                    //Iterative
                    tree.preOrder();
                    //Recursive
                    tree.preOrder(tree.root);
                    System.out.println();break;
                case 2:
                    //Iterative
                    tree.inOrder();
                    //Recursive
                    tree.inOrder(tree.root);
                    break;
                case 3:     //postOrder
                	int K;K = s.nextInt();
                	tree.K_distance_from_root(tree.root, K);
                    break;
                case 4:
                    tree.levelOrder();
                    break;
                case 5:
                    tree.treeHeight();break;
                case 6:
                    System.out.println(tree.checkBST(tree.root));
                    break;
                case 7:
                    System.out.print("Enter data to remove: ");
                    tree.remove(s.nextInt());break;
                case 8:
                    tree.clear();
                case 9:
                	System.out.println("No. Nodes in Primary Tree: ");
                	int n=s.nextInt();
                	while(s.hasNextInt() && n-->0) {
                		tree.addNode(s.nextInt());
                	}
                	System.out.println(tree+"\nNo. Nodes in Secondary Tree: ");
                	n=s.nextInt();
                	while(s.hasNextInt() && n-->0) {
                		tree2.addNode(s.nextInt());
                	}
                	System.out.println(tree2+"\nisSubTree"+BTree.isSubTree(tree.root,tree2.root));               	
                	break;
            	default:
            		System.out.println("It's done, BYE!");
                    exit = true;break;
            }
        }
        s.close();
    }
}
