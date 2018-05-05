package GI.hard;

import java.util.HashMap;
import java.util.LinkedList;

public class JavaDLLDemo {
	public static void main(String[] args) {
		LinkedList<Integer> dl = new LinkedList<>();
		dl.addFirst(1);
		dl.addFirst(2);
		dl.addFirst(3);
		dl.get(1);
		HashMap<Integer, Nodex> map = new HashMap<>(); 
		Nodex ob1 = new Nodex(1);
		map.put(1, ob1 );
		map.put(2, new Nodex(2));
		map.remove(1);
		System.out.println("map size "+map.size());
	}
}
class Nodex{
	int data;
	Nodex next;
	Nodex prev;
	public Nodex(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}