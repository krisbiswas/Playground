
class Node {
	Integer data;
	Node left;
	Node right;
	
	Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}
	
}
