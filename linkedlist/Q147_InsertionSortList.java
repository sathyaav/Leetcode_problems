/**
 * https://leetcode.com/problems/insertion-sort-list/
 * Sort a linked list using insertion sort.
 */
package linkedlist;

/**
 * @author Sathyaa
 * @time Nov. 2, 2020
 */
public class Q147_InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
        
		if(head == null) return null;
		
		
		ListNode newHead;
		ListNode oldPrevNode;
		ListNode newPrevNode;
		ListNode temp;
		
		temp = head.next;
		oldPrevNode = head;
		newHead = head;
		
		
		while(temp != null) {
			//if()
		}
		
		
		
		return head;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {6,5,3,1,8,7,2,4};
		

	}

}
