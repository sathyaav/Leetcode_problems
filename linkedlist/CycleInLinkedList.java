package linkedlist;
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
		
		
https://leetcode.com/problems/linked-list-cycle-ii/

*/


public class CycleInLinkedList {

	public ListNode detectCycle(ListNode head) {
        if(head == null)
        	return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean cycle = false;
        while(fastPointer != null && fastPointer.next!=null ) {
        	fastPointer = fastPointer.next.next;
        	slowPointer = slowPointer.next;
        	if(slowPointer==fastPointer) {
        		
        		slowPointer = head;
        		cycle = true;
        		break;
        	}
        		
        		
        }
		
        if(!cycle)
        	return null;
        while(slowPointer != fastPointer) {
        	
        	slowPointer = slowPointer.next;
        	fastPointer = fastPointer.next;
        	
        }
		
		return slowPointer;
    }

	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = d;
		
		CycleInLinkedList obj = new CycleInLinkedList();
		ListNode cycNode = obj.detectCycle(a);
		System.out.println(cycNode.val);

	}

}
