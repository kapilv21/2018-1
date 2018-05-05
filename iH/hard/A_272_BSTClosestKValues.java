package GI.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_272_BSTClosestKValues {
	public static void main(String[] args) {
		Node tree = new Node(50);
		tree.left = new Node(25);
		tree.right = new Node(100);
		tree.left.left = new Node(24);
		tree.left.right = new Node(28);
		tree.left.right.left = new Node(22);
		tree.left.right.left.right= new Node(26);
		tree.left.right.left.right.right= new Node(27);
		tree.left.right.right = new Node(35);
		// max pq
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
		       public int compare(Pair n1, Pair n2) {
		           return n2.value - n1.value;
		       }
		    });
		//pq.offer(new Pair(Math.abs(tree.data-28), tree));
		getKClosestOpt(tree, 28, pq, 3);
		while(!pq.isEmpty()) {
			System.out.println(" .. "+pq.poll().n.data);
		}
	}
	
	static void getKClosest(Node n, int key, PriorityQueue<Pair> pq, int k) {
		if(n == null) { return;}
		if(pq.size()< k) {
			pq.offer(new Pair(Math.abs(n.data-key), n));
		}else {
			if(pq.peek().value > Math.abs(n.data-key)) {
				pq.poll();
				pq.offer(new Pair(Math.abs(n.data-key), n));
			}
		}
		getKClosest(n.left, key, pq, k);
		getKClosest(n.right, key, pq, k);
	} 
	
	// NOT WORKING, tihs is not good idea
	
	static void getKClosestOpt(Node n, int key, PriorityQueue<Pair> pq, int k) {
		if(n == null) { return;}
		if(pq.size()< k) {
			pq.offer(new Pair(Math.abs(n.data-key), n));
			getKClosestOpt(n.left, key, pq, k);
			getKClosestOpt(n.right, key, pq, k);
		}else if(pq.size() >= k) {
			int currTop = pq.peek().value;
			System.out.println(" here "+currTop);
			if(pq.peek().value > Math.abs(n.data-key)) {
				pq.poll();
				pq.offer(new Pair(Math.abs(n.data-key), n));
			}
			currTop = pq.peek().value;
			if(n.data == key) {
				getKClosestOpt(n.left, key, pq, k);
				getKClosestOpt(n.right, key, pq, k);
			}else if((n.data - key)<0 && Math.abs(n.data - key)>currTop) {
				getKClosestOpt(n.right, key, pq, k);
			}else if((n.data - key)>0 && Math.abs(n.data - key)>currTop) {
				getKClosestOpt(n.left, key, pq, k);
			}
		}
	} 
	
}
class Pair{
	Integer value;
	Node n;
	public Pair(int value, Node n) {
		this.value = value;
		this.n= n;
	}
}

class Node {
	int data;
	Node left, right;

	public Node(int d) {
		data = d;
		left = right = null;
	}
}