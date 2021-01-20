/**
 * 
 */
package linkedlist;

/**
 * @author Sathyaa
 * @time Jan. 19, 2021
 * @url https://leetcode.com/problems/remove-linked-list-elements
 */
public class Q203_Remove_Linked_List_Elements {

	public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        
        while(head !=null && head.val ==val)
            head = head.next;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;
            if(curr.val == val){
                curr = next;
                if( prev != null)
                    prev.next = curr;
            }else{
                prev = curr;
                curr = next;
            }
        }
        System.gc();
        return head;
    }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = ListNode.getSampleIntegerInput();
		head = (new Q203_Remove_Linked_List_Elements()).removeElements(head, 1);
		ListNode.print(head);
	}

}
