package ivanchan.cc150.cp2;

/**
 * 
 * @author IvanChan
 *
 */
public class PlusTwoLinklist {
	
	public ListNode plus(ListNode a, ListNode b) {
        // write code here
		if(a == null || b == null){
			return a == null ? b : a;
		}
		ListNode sumListHead = null;
		ListNode sumList = null;
		int toUp = 0;
		while(a!=null && b!=null){
			int c = a.val + b.val + toUp;
			ListNode node = new ListNode(c%10);
			
			if(sumListHead == null){
				sumListHead = node;
				sumList = node;
			}else{
				sumList.next = node;
			}			
			sumList = node;
			
			toUp = c/10;			
			a = a.next;
			b = b.next;			
		}
		while(a!=null){
			int c = a.val + toUp;
			ListNode node = new ListNode(c%10);
			sumList.next = node;
			sumList = node;
			toUp = c/10;			
			a = a.next;
		}

		while(b!=null){
			int c = b.val + toUp;
			ListNode node = new ListNode(c%10);
			sumList.next = node;
			sumList = node;
			toUp = c/10;			
			b = b.next;
		}
		
		if(toUp != 0){
			ListNode node = new ListNode(toUp);
			sumList.next = node;
		}
		
		return sumListHead;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		
		ListNode l5 = new ListNode(0);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ListNode head = new PlusTwoLinklist().plus(l1, l5);
		
		System.out.println();
	}

}