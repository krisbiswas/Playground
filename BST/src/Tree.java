import java.util.ArrayDeque;
import java.util.Queue;

class Tree {
	Node root;
	Integer length;
	
	public void addNode(int data) {
		if(root == null) {
			root = new Node(data);
			return;
		}
		Node temp = root;
		boolean locFound = false;
		while(!locFound) {
			if(data < temp.data) {
				if(temp.left == null) {
					temp.left = new Node(data);
					locFound = true;
				}else {
					temp = temp.left;
				}
			}else {
				if(temp.right == null) {
					temp.right = new Node(data);
					locFound = true;
				}else {
					temp = temp.right;
				}
			}
		}
	}
	
	public void printTree() {
		if(root == null) {
			System.out.println("None");
		}
		Queue<Node> q = new ArrayDeque<>();
		Node temp = root;
		q.add(temp);
		while(!q.isEmpty()) {
			temp = q.poll();
			System.out.print(temp+" ");
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
		System.out.println();
	}
	
	public int findFloor(int data) {
		if(root == null) {
			System.out.println("None");
			return -1;
		}
		Node temp = root;
		int result=-1;
		while(temp != null) {
			while (temp!=null && temp.data > data) {
				temp = temp.left;
			}
			if(temp!=null) {
				if(temp.data == data) {
					return data;
				} else {
					result = temp.data;
					temp = temp.right;
				}
			}
		}
		return result;
	}
	
	public int findCeiling(int data) {
		if(root == null) {
			System.out.println("None");
			return -1;
		}
		Node temp = root;
		int result=-1;
		int iterations = 0;
		while(temp != null) {
			while (temp!=null && temp.data < data) {
				temp = temp.right;
				iterations++;
			}
			if(temp!=null) {
				if(temp.data == data) {
					result = data;temp=null;
				} else {
					result = temp.data;
					temp = temp.left;
				}
				iterations++;
			}
		}
		System.out.println(iterations);
		return result;
	}	
}
