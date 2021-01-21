/**
 * 
 */
package linkedlist;
/**
 * @author Sathyaa
 * @time Jan. 19, 2021
 * problem_statement:Given a singly linked list, determine if it is a palindrome.
 * problem_url:https://leetcode.com/problems/palindrome-linked-list
 * time_complexity: O(n)
 * space_complexity: O(1)
 * level: Easy`
 */
public class Q234_PalindromLinkedList {
	public boolean isPalindrome(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;
        if(head == null || head.next == null)
            return true;
        if(head.next.next == null){
            if(head.val == head.next.val) return true;
            return false;
        }
        ListNode prev = null;
        ListNode next = null;
        
        while(fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            next = slowptr.next;
            slowptr.next = prev;
            prev = slowptr;
            slowptr = next;
        }
        if(fastptr!=null){
        	slowptr = slowptr.next;
        }
        
        while(prev !=null && slowptr != null){
            if(prev.val != slowptr.val)
                return false;
            prev = prev.next;
            slowptr = slowptr.next;
        }
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head;
		
		
		Integer[] arr = {2};
		head = ListNode.convertArrayToList(arr);
		System.out.println((new Q234_PalindromLinkedList()).isPalindrome(head));
	}
}
