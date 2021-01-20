/**
 * 
 */
package linkedlist;
/**
 * @author Sathyaa
 * @time Jan. 19, 2021
 * problem_statement: Given a singly linked list, group all odd nodes together followed by the even nodes.
 * problem_url: https://leetcode.com/problems/odd-even-linked-list/
 * time_complexity: O(n)
 * space_complexity: O(1)
 */
public class Q328_odd_even_linkedlist {

	 public ListNode oddEvenList(ListNode head) {
	        
	        if(head == null || head.next == null || head.next.next == null)
	            return head;
	        
	        ListNode curr = head;
	        ListNode head1 = null;
	        ListNode oddCurr = null;
	        ListNode head2 = null;
	        ListNode evenCurr = null;
	        ListNode tempNode = null;
	        int i=1;
	        
	        while(curr != null){
	            if( i%2 != 0){
	                if(head1 == null){
	                    head1 = curr;
	                    oddCurr = head1;
	                }else{
	                    oddCurr.next = curr;
	                    oddCurr = oddCurr.next;
	                }
	            }else{
	                if(head2 == null){
	                    head2 = curr;
	                    evenCurr = head2;
	                }else{
	                    evenCurr.next = curr;
	                    evenCurr = evenCurr.next;
	                }
	            }
	            tempNode = curr.next;
	            curr.next = null;
	            curr = tempNode;
	            i++;
	        }
	        oddCurr.next = head2;
	        return head;
	        
	    }
}
