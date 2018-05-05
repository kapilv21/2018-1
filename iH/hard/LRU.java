package GI.hard;

import java.util.LinkedHashMap;
import java.util.Map;
public class LRU {
	public static void main(String[] args) {
		LRU c = new LRU(4);
		map.put(0, 5);
		map.put(1, 6);
		map.put(2, 7);
		map.put(3, 8);
		map.put(4, 9);
		map.put(5, 10);

	    System.out.println("" + map);
	     
	   }
	
    private static LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRU(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}