package ivanchan.cc150.cp2;

public class CheckPalindromeLinklist {
	public boolean isPalindrome(ListNode pHead) {
        // write code here
		ListNode reverseHead = reverseAndBuildLinklist(pHead);
		
		while(pHead != null){
			if(pHead.val != reverseHead.val){
				return false;
			}
			pHead = pHead.next;
			reverseHead = reverseHead.next;
		}
		
		return true;
    }
	
	private ListNode reverseAndBuildLinklist(ListNode head){
		ListNode newHead = null;
		if(head != null){
			ListNode node = head;
			
			while(node != null){
				ListNode temp = new ListNode(node.val);
				temp.next = newHead;
				newHead = temp;
				node = node.next;
			}
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		Boolean head = new CheckPalindromeLinklist().isPalindrome(l1);
		
		System.out.println();
	}
}
