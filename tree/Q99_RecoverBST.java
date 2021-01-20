package tree;

/**
 * @author Sathyaa
 * @time Oct. 31, 2020
 */


public class Q99_RecoverBST extends TreeNode{
	
	public void recoverTree(TreeNode root) {
		if(root == null) return;
		Node mem = new Node();
		inorderTraversal(root, mem);
		
		// swap both nodes
		Integer temp = mem.firstNode.val;
		mem.firstNode.val = mem.secondNode.val;
		mem.secondNode.val = temp;
	}
	/**
	 * @param current node
	 * @param mem of node visited
	 */
	private void inorderTraversal(TreeNode node, Node mem) {

		if(node == null) return;
		inorderTraversal(node.left,  mem);
		
 		if( mem.prevNode != null && mem.prevNode.val > node.val && mem.firstNode == null )
 			mem.firstNode = mem.prevNode;
		
		if(  mem.prevNode != null && mem.prevNode.val > node.val && mem.firstNode != null )
			mem.secondNode = node;
		mem.prevNode = node;
		
		inorderTraversal(node.right, mem);
		
	}
	private static class Node{
		TreeNode prevNode;
		TreeNode firstNode;
		TreeNode secondNode;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Q99_RecoverBST obj = new Q99_RecoverBST();
		//Integer[] arr = {2,3,1};  // 1 3
		//Integer[] arr = {2,3,4,null,null,1}; // 1 3
		//Integer[] arr = {1,3,null,null,2}; // 1 3
		//Integer[] arr = {3,1,4,null,null,2};  //  2 3 swap
		//Integer[] arr = {10,0,5,null,null,null,1};  // 1,10
		Integer[] arr = {10,15,20,null,null,null,null};  // 10 15
		//Integer[] arr = {146,71,-13,55,null,231,399,321,null,null,null,null,null,-33};
		TreeNode root = obj.convertArrayToTreeNode(arr);
		obj.recoverTree(root);
		
		//Integer[] output = obj.convertTreeToArray(root);
		for( Integer i: obj.convertTreeToArray(root)) {
			System.out.print(i +" ");
		}
	}

}
