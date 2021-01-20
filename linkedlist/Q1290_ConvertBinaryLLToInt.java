package linkedlist;
/**
 * 
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880

 */

/**
 * @author Sathyaa
 * @time Nov. 1, 2020
 */
public class Q1290_ConvertBinaryLLToInt{
	public int getDecimalValue(ListNode head) {
		int num = head.val;
		ListNode node = head.next;
		while(node.next != null) {
			num = (num << 1) | node.val;
			node = node.next;
		}
        return num;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Integer[] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		Integer[] arr = {1,0,1,0,1};
		ListNode head = ListNode.convertArrayToList(arr);
		ListNode.print(head);
		Q1290_ConvertBinaryLLToInt obj = new Q1290_ConvertBinaryLLToInt();
		System.out.println(obj.getDecimalValue(head));

	}

}
