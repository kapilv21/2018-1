package abs;

/*Determine the top 10 most frequently occurring words in a document*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*	
 * Go though all words and make a map of word and count
 * then loop through the map and add to pq<Pair> such that the size of pq is always k
 * pq is of pair and is min pq sorted on the freq
 * at the end the pq will have top k elements
*/
public class MostFreqWordInDocument {
	public static void main(String[] args) {
		String stream = "l l l l l i i i i i i i i j j j k k k k";
		//String stream = "l";
		printTopKWorkds(stream, 3);
	}
	// make a map of all words from the document
	static void printTopKWorkds(String doc, int k){
		// Base Case
		if(doc.length()==0){
			return;
		}
		// when only one element in document
		if(doc.length()==1){
			System.out.println(" only one element"+doc+" fre 1");
			return;
		}
		Map<String, Integer> map = new HashMap<>();
		for(String word : doc.split(" ")){
			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}else{
				map.put(word, 1);
			}
		}
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			System.out.println(" key "+entry.getKey()+" val "+entry.getValue());
		}
		// priority queue that holds "k" elements(notice the size in constructor
		// pq will be sorted on basis of freq
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
				k, new Comparator<Pair>(){ 
					public int compare(Pair a, Pair b){
						return a.freq - b.freq;
					}
				});
		
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if(pq.size()<k){
				pq.offer(new Pair(entry.getKey(), entry.getValue()));
			}else{
				Pair top = pq.peek();
				if(top.freq < entry.getValue()){
					pq.poll();
					pq.offer(new Pair(entry.getKey(), entry.getValue()));
				}
			}
		}
		while(!pq.isEmpty()){
			Pair top = pq.poll();
			System.out.println(" . "+top.word+" .. "+top.freq);
		}
}
}
class Pair{
	String word; int freq;
	public Pair(String word, int freq){
		this.word = word;
		this.freq = freq;
	}
}

