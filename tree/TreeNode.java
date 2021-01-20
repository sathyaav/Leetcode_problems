package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(Integer val, TreeNode left, TreeNode right) {
       this.val = val;
        this.left = left;
        this.right = right;
    }
    
    TreeNode convertArrayToTreeNode ( Integer[] arr) {
        if (arr.length == 0) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        for (int i = 1; i < arr.length; i += 2) {
             TreeNode node = queue.poll();
             if(arr[i] != null )
            	 node.left = new TreeNode(arr[i]);
        	 if(i+1 < arr.length && arr[i+1] != null)
        		 node.right = new TreeNode(arr[i+1]);
        	 queue.add(node.left);
        	 queue.add(node.right);
         }
         
        return root;
    }
    
    ArrayList<Integer> convertTreeToArray( TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	if (root == null) return arr;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        arr.add(root.val);
        int i = 1;
        while(!queue.isEmpty()) {
        //for (int i = 1; i < arr.length; i += 2) {
             TreeNode node = queue.poll();
             if(node == null)
            	 continue;
             if(node.left != null)
            	 arr.add(i,node.left.val);
             else
            	 arr.add(i, null);
             
             if(node.right != null)
            	 arr.add(i+1 , node.right.val);
             else
            	 arr.add(i+1, null);
        	 queue.add(node.left);
        	 queue.add(node.right);
        	 i += 2;
         }
         
        return arr;
    	
    }
    
    //TreeNode buildTree()
}
