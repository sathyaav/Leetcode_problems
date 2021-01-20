/**
 * 
 */
package tree;

/**
 * @author Sathyaa
 * @time Nov. 16, 2020
 * https://leetcode.com/problems/range-sum-of-bst/
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 */
public class Q938_RangeSumBST {
	int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
         if(root.val >= low && root.val <= high) {
            sum = sum + root.val;
             rangeSumBST(root.left, low, high);
             rangeSumBST(root.right, low, high);
        } 
        if (root.val < low) {
            rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
        return sum;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
