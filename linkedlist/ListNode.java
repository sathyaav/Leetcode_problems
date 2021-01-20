package linkedlist;

import java.util.ArrayList;
import java.util.Random;

public class ListNode {
	     int val;
	     ListNode next;
	     
	     ListNode() {}
	     ListNode(int val) { this.val = val; this.next =null;}
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     
	     
	     static ListNode convertArrayToList(Integer[] arr) {
	    	 ListNode node = null;
	    	 ListNode head = null;
	    	 for(int i : arr) {
	    		 if(head == null) {
	    			 node = new ListNode(i);
	    			 head = node;
	    		 }else {
	    			 node.next = new ListNode(i);
	    			 node = node.next;
	    	    	 
	    		 }
	    	}
	    	 
	    	 return head;
	    	 
	     }
	     
	     static void print(ListNode head) {
	    	 ListNode temp = head;
	    	 while(temp != null) {
	    		 System.out.print(temp.val);
	    		 if(temp.next != null)
	    			 System.out.print(" -> ");
	    		 temp= temp.next;
	    	 }
	     }
	     
	     static ListNode getSampleIntegerInput() {
	    	 Random r = new Random();
	    	 int total = Math.abs(r.nextInt(10));
	    	 System.out.println("total: "+total);
	    	 ArrayList<Integer> arr=new ArrayList<Integer>(total);
	    	 while(total-- >0) {
	    		 arr.add(r.nextInt(10));
	    	 }
	    	
	    	 ListNode node = null;
	    	 ListNode head = null;
	    	 
	    	 for(int ele : arr) {
	    		 if(node==null) {
	    			 node = new ListNode(ele);
	    			 head = node;
	    		 }
	    		 else {
	    			 node.next = new ListNode(ele);
	    			 node = node.next;
	    		 }
	    	 }
	    	 System.out.println("Input: ");
	    	 ListNode.print(head);
	    	 System.out.println();
	    	 
	    	 return head;
	     
	     }
}
