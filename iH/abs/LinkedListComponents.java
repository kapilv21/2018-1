package abs;

import java.util.HashSet;
import java.util.Set;

import GI.LinkedList.Node;
// SELF CREATED, NEED REVIEW

public class LinkedListComponents {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8});
		Set<Integer> set = new HashSet<>();
		//input 1,3,2,5
		set.add(1);set.add(3);set.add(2);set.add(6);

		Node head = ll.getHead(); 
		int count =0;
		while(head!=null){
			Node startHead = head;
			// move head until we can find next element
			while(head!=null && set.contains(head.data)){
				head = head.next;
			}
			// if we were able to find n elements connected or even 1 count++
			if (head !=startHead){
				count++;
			}
			if(head!=null){
				head = head.next;
			}
		}
		System.out.println(count);
	}
	
}
