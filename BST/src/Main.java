import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("C:\\Users\\Krishnandu Biswas\\Documents\\eclipse-workspace\\BST\\src\\input");
		Scanner s = new Scanner(in);
		Tree bst = new Tree();
		for(int i=0;i<17;i++) {
			bst.addNode(s.nextInt());
		}
		bst.printTree();
		System.out.println(bst.findCeiling(100));
		s.close();
	}

}
