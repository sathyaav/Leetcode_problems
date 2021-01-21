/**
 * 
 */
package linkedlist;
/**
 * @author Sathyaa
 * @time Jan. 20, 2021
 * problem_statement: Merge all the linked-lists into one sorted linked-list and return it.
 * problem_url: https://leetcode.com/problems/merge-k-sorted-lists/
 * time_complexity: O(nlogk) - divide and conquer method
 * space_complexity: O(1)
 * Another solution is to create a min priority queue and create a new list. will occupy extra space. 
 */
public class Q23_MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr1 = {1,2,3};
		Integer[] arr2 = {1,3,5};
		Integer[] arr3 = {3,5,7,9};
		Integer[] arr4 = {5,6,7,8};
		Integer[] arr5 = {1,4,7,9,12};
		ListNode l1 = ListNode.convertArrayToList(arr1);

		ListNode l2 = ListNode.convertArrayToList(arr2);
		ListNode l3 = ListNode.convertArrayToList(arr3);
		ListNode l4 = ListNode.convertArrayToList(arr4);
		ListNode l5 = ListNode.convertArrayToList(arr5);
		ListNode[] lists = new ListNode[4];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		lists[3] = l4;
		//lists[4] = l5;
		
		ListNode head = (new Q23_MergeKSortedLists()).mergeKLists(lists);
		
		
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
	    int k = lists.length;
	    if(k < 1)
	    	return null;
	    
	    int i=0;
	    k = k-1;
	    while(k!=0) {
	    	//merging small lists
	    	lists[i] = mergeTwoLists(lists[i],lists[k]);
	    	i++;
	    	k--;
	    	
	    	//if both reaches same lists, reset i back to start
	    	if(i >= k){
	    		i =0;
	    	}
	    }
	    
	    return lists[0];
	 
	}
	
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l1Curr=l1;
		ListNode l2Curr=l2;
		ListNode curr = new ListNode(); //dummy node
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
 	
		
		return head.next;
    } 

}
