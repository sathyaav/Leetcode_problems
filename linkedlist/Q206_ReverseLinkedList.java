/**
 * 
 */
package linkedlist;

/**
 * @author Sathyaa
 * @time Jan. 19, 2021
 */
public class Q206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        
        return prev;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = {1,2,3,4,5};
		ListNode head = ListNode.convertArrayToList(input);
		head = (new Q206_ReverseLinkedList()).reverseList(head);
		ListNode.print(head);
	}

}
