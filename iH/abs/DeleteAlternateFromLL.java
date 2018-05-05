package abs;

import abs.LinkedList;
import abs.LinkedList.Node;
/*
 * important { 1, 5, 2, 4, 3, 9 }
 * a wrong code: 
 * head.next = head.next.next; head 1 now 1->2
 * head = head.next.next; head was still 1 so here, 1.next is 2 so head will 
 * be calculated as  2.next, i.e 4, but should be 2
 * hence hold next head in temp var newHead
*/
public class DeleteAlternateFromLL {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(new Integer[] { 1, 5, 2, 4, 3, 9 });
		Node head = ll.getHead();
		Node last = ll.getLast();
		deleteAlternate(ll);
	}
	public static void deleteAlternate(LinkedList ll){
		Node head = ll.getHead();
		while(head!=null && head.next != null){
			// holding head.n.n is imp as if not done then next head will e
			// be 4 in place of 2
			Node newHead = head.next.next;
			head.next = newHead;
			head = newHead;
		}
		head = ll.getHead();
		while(head!=null){
			System.out.println(" .. "+head.data);
			head = head.next;
		}
	}
}
