package abs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class KeyValueMills {
	
	public static void main(String[] args) {
		
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		map.put(10, new Pair(25,5000L));
		long timeMillis = System.currentTimeMillis();
		Date d1 = new Date(timeMillis);
		long seconds = d1.getSeconds();
		
		Long value = seconds - map.get(10).getSecond()<5? null:map.get(10).getSecond();  
		System.out.println(" current time seconds "+seconds+" from map is "+value);
}
	static private class Pair{
		private Integer first;
		private Long second;
		public Pair(Integer first, Long second){
			this.first = first;
			this.second = second;
		}
		public long getSecond(){
			return second;
		}
	}
}
class MyComparator<Pair> implements Comparator<Pair> {

    public int compare(Pair emp1, Pair emp2){
       return 1;
    }
}




