package tree;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthOfBT {
	static Integer hmin=Integer.MAX_VALUE;
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        int ht = 1;
        while(!level.isEmpty()) {
            int qsize = level.size();
            TreeNode temp;
            for(int i = 0; i < qsize; ++i) {
                temp = level.poll();
                
                if(temp.left == null && temp.right == null)
                    return ht;
                
                if(temp.left != null)
                    level.add(temp.left);
                
                if(temp.right != null)
                    level.add(temp.right);
            }
            ht++;
        }
        return ht;
    }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
