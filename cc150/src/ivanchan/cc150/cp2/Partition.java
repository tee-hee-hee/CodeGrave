package ivanchan.cc150.cp2;

import java.util.*;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
    	ListNode largeHead = null;
    	ListNode smallHead = null;
    	
        if(pHead != null){        	
        	ListNode large = null;
        	ListNode small = null;
        	
        	ListNode node = pHead;
        	while(node != null){
        		if(node.val < x){
        			if(small == null){
        				smallHead = node;
        			}
        			if(small != null){
        				small.next = node;
        			}        			
        			small = node;        			      			
        		}else{
        			if(large == null){
        				largeHead = node;
        			}
        			if(large != null){
        				large.next = node;
        			}
        			large = node;        			
        		}
        		
        		node = node.next;
        	}
        	if(large != null){
        		large.next = null;
        	}
        	
        	if(smallHead == null){
        		smallHead = largeHead;
        	}else{
        		small.next = largeHead;
        	}
        	       	
        }
        
        return smallHead;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(0);
		ListNode l6 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = new Partition().partition(l1, 5);
	}
}
