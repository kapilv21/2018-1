package GI;

public class LinkedList {
	public LinkedList(){}
	Node first;
	Node last;
	public LinkedList(Integer[] ar){
		first = null;
		
		Node prev = null;
		for(Integer elem : ar){
			//head.data = elem;
			Node current = new Node(elem);
			if(prev != null){
				prev.next = current;
				System.out.println(" prev "+prev.data+" --> "+prev.next.data);
			}
			if(first == null){
				first = current;
			}
			//head = current;
			prev = current;
		}
	}
	public Node getHead(){
		System.out.println(" returning head of LL as "+first.data);
		return first;
	}
	
	public Node getLast(){
		last = first;
		if(last == null){
			return last;
		}
		while(last.next != null){
			last = last.next;
		}
		System.out.println(" returning tail of LL as "+last.data);
		return last;
	}
	class Node{
		Integer data;
		Node next;
		public Node(){
			
		}
		public Node(Integer data){
			this.data = data;
		}
	}
}
/*private class Node{
	Integer data;
	Node next;
	public Node(){
		
	}
	public Node(Integer data){
		this.data = data;
	}
}*/