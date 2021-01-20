/**
 * 
 */
package linkedlist;
/**
 * @author Sathyaa
 * @time Jan. 20, 2021
 * problem_statement:
 * problem_url:
 * time_complexity:
 * space_complexity:
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
		while(l1Curr != null) {
			curr.next = l1Curr;
			curr = curr.next;
			l1Curr = l1Curr.next;
		}
		while(l2Curr != null) {
			curr.next = l2Curr;
			curr = curr.next;
			l2Curr = l2Curr.next;
		}
		
		return head.next;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr1 = {};
		Integer[] arr2 = {};
		ListNode l1 = ListNode.convertArrayToList(arr1);
		ListNode l2 = ListNode.convertArrayToList(arr2);
		ListNode h = (new Q21_MergeLinkedList()).mergeTwoLists(l1, l2);
		ListNode.print(h);

	}

}
