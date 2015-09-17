package ivanchan.leetcode.title148;

public class SortList {
	/*
	 * Time Limit Exceeded 
	 * 
	 * public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
		ListNode provit = head;
		ListNode newHead = null;
		ListNode current = head;
		while( current.next != null){
			if(current.next.val < provit.val){
				ListNode temp = current.next;
				current.next = temp.next;
				temp.next = newHead;
				newHead = temp;
			}else{
				current = current.next;
			}
						
		}
		
		ListNode beforeHead = sortList(newHead);
		ListNode afterHead = sortList(provit.next);
		
		ListNode beforeEnd = beforeHead;
		while(beforeEnd != null && beforeEnd.next != null){
			beforeEnd = beforeEnd.next;
		}
		if(beforeEnd != null){
			beforeEnd.next = provit;
		}else{
			beforeHead = provit;
		}
		provit.next = afterHead;
		
		return beforeHead;
    }
    */
	
	public ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode mid = getMid(head);
		ListNode right = null;
		if( mid != null){
			right = mid.next;
			mid.next = null;
		}
		
		head = sortList(head);
		right = sortList(right);
		
		head = merge(head,right);
		
		return head;
	}
	
	public static ListNode getMid(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static ListNode merge(ListNode leftHead, ListNode rightHead){
		if(leftHead == null || rightHead == null){
			return leftHead == null ? rightHead : leftHead;
		}
		ListNode head = null;
		ListNode node = null;
		while(leftHead  != null && rightHead != null){
			ListNode temp = null;
			if(leftHead.val > rightHead.val){
				temp = rightHead;
				rightHead = rightHead.next;
			}else{
				temp = leftHead;
				leftHead = leftHead.next;
			}
			if(node == null){
				head = temp;
				node = temp;
			}else{
				node.next = temp;
				node = node.next;
			}
		}
		
		if(leftHead != null){
			node.next = leftHead;
		}
		if(rightHead != null){
			node.next = rightHead;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(2);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
	
		
		ListNode res = new SortList().sortList(l1);
		
		System.out.println(res.val);
	}
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
