package codenvy.gl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class LRU_Java {
	public static void main(String[] args) {
		
		Cache cache = new Cache(2);
		/*cache.set(1);
		cache.set(2);
		cache.set(3);
		cache.set(4);
		cache.print();
		cache.set(5);
		cache.print();
		//cache.add(6);
		System.out.println("\nadd duplicate of 3 when 3 is front");
		cache.set(3);
		cache.print();
		System.out.println("\nadd duplicate of 2 when 2 is tail");
		cache.set(2);
		cache.print();
		cache.set(5);
		cache.print();*/
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		System.out.println(" pint ");
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
		
	}
}
/*
-  addNew - element will only be added at end
-  evict - for evey addition we need to maintain the size of lru = capacity, hence we delete the least recently use element i.e. from end
-  delete - if an element already exists then we need to delete it wheter from head, tail or middle and add to end calling addNew
*/
class Cache{
	Node head; Node tail;
	int size;
	HashMap<Integer, Node> map = new HashMap<>(); 
	int capacity;
	// DLL
	LinkedList<Node> ll = new LinkedList<>();
	public Cache(int capacity){
		if(capacity < 1){
			throw new UnsupportedOperationException(" Capacity should be more than \'0\'");
		}
		this.capacity = capacity;
	}

	/*if element is present make it recent, else check if chache is full then evict old and add this to front*/
	public void put(Integer key, Integer val){
		if(isPresent(key)){
			makeMostRecent(key);
		}else{
			if(isCacheFull()){
				evict();
			}
			addNew(key, val);
		}
	}
	
	public int get(int key){
		if(!isPresent(key)){
			System.out.println(" getting "+key+" val -1");
			return -1;
		}else{
			makeMostRecent(key);
		}
		System.out.println(" getting "+map.get(key).value);
		return map.get(key).value;
	}
	
	void evict(){
		Node n = ll.getLast();
		map.remove(n.key);
		ll.removeLast();
		size--;
	}
	
	boolean isCacheFull(){
		return size>=capacity;
	}
	
	boolean isPresent(Integer x){
		return map.containsKey(x);
	}
	
	void addNew(int key, int val){
		Node node = new Node(key, val);
		map.put(key, node);
		ll.addFirst(node);
		size++;
	}
	
	void makeMostRecent(Integer x){
		Node current = map.get(x);
		ll.remove(current);
		ll.addFirst(current);
	}
	
	void print(){
		Iterator<Node> it = ll.iterator();
		while(it.hasNext()){
			System.out.print(it.next().value+" ->");
		}
		System.out.println();
	}
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
}
