/**
 * 
 */
package linkedlist;
/**
 * @author Sathyaa
 * @time Jan. 20, 2021
 * problem_statement: Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * problem_url: https://leetcode.com/problems/merge-two-sorted-lists/	
 * time_complexity: O(n)
 * space_complexity: O(1)
 */
public class Q21_MergeLinkedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l1Curr=l1;
		ListNode l2Curr=l2;
		ListNode curr = new ListNode();
		ListNode head= curr;
		
		while(l1Curr !=null  && l2Curr != null) {
			
			if(l1Curr.val < l2Curr.val) {
				curr.next = l1Curr;
				l1Curr = l1Curr.next;
			}else {
				curr.next = l2Curr;
				l2Curr = l2Curr.next;
			}
			curr = curr.next;
			
		}
		if(l1Curr == null) {
			curr.next = l2Curr;
		}
		if(l2Curr == null) {
			curr.next = l1Curr;
		}
	
		return l1;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr1 = {1,3,5,7};
		Integer[] arr2 = {1,3,4,5,6,7};
		ListNode l1 = ListNode.convertArrayToList(arr1);
		ListNode l2 = ListNode.convertArrayToList(arr2);
		ListNode h = (new Q21_MergeLinkedList()).mergeTwoLists(l1, l2);
		ListNode.print(h);

	}

}
